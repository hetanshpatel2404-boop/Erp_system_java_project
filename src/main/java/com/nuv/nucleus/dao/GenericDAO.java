package com.nuv.nucleus.dao;
import com.nuv.nucleus.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
public class GenericDAO<T> {
    private final Class<T> entityClass;
    public GenericDAO(Class<T> entityClass) { this.entityClass = entityClass; }
    public void save(T entity) {
        Transaction t = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            t = s.beginTransaction(); s.persist(entity); t.commit();
        } catch (Exception e) { if (t != null) t.rollback(); e.printStackTrace(); }
    }
    public void update(T entity) {
        Transaction t = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            t = s.beginTransaction(); s.merge(entity); t.commit();
        } catch (Exception e) { if (t != null) t.rollback(); e.printStackTrace(); }
    }
    public void delete(T entity) {
        Transaction t = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            t = s.beginTransaction();
            Object managed = s.contains(entity) ? entity : s.merge(entity);
            s.remove(managed); t.commit();
        } catch (Exception e) { if (t != null) t.rollback(); e.printStackTrace(); }
    }
    public T findById(Long id) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.get(entityClass, id);
        }
    }
    public List<T> findAll() {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createQuery("FROM " + entityClass.getSimpleName() + " ORDER BY id DESC", entityClass).getResultList();
        }
    }
}
