package com.nuv.nucleus.servlet;
import com.nuv.nucleus.dao.GenericDAO;
import com.nuv.nucleus.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/app/issues")
public class IssueServlet extends HttpServlet {
    private final GenericDAO<CampusIssue> dao = new GenericDAO<>(CampusIssue.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("issues", dao.findAll());
        request.getRequestDispatcher("/WEB-INF/views/issues.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String action = request.getParameter("action");
        if (user == null || action == null) { response.sendRedirect(request.getContextPath() + "/app/issues"); return; }
        if (action.equals("createIssue")) {
            String title = request.getParameter("title");
            if (title != null && !title.trim().isEmpty()) {
                CampusIssue i = new CampusIssue();
                i.setUser(user); i.setTitle(title.trim());
                i.setDescription(request.getParameter("description"));
                i.setLocation(request.getParameter("location"));
                i.setCategory(request.getParameter("category"));
                i.setStatus("REPORTED");
                dao.save(i);
            }
        } else if (action.equals("updateIssue")) {
            try {
                Long id = Long.parseLong(request.getParameter("issueId"));
                CampusIssue i = dao.findById(id);
                if (i != null && ("ADMIN".equals(user.getRole()) || "FACULTY".equals(user.getRole()) || user.getId().equals(i.getUser().getId()))) {
                    i.setStatus(request.getParameter("status")); dao.update(i);
                }
            } catch (Exception e) { e.printStackTrace(); }
        }
        response.sendRedirect(request.getContextPath() + "/app/issues");
    }
}
