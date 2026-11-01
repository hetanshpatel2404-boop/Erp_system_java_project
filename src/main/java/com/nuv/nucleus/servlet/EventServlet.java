package com.nuv.nucleus.servlet;
import com.nuv.nucleus.dao.GenericDAO;
import com.nuv.nucleus.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/app/events")
public class EventServlet extends HttpServlet {
    private final GenericDAO<Event> dao = new GenericDAO<>(Event.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("events", dao.findAll());
        request.getRequestDispatcher("/WEB-INF/views/events.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String title = request.getParameter("title");
        if (user != null && title != null && !title.trim().isEmpty()) {
            Event e = new Event();
            e.setTitle(title.trim());
            e.setDescription(request.getParameter("description"));
            e.setLocation(request.getParameter("location"));
            e.setEventDate(request.getParameter("eventDate"));
            e.setOrganizer(user);
            dao.save(e);
        }
        response.sendRedirect(request.getContextPath() + "/app/events");
    }
}
