<%-- 
    Document   : update
    Created on : Dec 15, 2019, 7:04:32 PM
    Author     : OJHA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Student"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Update Student</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">     
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div class="topnav">
            <a href="index.html">Home</a>
            <a href="create.jsp">Create</a>
            <a href="read.jsp">Read</a>
            <a class="active" href="update.jsp">Update</a>
            <a href="delete.jsp">Delete</a>
        </div>
        <div style="padding-left:96px; padding-top: 20px;">
            <h2>Update Student</h2>
        </div>

        <div style="padding-left:56px">
            <form method="post" action="StudentController">
                <input type="hidden" name="action" value="retrieve">
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
            <form method=post" action="StudentController">
                <input type="hidden" name="action" value="update">
                <table border="0" cellspacing="0" cellpadding="5">
                    <tr><td>Name</td><td><input type="text" name="sname" value="<%=aStudent.getSname()%>"></td></tr>
                    <tr><td>Roll No</td><td><input type="text" name="rollno" value="<%=aStudent.getRollno()%>" readonly></td></tr>
                    <tr><td>Semester</td>
                        <td><select name="semester">
                                <option value="1" <% if (aStudent.getSemester() == 1) {%> selected <%}%> >1st</option>
                                <option value="2" <% if (aStudent.getSemester() == 2) {%> selected <%}%> >2nd</option>
                                <option value="3" <% if (aStudent.getSemester() == 3) {%> selected <%}%> >3rd</option>
                                <option value="4" <% if (aStudent.getSemester() == 4) {%> selected <%}%> >4th</option>
                                <option value="5" <% if (aStudent.getSemester() == 5) {%> selected <%}%> >5th</option>
                                <option value="6" <% if (aStudent.getSemester() == 6) {%> selected <%}%> >6th</option>
                                <option value="7" <% if (aStudent.getSemester() == 7) {%> selected <%}%> >7th</option>
                                <option value="8" <% if (aStudent.getSemester() == 8) {%> selected <%}%> >8th</option>
                            </select></td>
                    </tr>
                    <tr><td colspan="2" align="center"><input type="submit" value="Update"></tr>
                </table>
            </form>
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