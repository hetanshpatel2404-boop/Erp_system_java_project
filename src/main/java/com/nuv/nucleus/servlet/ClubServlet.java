package com.nuv.nucleus.servlet;
import com.nuv.nucleus.dao.GenericDAO;
import com.nuv.nucleus.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/app/clubs")
public class ClubServlet extends HttpServlet {
    private final GenericDAO<Club> clubDAO = new GenericDAO<>(Club.class);
    private final GenericDAO<ClubMember> memberDAO = new GenericDAO<>(ClubMember.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("clubs", clubDAO.findAll());
        request.setAttribute("members", memberDAO.findAll());
        request.getRequestDispatcher("/WEB-INF/views/clubs.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String action = request.getParameter("action");
        if (user == null || action == null) { response.sendRedirect(request.getContextPath() + "/app/clubs"); return; }
        switch (action) {
            case "createClub":
                String name = request.getParameter("name");
                if (name != null && !name.trim().isEmpty()) {
                    Club c = new Club(); c.setName(name.trim()); c.setDescription(request.getParameter("description")); clubDAO.save(c);
                }
                break;
            case "joinClub":
                try {
                    Long clubId = Long.parseLong(request.getParameter("clubId"));
                    Club c = clubDAO.findById(clubId);
                    if (c != null) {
                        ClubMember m = new ClubMember(); m.setClub(c); m.setUser(user); m.setRole("MEMBER"); memberDAO.save(m);
                    }
                } catch (Exception e) { e.printStackTrace(); }
                break;
            case "updateRole":
                try {
                    Long memberId = Long.parseLong(request.getParameter("memberId"));
                    ClubMember m = memberDAO.findById(memberId);
                    if (m != null && "ADMIN".equals(user.getRole())) {
                        m.setRole(request.getParameter("role")); memberDAO.update(m);
                    }
                } catch (Exception e) { e.printStackTrace(); }
                break;
            case "removeMember":
                try {
                    Long memberId = Long.parseLong(request.getParameter("memberId"));
                    ClubMember m = memberDAO.findById(memberId);
                    if (m != null && ("ADMIN".equals(user.getRole()) || user.getId().equals(m.getUser().getId()))) {
                        memberDAO.delete(m);
                    }
                } catch (Exception e) { e.printStackTrace(); }
                break;
        }
        response.sendRedirect(request.getContextPath() + "/app/clubs");
    }
}
