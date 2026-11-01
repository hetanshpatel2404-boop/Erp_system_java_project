package com.nuv.nucleus.servlet;
import com.nuv.nucleus.dao.GenericDAO;
import com.nuv.nucleus.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/app/achievements")
public class AchievementServlet extends HttpServlet {
    private final GenericDAO<Achievement> dao = new GenericDAO<>(Achievement.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("achievements", dao.findAll());
        request.getRequestDispatcher("/WEB-INF/views/achievements.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String title = request.getParameter("title");
        if (user != null && title != null && !title.trim().isEmpty()) {
            Achievement a = new Achievement();
            a.setUser(user); a.setTitle(title.trim());
            a.setDescription(request.getParameter("description"));
            a.setAchievementDate(request.getParameter("achievementDate"));
            a.setProofUrl(request.getParameter("proofUrl"));
            dao.save(a);
        }
        response.sendRedirect(request.getContextPath() + "/app/achievements");
    }
}
