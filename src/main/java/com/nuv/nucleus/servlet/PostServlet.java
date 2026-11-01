package com.nuv.nucleus.servlet;
import com.nuv.nucleus.dao.*;
import com.nuv.nucleus.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
@WebServlet("/app/posts")
public class PostServlet extends HttpServlet {
    private final GenericDAO<Post> postDAO = new GenericDAO<>(Post.class);
    private final CommentDAO commentDAO = new CommentDAO();
    private final LikeDAO likeDAO = new LikeDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> posts = postDAO.findAll();
        Map<Long, List<Comment>> commentsMap = new HashMap<>();
        Map<Long, Long> likeCounts = new HashMap<>();
        for (Post post : posts) {
            commentsMap.put(post.getId(), commentDAO.listByPost(post.getId()));
            likeCounts.put(post.getId(), likeDAO.countByPost(post.getId()));
        }
        request.setAttribute("posts", posts);
        request.setAttribute("commentsMap", commentsMap);
        request.setAttribute("likeCounts", likeCounts);
        request.getRequestDispatcher("/WEB-INF/views/posts.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String content = request.getParameter("content");
        if (user != null && content != null && !content.trim().isEmpty()) {
            Post post = new Post();
            post.setContent(content.trim());
            post.setCreatedAt(LocalDateTime.now());
            post.setUser(user);
            postDAO.save(post);
        }
        response.sendRedirect(request.getContextPath() + "/app/posts");
    }
}
