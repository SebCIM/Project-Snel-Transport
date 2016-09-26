/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Z.Huraibi
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();
    
    protected abstract EntityManager getEntityManager(Environment env);

    public void create(T entity) {
//        System.out.println("qwe");
//        System.out.println(getEntityManager());
//        System.out.println("ENDqwe");
//        getEntityManager().persist(entity);
        
        System.out.println("qwe");
        System.out.println(entity);
        System.out.println("ENDqwe");
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        getEntityManager().persist(entity);
        tx.commit();
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public void emptyTable() {
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        Query q = getEntityManager().createNativeQuery("DELETE FROM public.\"User\" ");
        q.executeUpdate();
        tx.commit();
    }
    public T findByName(String name) {
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
//        Query q = getEntityManager().createNativeQuery("DELETE FROM public.\"User\" ");
//        q.executeUpdate();
        tx.commit();
        
        Query q = getEntityManager().createNativeQuery(
        "SELECT * FROM " + entityClass.getName() + " e WHERE name = :name");
	q.setParameter("name", name);
	try {
		return (Order) q.getSingleResult();
	} catch (NoResultException exc) {
		return null;
	}
        
    }
    
}
