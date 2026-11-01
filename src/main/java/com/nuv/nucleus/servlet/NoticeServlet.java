package com.nuv.nucleus.servlet;
import com.nuv.nucleus.dao.GenericDAO;
import com.nuv.nucleus.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;
@WebServlet("/app/notices")
public class NoticeServlet extends HttpServlet {
    private final GenericDAO<Notice> dao = new GenericDAO<>(Notice.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("notices", dao.findAll());
        request.getRequestDispatcher("/WEB-INF/views/notices.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        boolean allowed = user != null && ("ADMIN".equals(user.getRole()) || "FACULTY".equals(user.getRole()));
        if (allowed) {
            String title = request.getParameter("title");
            if (title != null && !title.trim().isEmpty()) {
                Notice n = new Notice();
                n.setTitle(title.trim());
                n.setContent(request.getParameter("content"));
                n.setPostedAt(LocalDateTime.now());
                n.setPostedBy(user);
                dao.save(n);
            }
        }
        response.sendRedirect(request.getContextPath() + "/app/notices");
    }
}
