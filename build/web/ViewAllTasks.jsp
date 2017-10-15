<%-- 
    Document   : ViewAllTasks
    Created on : Oct 12, 2017, 6:47:20 PM
    Author     : Shavindra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>All Tasks</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/flatly/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>

        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="homePage.jsp">Home</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Roles
                                <span class="caret"></span>
                            </a>

                            <ul class="dropdown-menu">
                                <li><a href="ViewAllRoles">List All Roles</a></li>
                                <li><a href="CreateRole.jsp">Create Role</a></li>
                            </ul>
                        </li>


                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Tasks
                                <span class="caret"></span>
                            </a>

                            <ul class="dropdown-menu">
                                <li><a href="ViewAllTasks">List All Tasks</a></li>
                                <li><a href="CreateTask.jsp">Create Task</a></li>
                            </ul>
                        </li>


                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Employees
                                <span class="caret"></span>
                            </a>

                            <ul class="dropdown-menu">
                                <li><a href="ViewAllEmployees">List All Employees</a></li>
                                <li><a href="EmployeeData">Create Employee</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">
                </div>
                <div class="col-sm-8 text-left"> 
                    <h1>Tasks</h1>
                    
                    <hr>

                    <table class="table table-hover table-striped">

                        <thead>
                        <th>
                            Task ID
                        </th>

                        <th>
                            Task Description
                        </th>

                        <th>
                            Assigned Employee ID
                        </th>

                        <th>
                            Assigned Employee 
                        </th>
                        </thead>
                        <c:forEach items="${result}" var="res">
                            <tr>
                                <td>
                                    <c:out value="${res.taskid}"></c:out>
                                    </td>
                                    <td>
                                    <c:out value="${res.description}"></c:out>
                                    </td>

                                    <td>
                                    <c:out value="${res.employee}"></c:out>
                                    </td>
                                    <td>
                                    <c:out value="${res.empname}"></c:out>
                                    </td>
                                    <td>
                                        <form method="get" action="ViewAllTasks">
                                            <input name="taskId" value="${res.taskid}" hidden/>
                                        <input name="config" value="edit" hidden/>
                                        <input type="submit" class="btn btn-primary form-control" value="Edit">
                                    </form>
                                </td>


                                <td>
                                    <form method="get" action="ViewAllTasks">
                                        <input name="taskId" value="${res.taskid}" hidden/>
                                        <input name="config" value="assign" hidden/>
                                        <input type="submit" class="btn btn-warning form-control" value="Assign">
                                    </form>
                                </td>

                                <td>
                                    <form method="post" action="ViewAllTasks">
                                        <input name="config" value="update" hidden>
                                        <input name="task_id" value="${res.taskid}" hidden>
                                        <input name="task_desc" value="${res.description}" hidden>

                                        <input type="submit" value="Unassign Task" class="btn btn-danger form-control">
                                    </form>
                                </td>

                            </tr>
                        </c:forEach>
                    </table>

                </div>
            </div>
        </div>
    </body>
</html>