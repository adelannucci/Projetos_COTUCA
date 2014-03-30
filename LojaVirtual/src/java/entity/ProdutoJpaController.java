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
import model.Categoria;
import model.Compra;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import model.Carrinho;
import model.Produto;

/**
 *
 * @author u11248
 */
public class ProdutoJpaController implements Serializable {

    public ProdutoJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produto produto) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (produto.getCompraList() == null) {
            produto.setCompraList(new ArrayList<Compra>());
        }
        if (produto.getCarrinhoList() == null) {
            produto.setCarrinhoList(new ArrayList<Carrinho>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Categoria categoria = produto.getCategoria();
            if (categoria != null) {
                categoria = em.getReference(categoria.getClass(), categoria.getIdcategoria());
                produto.setCategoria(categoria);
            }
            List<Compra> attachedCompraList = new ArrayList<Compra>();
            for (Compra compraListCompraToAttach : produto.getCompraList()) {
                compraListCompraToAttach = em.getReference(compraListCompraToAttach.getClass(), compraListCompraToAttach.getIdcompra());
                attachedCompraList.add(compraListCompraToAttach);
            }
            produto.setCompraList(attachedCompraList);
            List<Carrinho> attachedCarrinhoList = new ArrayList<Carrinho>();
            for (Carrinho carrinhoListCarrinhoToAttach : produto.getCarrinhoList()) {
                carrinhoListCarrinhoToAttach = em.getReference(carrinhoListCarrinhoToAttach.getClass(), carrinhoListCarrinhoToAttach.getIdcarrinho());
                attachedCarrinhoList.add(carrinhoListCarrinhoToAttach);
            }
            produto.setCarrinhoList(attachedCarrinhoList);
            em.persist(produto);
            if (categoria != null) {
                categoria.getProdutoList().add(produto);
                categoria = em.merge(categoria);
            }
            for (Compra compraListCompra : produto.getCompraList()) {
                Produto oldProdutoOfCompraListCompra = compraListCompra.getProduto();
                compraListCompra.setProduto(produto);
                compraListCompra = em.merge(compraListCompra);
                if (oldProdutoOfCompraListCompra != null) {
                    oldProdutoOfCompraListCompra.getCompraList().remove(compraListCompra);
                    oldProdutoOfCompraListCompra = em.merge(oldProdutoOfCompraListCompra);
                }
            }
            for (Carrinho carrinhoListCarrinho : produto.getCarrinhoList()) {
                Produto oldProdutoOfCarrinhoListCarrinho = carrinhoListCarrinho.getProduto();
                carrinhoListCarrinho.setProduto(produto);
                carrinhoListCarrinho = em.merge(carrinhoListCarrinho);
                if (oldProdutoOfCarrinhoListCarrinho != null) {
                    oldProdutoOfCarrinhoListCarrinho.getCarrinhoList().remove(carrinhoListCarrinho);
                    oldProdutoOfCarrinhoListCarrinho = em.merge(oldProdutoOfCarrinhoListCarrinho);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findProduto(produto.getIdproduto()) != null) {
                throw new PreexistingEntityException("Produto " + produto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produto produto) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Produto persistentProduto = em.find(Produto.class, produto.getIdproduto());
            Categoria categoriaOld = persistentProduto.getCategoria();
            Categoria categoriaNew = produto.getCategoria();
            List<Compra> compraListOld = persistentProduto.getCompraList();
            List<Compra> compraListNew = produto.getCompraList();
            List<Carrinho> carrinhoListOld = persistentProduto.getCarrinhoList();
            List<Carrinho> carrinhoListNew = produto.getCarrinhoList();
            if (categoriaNew != null) {
                categoriaNew = em.getReference(categoriaNew.getClass(), categoriaNew.getIdcategoria());
                produto.setCategoria(categoriaNew);
            }
            List<Compra> attachedCompraListNew = new ArrayList<Compra>();
            for (Compra compraListNewCompraToAttach : compraListNew) {
                compraListNewCompraToAttach = em.getReference(compraListNewCompraToAttach.getClass(), compraListNewCompraToAttach.getIdcompra());
                attachedCompraListNew.add(compraListNewCompraToAttach);
            }
            compraListNew = attachedCompraListNew;
            produto.setCompraList(compraListNew);
            List<Carrinho> attachedCarrinhoListNew = new ArrayList<Carrinho>();
            for (Carrinho carrinhoListNewCarrinhoToAttach : carrinhoListNew) {
                carrinhoListNewCarrinhoToAttach = em.getReference(carrinhoListNewCarrinhoToAttach.getClass(), carrinhoListNewCarrinhoToAttach.getIdcarrinho());
                attachedCarrinhoListNew.add(carrinhoListNewCarrinhoToAttach);
            }
            carrinhoListNew = attachedCarrinhoListNew;
            produto.setCarrinhoList(carrinhoListNew);
            produto = em.merge(produto);
            if (categoriaOld != null && !categoriaOld.equals(categoriaNew)) {
                categoriaOld.getProdutoList().remove(produto);
                categoriaOld = em.merge(categoriaOld);
            }
            if (categoriaNew != null && !categoriaNew.equals(categoriaOld)) {
                categoriaNew.getProdutoList().add(produto);
                categoriaNew = em.merge(categoriaNew);
            }
            for (Compra compraListOldCompra : compraListOld) {
                if (!compraListNew.contains(compraListOldCompra)) {
                    compraListOldCompra.setProduto(null);
                    compraListOldCompra = em.merge(compraListOldCompra);
                }
            }
            for (Compra compraListNewCompra : compraListNew) {
                if (!compraListOld.contains(compraListNewCompra)) {
                    Produto oldProdutoOfCompraListNewCompra = compraListNewCompra.getProduto();
                    compraListNewCompra.setProduto(produto);
                    compraListNewCompra = em.merge(compraListNewCompra);
                    if (oldProdutoOfCompraListNewCompra != null && !oldProdutoOfCompraListNewCompra.equals(produto)) {
                        oldProdutoOfCompraListNewCompra.getCompraList().remove(compraListNewCompra);
                        oldProdutoOfCompraListNewCompra = em.merge(oldProdutoOfCompraListNewCompra);
                    }
                }
            }
            for (Carrinho carrinhoListOldCarrinho : carrinhoListOld) {
                if (!carrinhoListNew.contains(carrinhoListOldCarrinho)) {
                    carrinhoListOldCarrinho.setProduto(null);
                    carrinhoListOldCarrinho = em.merge(carrinhoListOldCarrinho);
                }
            }
            for (Carrinho carrinhoListNewCarrinho : carrinhoListNew) {
                if (!carrinhoListOld.contains(carrinhoListNewCarrinho)) {
                    Produto oldProdutoOfCarrinhoListNewCarrinho = carrinhoListNewCarrinho.getProduto();
                    carrinhoListNewCarrinho.setProduto(produto);
                    carrinhoListNewCarrinho = em.merge(carrinhoListNewCarrinho);
                    if (oldProdutoOfCarrinhoListNewCarrinho != null && !oldProdutoOfCarrinhoListNewCarrinho.equals(produto)) {
                        oldProdutoOfCarrinhoListNewCarrinho.getCarrinhoList().remove(carrinhoListNewCarrinho);
                        oldProdutoOfCarrinhoListNewCarrinho = em.merge(oldProdutoOfCarrinhoListNewCarrinho);
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
                Integer id = produto.getIdproduto();
                if (findProduto(id) == null) {
                    throw new NonexistentEntityException("The produto with id " + id + " no longer exists.");
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
            Produto produto;
            try {
                produto = em.getReference(Produto.class, id);
                produto.getIdproduto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produto with id " + id + " no longer exists.", enfe);
            }
            Categoria categoria = produto.getCategoria();
            if (categoria != null) {
                categoria.getProdutoList().remove(produto);
                categoria = em.merge(categoria);
            }
            List<Compra> compraList = produto.getCompraList();
            for (Compra compraListCompra : compraList) {
                compraListCompra.setProduto(null);
                compraListCompra = em.merge(compraListCompra);
            }
            List<Carrinho> carrinhoList = produto.getCarrinhoList();
            for (Carrinho carrinhoListCarrinho : carrinhoList) {
                carrinhoListCarrinho.setProduto(null);
                carrinhoListCarrinho = em.merge(carrinhoListCarrinho);
            }
            em.remove(produto);
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

    public List<Produto> findProdutoEntities() {
        return findProdutoEntities(true, -1, -1);
    }

    public List<Produto> findProdutoEntities(int maxResults, int firstResult) {
        return findProdutoEntities(false, maxResults, firstResult);
    }

    private List<Produto> findProdutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produto.class));
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

    public Produto findProduto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produto> rt = cq.from(Produto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
