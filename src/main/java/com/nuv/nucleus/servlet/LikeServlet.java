package com.nuv.nucleus.servlet;
import com.nuv.nucleus.dao.*;
import com.nuv.nucleus.model.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/app/like")
public class LikeServlet extends HttpServlet {
    private final GenericDAO<Post> postDAO = new GenericDAO<>(Post.class);
    private final LikeDAO likeDAO = new LikeDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String postIdParam = request.getParameter("postId");
        if (user != null && postIdParam != null) {
            try {
                Long postId = Long.parseLong(postIdParam);
                Post post = postDAO.findById(postId);
                if (post != null) likeDAO.toggle(post, user);
            } catch (NumberFormatException e) { e.printStackTrace(); }
        }
        response.sendRedirect(request.getContextPath() + "/app/posts");
    }
}
