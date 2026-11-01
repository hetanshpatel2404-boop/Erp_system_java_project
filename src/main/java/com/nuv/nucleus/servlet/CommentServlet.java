package com.nuv.nucleus.servlet;
import com.nuv.nucleus.dao.*;
import com.nuv.nucleus.model.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;
@WebServlet("/app/comments")
public class CommentServlet extends HttpServlet {
    private final GenericDAO<Post> postDAO = new GenericDAO<>(Post.class);
    private final CommentDAO commentDAO = new CommentDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String postIdParam = request.getParameter("postId");
        String content = request.getParameter("content");
        if (user != null && postIdParam != null && content != null && !content.trim().isEmpty()) {
            try {
                Long postId = Long.parseLong(postIdParam);
                Post post = postDAO.findById(postId);
                if (post != null) {
                    Comment comment = new Comment();
                    comment.setContent(content.trim());
                    comment.setCreatedAt(LocalDateTime.now());
                    comment.setPost(post);
                    comment.setUser(user);
                    commentDAO.save(comment);
                }
            } catch (NumberFormatException e) { e.printStackTrace(); }
        }
        response.sendRedirect(request.getContextPath() + "/app/posts");
    }
}
