package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SubmitFeedbackServlet")
public class SubmitFeedbackServlet extends HttpServlet {
	Connection con = null;
	PreparedStatement pstmt = null;
	static String url = "jdbc:mysql://localhost:3306/feedbackproject";
    static String dbUsername = "root";
    static String dbPassword = "gopika@123";
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		List<FacultyInfo> facultyInfoList = (List<FacultyInfo>) request.getAttribute("facultyInfoList");

		if (facultyInfoList != null) {
		    System.out.println("facultyInfoList is not null");
		    System.out.println("facultyInfoList size: " + facultyInfoList.size());
		   
		} else {
		    System.out.println("facultyInfoList is null");
		    // Log or handle the case where facultyInfoList is null
		}

		PrintWriter pw=response.getWriter();
        try {
            // ... Process submitted answers and store in the database ...
        	
        	int q1=Integer.parseInt(request.getParameter("q1"));
        	int q2=Integer.parseInt(request.getParameter("q2"));
        	int q3=Integer.parseInt(request.getParameter("q3"));
        	int q4=Integer.parseInt(request.getParameter("q4"));
        	int q5=Integer.parseInt(request.getParameter("q5"));
        	int q6=Integer.parseInt(request.getParameter("q6"));
        	int q7=Integer.parseInt(request.getParameter("q7"));
        	int q8=Integer.parseInt(request.getParameter("q8"));
        	int q9=Integer.parseInt(request.getParameter("q9"));
        	int q10=Integer.parseInt(request.getParameter("q10"));
        	int q11=Integer.parseInt(request.getParameter("q11"));
        	int q12=Integer.parseInt(request.getParameter("q12"));
        	int q13=Integer.parseInt(request.getParameter("q13"));
        	int q14=Integer.parseInt(request.getParameter("q14"));
        	int q15=Integer.parseInt(request.getParameter("q15"));
        	
        	String fid = request.getParameter("fid");
        	System.out.println(fid);
        	String sec=request.getParameter("sec");
        	String accYear = request.getParameter("acc_year");
        	System.out.println(accYear);
        	String rnumber=request.getParameter("rnumber");
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestampString = dateFormat.format(new Date());

        	try {
        		Class.forName("com.mysql.cj.jdbc.Driver");
        		con = DriverManager.getConnection(url, dbUsername, dbPassword);
        		String insert_feedback_data="insert into feedback_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        		pstmt=con.prepareStatement(insert_feedback_data);
        		pstmt.setString(1,timestampString);
        		pstmt.setString(2,fid);
        		pstmt.setString(3,sec);
        		pstmt.setString(4,accYear);
        		pstmt.setString(5,rnumber);
        		pstmt.setInt(6, q1);
        		pstmt.setInt(7, q2);
        		pstmt.setInt(8, q3);
        		pstmt.setInt(9, q4);
        		pstmt.setInt(10, q5);
        		pstmt.setInt(11, q6);
        		pstmt.setInt(12, q7);
        		pstmt.setInt(13, q8);
        		pstmt.setInt(14, q9);
        		pstmt.setInt(15, q10);
        		pstmt.setInt(16, q11);
        		pstmt.setInt(17, q12);
        		pstmt.setInt(18, q13);
        		pstmt.setInt(19, q14);
        		pstmt.setInt(20, q15);
        		pstmt.executeUpdate();
        		
        		// Increment the current faculty index in the request
                
         
                
          	}catch(Exception e) {
          		e.printStackTrace();
          		pw.print("<h1> please go back and fill the details again..!!</h1>");
        	}
            // Forward to the next faculty member's questions page
//        	response.sendRedirect("confirmation.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
				DatabaseConnection.closeConnection(con, pstmt,null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
            } 
    }
	

	}


