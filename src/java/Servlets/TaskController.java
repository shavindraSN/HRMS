package Servlets;

import HibernateUtils.EmployeeManager;
import HibernateUtils.TaskManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Mapping.Task;
import Mapping.Employee;
import Mapping.Role;

/**
 *
 * @author Shavindra
 */
@WebServlet(name = "TaskController_1", urlPatterns = {"/TaskController_1"})
public class TaskController extends HttpServlet {

    TaskManager taskManager;

    public TaskController() {
        taskManager = new TaskManager();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String taskId = request.getParameter("taskId");
        String option = request.getParameter("config");

        if (taskId == null || taskId.length() == 0) {
            taskId = "-1";
        }

        EmployeeManager employeeManager = new EmployeeManager();

        List<Task> result = taskManager.getTasks(taskId);

        List<Employee> employees = employeeManager.getEmployees("-1");

        request.setAttribute("result", result);
        request.setAttribute("employees", employees);

        if (option == null) {
            request.getRequestDispatcher("ViewAllTasks.jsp").forward(request, response);
        } else if (option.equals("edit")) {

            request.getRequestDispatcher("UpdateTask.jsp").forward(request, response);
        } else if (option.equals("assign")) {

            request.getRequestDispatcher("AssignTasks.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("ViewAllTasks.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployeeManager empManager = new EmployeeManager();
        String taskDesc = request.getParameter("task_desc");
        String taskId = request.getParameter("task_id");
        String employee = request.getParameter("employee");
        List<Employee> empNameList = empManager.getEmployees(employee);

        String option = request.getParameter("config");

        Task task = new Task();
        task.setDescription(taskDesc);

        if (option == null) {
            taskManager.createTask(task);
        } else {

            if (employee != null && employee.length() > 0) {

                task.setEmployee(Integer.parseInt(employee));
                task.setEmpname(empNameList.get(0).getName());
            } else {

                task.setEmployee(null);
            }
            task.setTaskid(Integer.parseInt(taskId));

            taskManager.updateTask(task);
        }

        List<Role> result = taskManager.getTasks("-1");

        request.setAttribute("result", result);
        request.getRequestDispatcher("ViewAllTasks.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
