/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

import model.Student;
import dao.StudentDao;

/**
 *
 * @author OJHA
 */
public class StudentController extends HttpServlet {

    private StudentDao sdao = null;

    @Override
    public void init() throws ServletException {
        // Initialization code...
        try {
            sdao = new StudentDao();
        } catch (Exception e) {
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String action = request.getParameter("action");

            switch (action) {
                case "create":
                    create(request, response);
                    break;
                case "read":
                    read(request, response);
                    break;
                case "retrieve":
                    retrieve(request, response);
                    break;
                case "update":
                    update(request, response);
                    break;
                case "confirm":
                    confirm(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String sname = request.getParameter("sname");
        int rollno = Integer.parseInt(request.getParameter("rollno"));
        int semester = Integer.parseInt(request.getParameter("semester"));
        Student aStudent = new Student(sname, rollno, semester);
        int n = sdao.insertStudent(aStudent);
        if (n == 1) {
            request.setAttribute("msg", "One student added to the database...");
            RequestDispatcher rd = request.getRequestDispatcher("create.jsp");
            rd.forward(request, response);
        }

    }

    private void getStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int rollno = Integer.parseInt(request.getParameter("rollno"));
        Student aStudent = sdao.searchStudent(rollno);
        if (aStudent != null) {
            request.setAttribute("found", aStudent);
        } else {
            request.setAttribute("msg", "No student found!");
        }
    }

    private void read(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        getStudent(request, response);
        RequestDispatcher rd = request.getRequestDispatcher("read.jsp");
        rd.forward(request, response);
    }

    private void retrieve(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        getStudent(request, response);
        RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
        rd.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String sname = request.getParameter("sname");
        int rollno = Integer.parseInt(request.getParameter("rollno"));
        int semester = Integer.parseInt(request.getParameter("semester"));
        Student aStudent = new Student(sname, rollno, semester);
        int n = sdao.updateStudent(aStudent);
        if (n == 1) {
            request.setAttribute("msg", "One student updated in the database...");
            RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
            rd.forward(request, response);
        }
    }

    private void confirm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        getStudent(request, response);
        RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
        rd.forward(request, response);
    }
private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int rollno = Integer.parseInt(request.getParameter("rollno"));
        int n = sdao.deleteStudent(rollno);
        if (n == 1) {
            request.setAttribute("msg", "One student deleted from the database...");
            RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
            rd.forward(request, response);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
