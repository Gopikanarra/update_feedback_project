package com.project;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Addteacher")
public class AddTeacher extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = null;
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            con = DBConnect.connect();
            String insertteacherSQL = "INSERT INTO teacher (id, name, branch, x) VALUES (?, ?, ?, ?)";
            PreparedStatement teacherStmt = con.prepareStatement(insertteacherSQL);
            teacherStmt.setString(1, request.getParameter("id"));
            teacherStmt.setString(2, request.getParameter("name"));
            teacherStmt.setString(3, request.getParameter("branch"));
            
            teacherStmt.executeUpdate();
            out.println("<center><h1>Added</h1></center>");
        }catch (Exception e) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("Error: " + e.getMessage());
        }
        finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}


}