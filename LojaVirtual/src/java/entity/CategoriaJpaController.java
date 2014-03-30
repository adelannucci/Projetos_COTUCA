/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.exceptions.NonexistentEntityException;
import entity.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import model.Produto;

/**
 *
 * @author u11248
 */
public class CategoriaJpaController implements Serializable {

    public CategoriaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Categoria categoria) throws RollbackFailureException, Exception {
        if (categoria.getCategoriaList() == null) {
            categoria.setCategoriaList(new ArrayList<Categoria>());
        }
        if (categoria.getProdutoList() == null) {
            categoria.setProdutoList(new ArrayList<Produto>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Categoria categoriaRel = categoria.getCategoria();
            if (categoriaRel != null) {
                categoriaRel = em.getReference(categoriaRel.getClass(), categoriaRel.getIdcategoria());
                categoria.setCategoria(categoriaRel);
            }
            List<Categoria> attachedCategoriaList = new ArrayList<Categoria>();
            for (Categoria categoriaListCategoriaToAttach : categoria.getCategoriaList()) {
                categoriaListCategoriaToAttach = em.getReference(categoriaListCategoriaToAttach.getClass(), categoriaListCategoriaToAttach.getIdcategoria());
                attachedCategoriaList.add(categoriaListCategoriaToAttach);
            }
            categoria.setCategoriaList(attachedCategoriaList);
            List<Produto> attachedProdutoList = new ArrayList<Produto>();
            for (Produto produtoListProdutoToAttach : categoria.getProdutoList()) {
                produtoListProdutoToAttach = em.getReference(produtoListProdutoToAttach.getClass(), produtoListProdutoToAttach.getIdproduto());
                attachedProdutoList.add(produtoListProdutoToAttach);
            }
            categoria.setProdutoList(attachedProdutoList);
            em.persist(categoria);
            if (categoriaRel != null) {
                categoriaRel.getCategoriaList().add(categoria);
                categoriaRel = em.merge(categoriaRel);
            }
            for (Categoria categoriaListCategoria : categoria.getCategoriaList()) {
                Categoria oldCategoriaOfCategoriaListCategoria = categoriaListCategoria.getCategoria();
                categoriaListCategoria.setCategoria(categoria);
                categoriaListCategoria = em.merge(categoriaListCategoria);
                if (oldCategoriaOfCategoriaListCategoria != null) {
                    oldCategoriaOfCategoriaListCategoria.getCategoriaList().remove(categoriaListCategoria);
                    oldCategoriaOfCategoriaListCategoria = em.merge(oldCategoriaOfCategoriaListCategoria);
                }
            }
            for (Produto produtoListProduto : categoria.getProdutoList()) {
                Categoria oldCategoriaOfProdutoListProduto = produtoListProduto.getCategoria();
                produtoListProduto.setCategoria(categoria);
                produtoListProduto = em.merge(produtoListProduto);
                if (oldCategoriaOfProdutoListProduto != null) {
                    oldCategoriaOfProdutoListProduto.getProdutoList().remove(produtoListProduto);
                    oldCategoriaOfProdutoListProduto = em.merge(oldCategoriaOfProdutoListProduto);
                }
            }
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

    public void edit(Categoria categoria) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Categoria persistentCategoria = em.find(Categoria.class, categoria.getIdcategoria());
            Categoria categoriaRelOld = persistentCategoria.getCategoria();
            Categoria categoriaRelNew = categoria.getCategoria();
            List<Categoria> categoriaListOld = persistentCategoria.getCategoriaList();
            List<Categoria> categoriaListNew = categoria.getCategoriaList();
            List<Produto> produtoListOld = persistentCategoria.getProdutoList();
            List<Produto> produtoListNew = categoria.getProdutoList();
            if (categoriaRelNew != null) {
                categoriaRelNew = em.getReference(categoriaRelNew.getClass(), categoriaRelNew.getIdcategoria());
                categoria.setCategoria(categoriaRelNew);
            }
            List<Categoria> attachedCategoriaListNew = new ArrayList<Categoria>();
            for (Categoria categoriaListNewCategoriaToAttach : categoriaListNew) {
                categoriaListNewCategoriaToAttach = em.getReference(categoriaListNewCategoriaToAttach.getClass(), categoriaListNewCategoriaToAttach.getIdcategoria());
                attachedCategoriaListNew.add(categoriaListNewCategoriaToAttach);
            }
            categoriaListNew = attachedCategoriaListNew;
            categoria.setCategoriaList(categoriaListNew);
            List<Produto> attachedProdutoListNew = new ArrayList<Produto>();
            for (Produto produtoListNewProdutoToAttach : produtoListNew) {
                produtoListNewProdutoToAttach = em.getReference(produtoListNewProdutoToAttach.getClass(), produtoListNewProdutoToAttach.getIdproduto());
                attachedProdutoListNew.add(produtoListNewProdutoToAttach);
            }
            produtoListNew = attachedProdutoListNew;
            categoria.setProdutoList(produtoListNew);
            categoria = em.merge(categoria);
            if (categoriaRelOld != null && !categoriaRelOld.equals(categoriaRelNew)) {
                categoriaRelOld.getCategoriaList().remove(categoria);
                categoriaRelOld = em.merge(categoriaRelOld);
            }
            if (categoriaRelNew != null && !categoriaRelNew.equals(categoriaRelOld)) {
                categoriaRelNew.getCategoriaList().add(categoria);
                categoriaRelNew = em.merge(categoriaRelNew);
            }
            for (Categoria categoriaListOldCategoria : categoriaListOld) {
                if (!categoriaListNew.contains(categoriaListOldCategoria)) {
                    categoriaListOldCategoria.setCategoria(null);
                    categoriaListOldCategoria = em.merge(categoriaListOldCategoria);
                }
            }
            for (Categoria categoriaListNewCategoria : categoriaListNew) {
                if (!categoriaListOld.contains(categoriaListNewCategoria)) {
                    Categoria oldCategoriaOfCategoriaListNewCategoria = categoriaListNewCategoria.getCategoria();
                    categoriaListNewCategoria.setCategoria(categoria);
                    categoriaListNewCategoria = em.merge(categoriaListNewCategoria);
                    if (oldCategoriaOfCategoriaListNewCategoria != null && !oldCategoriaOfCategoriaListNewCategoria.equals(categoria)) {
                        oldCategoriaOfCategoriaListNewCategoria.getCategoriaList().remove(categoriaListNewCategoria);
                        oldCategoriaOfCategoriaListNewCategoria = em.merge(oldCategoriaOfCategoriaListNewCategoria);
                    }
                }
            }
            for (Produto produtoListOldProduto : produtoListOld) {
                if (!produtoListNew.contains(produtoListOldProduto)) {
                    produtoListOldProduto.setCategoria(null);
                    produtoListOldProduto = em.merge(produtoListOldProduto);
                }
            }
            for (Produto produtoListNewProduto : produtoListNew) {
                if (!produtoListOld.contains(produtoListNewProduto)) {
                    Categoria oldCategoriaOfProdutoListNewProduto = produtoListNewProduto.getCategoria();
                    produtoListNewProduto.setCategoria(categoria);
                    produtoListNewProduto = em.merge(produtoListNewProduto);
                    if (oldCategoriaOfProdutoListNewProduto != null && !oldCategoriaOfProdutoListNewProduto.equals(categoria)) {
                        oldCategoriaOfProdutoListNewProduto.getProdutoList().remove(produtoListNewProduto);
                        oldCategoriaOfProdutoListNewProduto = em.merge(oldCategoriaOfProdutoListNewProduto);
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
                Integer id = categoria.getIdcategoria();
                if (findCategoria(id) == null) {
                    throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.");
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
            Categoria categoria;
            try {
                categoria = em.getReference(Categoria.class, id);
                categoria.getIdcategoria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.", enfe);
            }
            Categoria categoriaRel = categoria.getCategoria();
            if (categoriaRel != null) {
                categoriaRel.getCategoriaList().remove(categoria);
                categoriaRel = em.merge(categoriaRel);
            }
            List<Categoria> categoriaList = categoria.getCategoriaList();
            for (Categoria categoriaListCategoria : categoriaList) {
                categoriaListCategoria.setCategoria(null);
                categoriaListCategoria = em.merge(categoriaListCategoria);
            }
            List<Produto> produtoList = categoria.getProdutoList();
            for (Produto produtoListProduto : produtoList) {
                produtoListProduto.setCategoria(null);
                produtoListProduto = em.merge(produtoListProduto);
            }
            em.remove(categoria);
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

    public List<Categoria> findCategoriaEntities() {
        return findCategoriaEntities(true, -1, -1);
    }

    public List<Categoria> findCategoriaEntities(int maxResults, int firstResult) {
        return findCategoriaEntities(false, maxResults, firstResult);
    }

    private List<Categoria> findCategoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Categoria.class));
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

    public Categoria findCategoria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Categoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Categoria> rt = cq.from(Categoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
