/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author OJHA
 */
public class StudentDao {

    private static final String URL = "jdbc:derby://localhost:1527/ojhaDB";
    private static final String USERNAME = "ojha";
    private static final String PASSWORD = "ojha";

    public StudentDao() throws ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
    }

    protected Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return con;
    }

    public int insertStudent(Student aStudent) throws SQLException {
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        String sql = "INSERT INTO student(sname, rollno, semester) VALUES('";
        sql = sql + aStudent.getSname() + "'," + aStudent.getRollno() + "," + aStudent.getSemester() + ")";
        int n = stmt.executeUpdate(sql);
        return n;
    }

    public Student searchStudent(int rollno) throws SQLException {
        Student aStudent = null;
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM student WHERE rollno=" + rollno;
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            aStudent = new Student(rs.getString("sname"), rs.getInt("rollno"), rs.getInt("semester"));
        }
        return aStudent;
    }

    public int updateStudent(Student aStudent) throws SQLException {
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        String sql = "UPDATE student SET sname='"+aStudent.getSname()+"', semester="+aStudent.getSemester();
        sql=sql+" WHERE rollno="+aStudent.getRollno();
        int n = stmt.executeUpdate(sql);
        return n;
    }
  public int deleteStudent(int rollno) throws SQLException {
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        String sql = "DELETE FROM student WHERE rollno="+rollno;
        int n = stmt.executeUpdate(sql);
        return n;
    }  
}