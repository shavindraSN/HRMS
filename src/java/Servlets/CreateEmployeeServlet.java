package Servlets;

import HibernateUtils.EmployeeManager;
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
import Mapping.Employee;

/**
 *
 * @author Shavindra
 */
@WebServlet(name = "CreateEmployeeServlet_1", urlPatterns = {"/CreateEmployeeServlet_1"})
public class CreateEmployeeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String employeeId = request.getParameter("employee_id");
        String option = request.getParameter("config");

        EmployeeManager employeeManager = new EmployeeManager();
        RoleManager roleManager = new RoleManager();

        if (employeeId == null || employeeId.length() == 0) {
            employeeId = "-1";
        }
        List<Employee> result = employeeManager.getEmployees(employeeId);
        List<Role> roles = roleManager.getAvailableRoles();

        request.setAttribute("result", result);
        request.setAttribute("roles", roles);
        
        if (option == null) {
            request.getRequestDispatcher("CreateEmployee.jsp").forward(request, response);
        } else if (option.equals("edit")) {
            request.getRequestDispatcher("UpdateEmployee.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("CreateEmployee.jsp").forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
