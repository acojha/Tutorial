<%-- 
    Document   : read
    Created on : Dec 15, 2019, 6:27:05 PM
    Author     : OJHA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Student"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search Student</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">     
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div class="topnav">
            <a href="index.html">Home</a>
            <a href="create.jsp">Create</a>
            <a class="active" href="read.jsp">Read</a>
            <a href="update.jsp">Update</a>
            <a href="delete.jsp">Delete</a>
        </div>
        <div style="padding-left:96px; padding-top: 20px;">
            <h2>Search Student</h2>
        </div>

        <div style="padding-left:56px">
            <form method="post" action="StudentController">
                <input type="hidden" name="action" value="read">
                <table>
                    <tr>
                        <td>Roll No:</td><td><input type="text" name="rollno" required></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Submit"></td>
                    </tr>
                </table>
            </form>
        </div>
        <p>&nbsp;</p>
        <div style="padding-left:66px; color:#4CAF50;">
            <%
                Student aStudent = (Student) request.getAttribute("found");
                if (aStudent != null) {
            %>
            <table border="1" cellspacing="0" cellpadding="5">
                <tr><th>Name</th><th>Roll No</th><th>Semester</th></tr>
                <tr><td><%=aStudent.getSname()%></td><td><%=aStudent.getRollno()%></td><td><%=aStudent.getSemester()%></td></tr>
            </table>
            <%
                }
            %>
            <%
                String msg = (String) request.getAttribute("msg");
                if (msg == null) {
                    msg = "";
                }
            %>
            <%=msg%>
        </div>
    </body>
</html>
