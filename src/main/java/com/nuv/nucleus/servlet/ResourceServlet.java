package com.nuv.nucleus.servlet;
import com.nuv.nucleus.dao.GenericDAO;
import com.nuv.nucleus.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
@WebServlet("/app/resources")
public class ResourceServlet extends HttpServlet {
    private final GenericDAO<Resource> dao = new GenericDAO<>(Resource.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("resources", dao.findAll());
        request.getRequestDispatcher("/WEB-INF/views/resources.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String title = request.getParameter("title");
        if (user != null && title != null && !title.trim().isEmpty()) {
            Resource r = new Resource();
            r.setTitle(title.trim());
            r.setDescription(request.getParameter("description"));
            r.setUrl(request.getParameter("url"));
            r.setCategory(request.getParameter("category"));
            r.setUploadedBy(user);
            dao.save(r);
        }
        response.sendRedirect(request.getContextPath() + "/app/resources");
    }
}
