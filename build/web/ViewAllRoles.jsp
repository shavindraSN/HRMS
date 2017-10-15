<%-- 
    Document   : ViewAllRoles
    Created on : Oct 12, 2017, 6:46:57 PM
    Author     : Shavindra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>All Roles</title>
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
                    <h1>Roles</h1>
                    <hr>
                    <table class="table table-hover table-striped">

                        <thead>
                        <th>
                            Role ID
                        </th>

                        <th>
                            Role Title
                        </th>


                        </thead>
                        <c:forEach items="${result}" var="res">
                            <tr>
                                <td>
                                    <c:out value="${res.roleid}"></c:out>
                                    </td>
                                    <td>
                                    <c:out value="${res.title}"></c:out>
                                    </td>
                                    <td>
                                        <form method="get" action="ViewAllRoles">
                                            <input name="roleId" value="${res.roleid}" hidden/>
                                        <input name="config" value="edit" hidden/>
                                        <input type="submit" class="btn btn-primary form-control" value="Edit">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>


                </div>



                <div class="col-sm-2 sidenav">

                </div>



            </div>
        </div>

    </body>
</html>