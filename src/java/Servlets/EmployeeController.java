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
import Mapping.Employee;
import Mapping.Role;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author Shavindra
 */
@WebServlet(name = "EmployeeController_1", urlPatterns = {"/EmployeeController_1"})
public class EmployeeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmployeeManager employeeManager = new EmployeeManager();
        List<Employee> result = employeeManager.getEmployees("-1");
        request.setAttribute("result", result);
        request.getRequestDispatcher("ViewAllEmployees.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmployeeManager employeeManager = new EmployeeManager();
        RoleManager roleManager = new RoleManager();
        String employeeId = request.getParameter("employee_id");
        String name = request.getParameter("employee_name");
        String role = request.getParameter("employee_role");
        List<Role> roleNameList = roleManager.getRoles(role);
        String option = request.getParameter("config");

        Employee employee = new Employee();
        employee.setName(name);
        
        if (role != null && role.length() > 0) {
            employee.setRole(Integer.parseInt(role));
            employee.setRolename(roleNameList.get(0).getTitle());
        } else {
            employee.setRole(null);
        }
        if (option == null) {
            employeeManager.createEmployee(employee);
        } else {
            // If an option is set, employee details can be updated
            employee.setEmployeeid(Integer.parseInt(employeeId));
            employeeManager.updateEmployee(employee);
        }

        // Get all the employees
        List<Employee> result = employeeManager.getEmployees("-1");

        // Assign result set and render the view
        request.setAttribute("result", result);
        request.getRequestDispatcher("ViewAllEmployees.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
