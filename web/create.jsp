<%-- 
    Document   : create
    Created on : Dec 15, 2019, 5:56:59 PM
    Author     : OJHA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Student</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div class="topnav">
            <a href="index.html">Home</a>
            <a class="active" href="create.jsp">Create</a>
            <a href="read.jsp">Read</a>
            <a href="update.jsp">Update</a>
            <a href="delete.jsp">Delete</a>
        </div>
        <div style="padding-left:56px; padding-top: 20px; color:#4CAF50;">
            <%
                String msg = (String) request.getAttribute("msg");
                if (msg == null) {
                    msg = "";
                }
            %>
            <%=msg%>
        </div>
        <div style="padding-left:96px;">
            <h2>Add a Student</h2>
        </div>
        <div style="padding-left:56px">
            <form method="post" action="StudentController">
                <input type="hidden" name="action" value="create">
                <table>
                    <tr>
                        <td>Name:</td><td><input type="text" name="sname" required></td>
                    </tr>
                    <tr>
                        <td>Roll No:</td><td><input type="text" name="rollno" required></td>
                    </tr>
                    <tr>
                        <td>Semester:</td>
                        <td><select name="semester">
                                <option value="1">1st</option>
                                <option value="2">2nd</option>
                                <option value="3">3rd</option>
                                <option value="4">4th</option>
                                <option value="5">5th</option>
                                <option value="6">6th</option>
                                <option value="7">7th</option>
                                <option value="8">8th</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Submit"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
