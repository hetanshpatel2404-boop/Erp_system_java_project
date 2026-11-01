package com.nuv.nucleus.servlet;
import com.nuv.nucleus.dao.*;
import com.nuv.nucleus.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/app/appointments")
public class AppointmentServlet extends HttpServlet {
    private final GenericDAO<Appointment> dao = new GenericDAO<>(Appointment.class);
    private final UserDAO userDAO = new UserDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("appointments", dao.findAll());
        request.setAttribute("faculties", userDAO.findByRole("FACULTY"));
        request.getRequestDispatcher("/WEB-INF/views/appointments.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String action = request.getParameter("action");
        if (user == null || action == null) { response.sendRedirect(request.getContextPath() + "/app/appointments"); return; }
        if (action.equals("createAppointment")) {
            try {
                Long facultyId = Long.parseLong(request.getParameter("facultyId"));
                User faculty = userDAO.findById(facultyId);
                if (faculty != null) {
                    Appointment a = new Appointment();
                    a.setStudent(user); a.setFaculty(faculty);
                    a.setAppointmentDate(request.getParameter("appointmentDate"));
                    a.setTimeSlot(request.getParameter("timeSlot"));
                    a.setPurpose(request.getParameter("purpose"));
                    a.setStatus("PENDING");
                    dao.save(a);
                }
            } catch (Exception e) { e.printStackTrace(); }
        } else if (action.equals("updateAppointment")) {
            try {
                Long id = Long.parseLong(request.getParameter("appointmentId"));
                Appointment a = dao.findById(id);
                if (a != null && ("ADMIN".equals(user.getRole()) || user.getId().equals(a.getFaculty().getId()))) {
                    a.setStatus(request.getParameter("status")); dao.update(a);
                }
            } catch (Exception e) { e.printStackTrace(); }
        }
        response.sendRedirect(request.getContextPath() + "/app/appointments");
    }
}
