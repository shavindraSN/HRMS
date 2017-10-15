package Servlets;

import HibernateUtils.RoleManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Mapping.Role;

/**
 *
 * @author Shavindra
 */
@WebServlet(name = "RoleController", urlPatterns = {"/RoleController"})
public class RoleController extends HttpServlet {

    RoleManager roleManager;

    public RoleController() {
        roleManager = new RoleManager();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * 
         */
        String roleId = request.getParameter("roleId");
        String option = request.getParameter("config");

        if (roleId == null || roleId.length() == 0) {
            roleId = "-1";
        }

        List<Role> result = roleManager.getRoles(roleId);

        request.setAttribute("result", result);

        // if option is null, view all roles view is rendered
        if (option == null) {
            request.getRequestDispatcher("ViewAllRoles.jsp").forward(request, response);
        } else if (option.equals("edit")) {
            request.getRequestDispatcher("UpdateRole.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("ViewAllRoles.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String roleTitle = request.getParameter("role_title");
        String roleId = request.getParameter("role_id");
        String option = request.getParameter("config");

        Role role = new Role();
        role.setTitle(roleTitle);
        if (option == null) {
            roleManager.createRole(role);
        } else {
            role.setRoleid(Integer.parseInt(roleId));
            roleManager.updateRole(role);
        }
        List<Role> result = roleManager.getRoles("-1");
        request.setAttribute("result", result);
        request.getRequestDispatcher("ViewAllRoles.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
