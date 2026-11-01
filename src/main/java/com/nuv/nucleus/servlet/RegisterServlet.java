package com.nuv.nucleus.servlet;
import com.nuv.nucleus.dao.UserDAO;
import com.nuv.nucleus.model.User;
import com.nuv.nucleus.util.PasswordUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final UserDAO userDAO = new UserDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String skills = request.getParameter("skills");
        if (fullName == null || fullName.trim().isEmpty() || email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            request.setAttribute("error", "Please fill all required fields");
            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
            return;
        }
        if (userDAO.findByEmail(email) != null) {
            request.setAttribute("error", "Email already exists");
            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
            return;
        }
        if (role == null || (!role.equals("STUDENT") && !role.equals("FACULTY"))) role = "STUDENT";
        User user = new User();
        user.setFullName(fullName.trim());
        user.setEmail(email.trim());
        user.setPassword(PasswordUtil.hash(password));
        user.setRole(role);
        user.setSkills(skills);
        userDAO.save(user);
        response.sendRedirect(request.getContextPath() + "/login");
    }
}
