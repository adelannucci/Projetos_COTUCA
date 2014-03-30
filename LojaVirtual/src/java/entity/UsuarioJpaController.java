/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.exceptions.NonexistentEntityException;
import entity.exceptions.PreexistingEntityException;
import entity.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Compra;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.UserTransaction;
import model.Carrinho;
import model.Usuario;

/**
 *
 * @author u11248
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (usuario.getCompraList() == null) {
            usuario.setCompraList(new ArrayList<Compra>());
        }
        if (usuario.getCarrinhoList() == null) {
            usuario.setCarrinhoList(new ArrayList<Carrinho>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<Compra> attachedCompraList = new ArrayList<Compra>();
            for (Compra compraListCompraToAttach : usuario.getCompraList()) {
                compraListCompraToAttach = em.getReference(compraListCompraToAttach.getClass(), compraListCompraToAttach.getIdcompra());
                attachedCompraList.add(compraListCompraToAttach);
            }
            usuario.setCompraList(attachedCompraList);
            List<Carrinho> attachedCarrinhoList = new ArrayList<Carrinho>();
            for (Carrinho carrinhoListCarrinhoToAttach : usuario.getCarrinhoList()) {
                carrinhoListCarrinhoToAttach = em.getReference(carrinhoListCarrinhoToAttach.getClass(), carrinhoListCarrinhoToAttach.getIdcarrinho());
                attachedCarrinhoList.add(carrinhoListCarrinhoToAttach);
            }
            usuario.setCarrinhoList(attachedCarrinhoList);
            em.persist(usuario);
            for (Compra compraListCompra : usuario.getCompraList()) {
                Usuario oldUsuarioOfCompraListCompra = compraListCompra.getUsuario();
                compraListCompra.setUsuario(usuario);
                compraListCompra = em.merge(compraListCompra);
                if (oldUsuarioOfCompraListCompra != null) {
                    oldUsuarioOfCompraListCompra.getCompraList().remove(compraListCompra);
                    oldUsuarioOfCompraListCompra = em.merge(oldUsuarioOfCompraListCompra);
                }
            }
            for (Carrinho carrinhoListCarrinho : usuario.getCarrinhoList()) {
                Usuario oldUsuarioOfCarrinhoListCarrinho = carrinhoListCarrinho.getUsuario();
                carrinhoListCarrinho.setUsuario(usuario);
                carrinhoListCarrinho = em.merge(carrinhoListCarrinho);
                if (oldUsuarioOfCarrinhoListCarrinho != null) {
                    oldUsuarioOfCarrinhoListCarrinho.getCarrinhoList().remove(carrinhoListCarrinho);
                    oldUsuarioOfCarrinhoListCarrinho = em.merge(oldUsuarioOfCarrinhoListCarrinho);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findUsuario(usuario.getIdusuario()) != null) {
                throw new PreexistingEntityException("Usuario " + usuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getIdusuario());
            List<Compra> compraListOld = persistentUsuario.getCompraList();
            List<Compra> compraListNew = usuario.getCompraList();
            List<Carrinho> carrinhoListOld = persistentUsuario.getCarrinhoList();
            List<Carrinho> carrinhoListNew = usuario.getCarrinhoList();
            List<Compra> attachedCompraListNew = new ArrayList<Compra>();
            for (Compra compraListNewCompraToAttach : compraListNew) {
                compraListNewCompraToAttach = em.getReference(compraListNewCompraToAttach.getClass(), compraListNewCompraToAttach.getIdcompra());
                attachedCompraListNew.add(compraListNewCompraToAttach);
            }
            compraListNew = attachedCompraListNew;
            usuario.setCompraList(compraListNew);
            List<Carrinho> attachedCarrinhoListNew = new ArrayList<Carrinho>();
            for (Carrinho carrinhoListNewCarrinhoToAttach : carrinhoListNew) {
                carrinhoListNewCarrinhoToAttach = em.getReference(carrinhoListNewCarrinhoToAttach.getClass(), carrinhoListNewCarrinhoToAttach.getIdcarrinho());
                attachedCarrinhoListNew.add(carrinhoListNewCarrinhoToAttach);
            }
            carrinhoListNew = attachedCarrinhoListNew;
            usuario.setCarrinhoList(carrinhoListNew);
            usuario = em.merge(usuario);
            for (Compra compraListOldCompra : compraListOld) {
                if (!compraListNew.contains(compraListOldCompra)) {
                    compraListOldCompra.setUsuario(null);
                    compraListOldCompra = em.merge(compraListOldCompra);
                }
            }
            for (Compra compraListNewCompra : compraListNew) {
                if (!compraListOld.contains(compraListNewCompra)) {
                    Usuario oldUsuarioOfCompraListNewCompra = compraListNewCompra.getUsuario();
                    compraListNewCompra.setUsuario(usuario);
                    compraListNewCompra = em.merge(compraListNewCompra);
                    if (oldUsuarioOfCompraListNewCompra != null && !oldUsuarioOfCompraListNewCompra.equals(usuario)) {
                        oldUsuarioOfCompraListNewCompra.getCompraList().remove(compraListNewCompra);
                        oldUsuarioOfCompraListNewCompra = em.merge(oldUsuarioOfCompraListNewCompra);
                    }
                }
            }
            for (Carrinho carrinhoListOldCarrinho : carrinhoListOld) {
                if (!carrinhoListNew.contains(carrinhoListOldCarrinho)) {
                    carrinhoListOldCarrinho.setUsuario(null);
                    carrinhoListOldCarrinho = em.merge(carrinhoListOldCarrinho);
                }
            }
            for (Carrinho carrinhoListNewCarrinho : carrinhoListNew) {
                if (!carrinhoListOld.contains(carrinhoListNewCarrinho)) {
                    Usuario oldUsuarioOfCarrinhoListNewCarrinho = carrinhoListNewCarrinho.getUsuario();
                    carrinhoListNewCarrinho.setUsuario(usuario);
                    carrinhoListNewCarrinho = em.merge(carrinhoListNewCarrinho);
                    if (oldUsuarioOfCarrinhoListNewCarrinho != null && !oldUsuarioOfCarrinhoListNewCarrinho.equals(usuario)) {
                        oldUsuarioOfCarrinhoListNewCarrinho.getCarrinhoList().remove(carrinhoListNewCarrinho);
                        oldUsuarioOfCarrinhoListNewCarrinho = em.merge(oldUsuarioOfCarrinhoListNewCarrinho);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getIdusuario();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getIdusuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<Compra> compraList = usuario.getCompraList();
            for (Compra compraListCompra : compraList) {
                compraListCompra.setUsuario(null);
                compraListCompra = em.merge(compraListCompra);
            }
            List<Carrinho> carrinhoList = usuario.getCarrinhoList();
            for (Carrinho carrinhoListCarrinho : carrinhoList) {
                carrinhoListCarrinho.setUsuario(null);
                carrinhoListCarrinho = em.merge(carrinhoListCarrinho);
            }
            em.remove(usuario);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public int logar(String nome, String senha) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuario> c = cb.createQuery(Usuario.class);
        /**
         *   A partir da CriteriaQuery podemos informar de qual tabela os dados serão consultados usando o método from(), que dado uma classe
         * ou tipo de entidade (EntityType) ele retorna um objeto do tipo Root<T>, que representa a clausula "from" da consulta.
         *
         *   Através do Root<T> é possível obter as colunas, fazer joins, usar a clausula "in" e outros.
         */
        Root<Usuario> usuario = c.from(Usuario.class);
        /**
         *   A partir do Root<T> é chamado o método where() que adiciona uma comparação se o campo "id" da entidade possui o valor do parametro "id".
         *
         *   Diferente do JPQL a passagem de parâmetro é fortemente tipada, a partir da CriteriaBuilder é necessário criar um parâmetro
         * (ParameterExpression<T>) que possui o tipo do parametro e seu nome.
         */
        c.where(cb.equal(usuario.get("nome"), cb.parameter(String.class, "nome")));

        TypedQuery q = getEntityManager().createQuery(c);
        /* A passagem de parâmetros é igual ao do JPQL. */
        q.setParameter("nome", nome);
        Usuario usu = (Usuario) q.getSingleResult();
        
       try{
            if(usu.getSenha().equals(senha))
            {
                if(usu.getTipo().equals("1")) 
                {
                    return 1;
                }
                else if(usu.getTipo().equals("2"))
                {
                    return 2;
                }
            }
        }
       catch(Exception e){
           return -1;
       }
        
        return 0;
    }
    
}
