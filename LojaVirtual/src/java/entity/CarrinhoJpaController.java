/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.exceptions.NonexistentEntityException;
import entity.exceptions.PreexistingEntityException;
import entity.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import model.Carrinho;
import model.Usuario;
import model.Produto;

/**
 *
 * @author u11248
 */
public class CarrinhoJpaController implements Serializable {

    public CarrinhoJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Carrinho carrinho) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Usuario usuario = carrinho.getUsuario();
            if (usuario != null) {
                usuario = em.getReference(usuario.getClass(), usuario.getIdusuario());
                carrinho.setUsuario(usuario);
            }
            Produto produto = carrinho.getProduto();
            if (produto != null) {
                produto = em.getReference(produto.getClass(), produto.getIdproduto());
                carrinho.setProduto(produto);
            }
            em.persist(carrinho);
            if (usuario != null) {
                usuario.getCarrinhoList().add(carrinho);
                usuario = em.merge(usuario);
            }
            if (produto != null) {
                produto.getCarrinhoList().add(carrinho);
                produto = em.merge(produto);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findCarrinho(carrinho.getIdcarrinho()) != null) {
                throw new PreexistingEntityException("Carrinho " + carrinho + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Carrinho carrinho) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Carrinho persistentCarrinho = em.find(Carrinho.class, carrinho.getIdcarrinho());
            Usuario usuarioOld = persistentCarrinho.getUsuario();
            Usuario usuarioNew = carrinho.getUsuario();
            Produto produtoOld = persistentCarrinho.getProduto();
            Produto produtoNew = carrinho.getProduto();
            if (usuarioNew != null) {
                usuarioNew = em.getReference(usuarioNew.getClass(), usuarioNew.getIdusuario());
                carrinho.setUsuario(usuarioNew);
            }
            if (produtoNew != null) {
                produtoNew = em.getReference(produtoNew.getClass(), produtoNew.getIdproduto());
                carrinho.setProduto(produtoNew);
            }
            carrinho = em.merge(carrinho);
            if (usuarioOld != null && !usuarioOld.equals(usuarioNew)) {
                usuarioOld.getCarrinhoList().remove(carrinho);
                usuarioOld = em.merge(usuarioOld);
            }
            if (usuarioNew != null && !usuarioNew.equals(usuarioOld)) {
                usuarioNew.getCarrinhoList().add(carrinho);
                usuarioNew = em.merge(usuarioNew);
            }
            if (produtoOld != null && !produtoOld.equals(produtoNew)) {
                produtoOld.getCarrinhoList().remove(carrinho);
                produtoOld = em.merge(produtoOld);
            }
            if (produtoNew != null && !produtoNew.equals(produtoOld)) {
                produtoNew.getCarrinhoList().add(carrinho);
                produtoNew = em.merge(produtoNew);
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
                Integer id = carrinho.getIdcarrinho();
                if (findCarrinho(id) == null) {
                    throw new NonexistentEntityException("The carrinho with id " + id + " no longer exists.");
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
            Carrinho carrinho;
            try {
                carrinho = em.getReference(Carrinho.class, id);
                carrinho.getIdcarrinho();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The carrinho with id " + id + " no longer exists.", enfe);
            }
            Usuario usuario = carrinho.getUsuario();
            if (usuario != null) {
                usuario.getCarrinhoList().remove(carrinho);
                usuario = em.merge(usuario);
            }
            Produto produto = carrinho.getProduto();
            if (produto != null) {
                produto.getCarrinhoList().remove(carrinho);
                produto = em.merge(produto);
            }
            em.remove(carrinho);
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

    public List<Carrinho> findCarrinhoEntities() {
        return findCarrinhoEntities(true, -1, -1);
    }

    public List<Carrinho> findCarrinhoEntities(int maxResults, int firstResult) {
        return findCarrinhoEntities(false, maxResults, firstResult);
    }

    private List<Carrinho> findCarrinhoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Carrinho.class));
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

    public Carrinho findCarrinho(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Carrinho.class, id);
        } finally {
            em.close();
        }
    }

    public int getCarrinhoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Carrinho> rt = cq.from(Carrinho.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
