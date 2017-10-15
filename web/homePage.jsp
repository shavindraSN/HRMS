<%-- 
    Document   : homePage
    Created on : Oct 12, 2017, 6:50:50 PM
    Author     : Shavindra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <title>Home</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/flatly/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>

        <nav class="navbar navbar-default">
            <div class="container-fluid">

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
        <div class="container">
            <div class="row"><h4>Role Management</h4></div>
            <div class="row">
                <div class="col-sm-4">
                    <a href="ViewAllRoles">
                        <div class="jumbotron text-center">View All Roles</div>
                    </a>
                </div>

                <div class="col-sm-4">
                    <a href="CreateRole.jsp">
                        <div class="jumbotron text-center">Create Roles</div>
                    </a>
                </div>
            </div>
        </div>


        <div class="container text-left">
            <div class="row"><h4>Task Management</h4></div>
            <div class="row">
                <div class="col-sm-4">
                    <a href="ViewAllTasks">
                        <div class="jumbotron text-center">View All Tasks</div>
                    </a>
                </div>

                <div class="col-sm-4">
                    <a href="CreateTask.jsp">
                        <div class="jumbotron text-center">Create Tasks</div>
                    </a>
                </div>
            </div>
        </div>

        <div class="container text-left">
            <div class="row"><h4>Employee Management</h4></div>
            <div class="row">
                <div class="col-sm-4">
                    <a href="ViewAllEmployees">
                        <div class="jumbotron text-center">View All Employees</div>
                    </a>
                </div>

                <div class="col-sm-4">  
                    <a href="EmployeeData">
                        <div class="jumbotron text-center">Add Employees</div>
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>

