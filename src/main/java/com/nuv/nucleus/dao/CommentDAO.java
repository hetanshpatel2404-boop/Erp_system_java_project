package com.nuv.nucleus.dao;
import com.nuv.nucleus.model.Comment;
import com.nuv.nucleus.util.HibernateUtil;
import org.hibernate.Session;
import java.util.List;
public class CommentDAO extends GenericDAO<Comment> {
    public CommentDAO() { super(Comment.class); }
    public List<Comment> listByPost(Long postId) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createQuery("FROM Comment WHERE post.id = :postId ORDER BY id", Comment.class)
                    .setParameter("postId", postId).getResultList();
        }
    }
}
