<%-- 
    Document   : CreateEmployee
    Created on : Oct 12, 2017, 6:44:33 PM
    Author     : Shavindra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Create Employee</title>
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
                    
                    <h1>Employees</h1>
                    
                    <hr>

                    <div class="col-sm-12">
                        <div class="col-sm-2"></div>

                        <div class="col-sm-8">
                            <form method="post" action="ViewAllEmployees">
                                <label for="employee_name">Employee name:</label>
                                <input name="employee_name" id="employee_name" 
                                       type="text" class="form-control"
                                       placeholder="Employee name">

                                <label for="employee_role">Employee role:</label>
                                <select name="employee_role" class="form-control">

                                    <c:forEach items="${roles}" var="role">
                                        <option value="${role.roleid}">
                                            <c:out value="${role.title}"></c:out>
                                        </option>
                                        
                                    </c:forEach>

                                </select>

                                <input type="submit" value="Create Employee" class="btn btn-primary">
                            </form>
                        </div>


                        <div class="col-sm-2"></div>
                    </div>
            </div>
        </div>

    </body>
</html>
