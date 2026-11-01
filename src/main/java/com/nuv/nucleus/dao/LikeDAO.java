package com.nuv.nucleus.dao;
import com.nuv.nucleus.model.LikePost;
import com.nuv.nucleus.model.Post;
import com.nuv.nucleus.model.User;
import com.nuv.nucleus.util.HibernateUtil;
import org.hibernate.Session;
import java.util.List;
public class LikeDAO extends GenericDAO<LikePost> {
    public LikeDAO() { super(LikePost.class); }
    public LikePost findByPostAndUser(Long postId, Long userId) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            List<LikePost> list = s.createQuery("FROM LikePost WHERE post.id = :postId AND user.id = :userId", LikePost.class)
                    .setParameter("postId", postId).setParameter("userId", userId).getResultList();
            return list.isEmpty() ? null : list.get(0);
        }
    }
    public long countByPost(Long postId) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            Long count = s.createQuery("SELECT COUNT(l) FROM LikePost l WHERE l.post.id = :postId", Long.class)
                    .setParameter("postId", postId).getSingleResult();
            return count == null ? 0 : count;
        }
    }
    public void toggle(Post post, User user) {
        LikePost existing = findByPostAndUser(post.getId(), user.getId());
        if (existing == null) {
            LikePost like = new LikePost();
            like.setPost(post);
            like.setUser(user);
            save(like);
        } else {
            delete(existing);
        }
    }
}
