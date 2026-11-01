package com.nuv.nucleus.dao;
import com.nuv.nucleus.model.User;
import com.nuv.nucleus.util.HibernateUtil;
import org.hibernate.Session;
import java.util.List;
public class UserDAO extends GenericDAO<User> {
    public UserDAO() { super(User.class); }
    public User login(String email, String passwordHash) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            List<User> list = s.createQuery("FROM User WHERE email = :email AND password = :password", User.class)
                    .setParameter("email", email).setParameter("password", passwordHash).getResultList();
            return list.isEmpty() ? null : list.get(0);
        }
    }
    public User findByEmail(String email) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            List<User> list = s.createQuery("FROM User WHERE email = :email", User.class)
                    .setParameter("email", email).getResultList();
            return list.isEmpty() ? null : list.get(0);
        }
    }
    public List<User> findByRole(String role) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createQuery("FROM User WHERE role = :role ORDER BY fullName", User.class)
                    .setParameter("role", role).getResultList();
        }
    }
}
