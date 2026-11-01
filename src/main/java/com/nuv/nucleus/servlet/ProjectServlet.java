package com.nuv.nucleus.servlet;
import com.nuv.nucleus.dao.GenericDAO;
import com.nuv.nucleus.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/app/projects")
public class ProjectServlet extends HttpServlet {
    private final GenericDAO<ProjectRequest> dao = new GenericDAO<>(ProjectRequest.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("projects", dao.findAll());
        request.getRequestDispatcher("/WEB-INF/views/projects.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String action = request.getParameter("action");
        if (user == null || action == null) { response.sendRedirect(request.getContextPath() + "/app/projects"); return; }
        if (action.equals("createProject")) {
            String title = request.getParameter("title");
            if (title != null && !title.trim().isEmpty()) {
                ProjectRequest p = new ProjectRequest();
                p.setUser(user); p.setTitle(title.trim());
                p.setDescription(request.getParameter("description"));
                p.setSkillsRequired(request.getParameter("skillsRequired"));
                p.setStatus("OPEN");
                dao.save(p);
            }
        } else if (action.equals("updateProject")) {
            try {
                Long id = Long.parseLong(request.getParameter("projectId"));
                ProjectRequest p = dao.findById(id);
                if (p != null && ("ADMIN".equals(user.getRole()) || user.getId().equals(p.getUser().getId()))) {
                    p.setStatus(request.getParameter("status")); dao.update(p);
                }
            } catch (Exception e) { e.printStackTrace(); }
        }
        response.sendRedirect(request.getContextPath() + "/app/projects");
    }
}
