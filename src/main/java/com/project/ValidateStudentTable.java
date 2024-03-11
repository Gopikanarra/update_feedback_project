package com.project;
import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.security.Timestamp;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ValidateStudentTable")
public class ValidateStudentTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String id=null;
	static String url = "jdbc:mysql://localhost:3306/feedbackproject";
    static String dbUsername = "root";
    static String dbPassword = "gopika@123";
//    static List<FacultyInfo> facultyInfoList = new ArrayList<>();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		try {
			con=DriverManager.getConnection(url,dbUsername,dbPassword);
	            System.out.println(con);
	            id=request.getParameter("registerNo");
	            String acc=request.getParameter("acc_year");
	            String year=request.getParameter("year");
	            String branch=request.getParameter("branch");
	            System.out.println(branch);
	            String sem=request.getParameter("semester");
	            String cycle=request.getParameter("cycle");
	            String sec=request.getParameter("section");
	            String stname="s"+year+sem+id;
	            java.sql.DatabaseMetaData metadata = con.getMetaData();
	            rs = metadata.getTables(null, null, stname, null);
	            if(rs.next()) {
	            	request.getRequestDispatcher("completed.html").forward(request, response);
	            }else {
	            	String ss = year + "_" + sem + "_" + branch + "_" + sec;
	            	System.out.println(ss); 
	            	
	            	// Query to retrieve faculty information based on section and academic year
	                String facultyQuery = "SELECT fid, sub, fname FROM faculty WHERE sec = ? AND acc_year = ?";
	                PreparedStatement facultyStmt = con.prepareStatement(facultyQuery);
	                facultyStmt.setString(1, ss);
	                facultyStmt.setString(2,acc );
	                ResultSet facultyResult = facultyStmt.executeQuery();

	                int fid = 0;
	                String sub = null;
	                String fname = null;

	             // Loop through faculty records
//	             while (facultyResult.next()) {
//	                 fid = facultyResult.getInt("fid");
//	                 sub = facultyResult.getString("sub");
//	                 fname = facultyResult.getString("fname");
//	                 System.out.println(fid+"\n"+sub+"\n"+fname);
//	                 // Store faculty information in a list
//	                 facultyInfoList.add(new FacultyInfo(fid, sub, fname));
//	             }
	                
	                while (facultyResult.next()) {
	                    fid = facultyResult.getInt("fid");
	                    sub = facultyResult.getString("sub");
	                    fname = facultyResult.getString("fname");
	                    System.out.println(fid + "\n" + sub + "\n" + fname);
	                    
	                    fname = fname.trim(); 
	                    fname = URLEncoder.encode(fname, "UTF-8");
	                    sub = sub.trim(); 
	                    sub = URLEncoder.encode(sub, "UTF-8");
	                    
	                    // Creating cookies for faculty information
	                    javax.servlet.http.Cookie facultyIdCookie = new javax.servlet.http.Cookie("facultyId", String.valueOf(fid));
	                   javax.servlet.http.Cookie subjectCookie = new javax.servlet.http.Cookie("subject", sub);
	                    javax.servlet.http.Cookie facultyNameCookie = new javax.servlet.http.Cookie("facultyName", fname);

	                    // Setting the cookies to expire in 24 hours (you can adjust this as needed)
	                    facultyIdCookie.setMaxAge(24 * 60 * 60);
	                    subjectCookie.setMaxAge(24 * 60 * 60);
	                    facultyNameCookie.setMaxAge(24 * 60 * 60);

	                    // Adding the cookies to the response
	                    response.addCookie(facultyIdCookie);
	                    response.addCookie(subjectCookie);
	                    response.addCookie(facultyNameCookie);
	                    
	                }

	                
	                
	                String createStudentTableSQL = "CREATE TABLE IF NOT EXISTS " + stname + " (" +
	                        "`fid` INT ," +
	                        "`sub` TEXT," +
	                        "`sec` TEXT," +
	                        "`fname` TEXT" +
	                        
	                        ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
	                java.sql.Statement createStudentTableStmt = con.createStatement();
	                System.out.println("student table created..!!");
	                createStudentTableStmt.executeUpdate(createStudentTableSQL);
	             
//	                System.out.println("Faculty Info List Size: " + facultyInfoList.size());
//	                for(FacultyInfo f:facultyInfoList) {
//	                	int facid=f.getFid();
//	                	String subj=f.getSub();
//	                	String facname=f.getFname();
//	                	System.out.println(facid);
//	                	System.out.println(subj);
//	                	System.out.println(facname);
//	                	System.out.println("------------------------");
	                
	                facultyResult = facultyStmt.executeQuery();
	                
	                while (facultyResult.next()) {
	                	System.out.println("next loop running!!");
	                    fid = facultyResult.getInt("fid");
	                    sub = facultyResult.getString("sub");
	                    fname = facultyResult.getString("fname");
	                    System.out.println(fid + "\n" + sub + "\n" + fname);
	                    
	                    fname = fname.trim(); 
	                    fname = URLEncoder.encode(fname, "UTF-8");
	                    sub = sub.trim(); 
	                    sub = URLEncoder.encode(sub, "UTF-8");
	                     
	                    // Creating cookies for faculty information
	                    javax.servlet.http.Cookie facultyIdCookie = new javax.servlet.http.Cookie("facultyId", String.valueOf(fid));
	                    javax.servlet.http.Cookie subjectCookie = new javax.servlet.http.Cookie("subject", sub);
	                    javax.servlet.http.Cookie facultyNameCookie = new javax.servlet.http.Cookie("facultyName", fname);

	                    // Setting the cookies to expire in 24 hours (you can adjust this as needed)
	                    facultyIdCookie.setMaxAge(24 * 60 * 60);
	                    subjectCookie.setMaxAge(24 * 60 * 60);
	                    facultyNameCookie.setMaxAge(24 * 60 * 60);

	                    // Adding the cookies to the response
	                    response.addCookie(facultyIdCookie);
	                    response.addCookie(subjectCookie);
	                    response.addCookie(facultyNameCookie);

	                    // Inserting into the database (if needed, modify as per your requirements)
	                    String query = "INSERT INTO " + stname + " VALUES(?, ?, ?, ?)";
	                    PreparedStatement inserting = con.prepareStatement(query);
	                    inserting.setInt(1, fid);
	                    inserting.setString(2, sub);
	                    inserting.setString(3, ss);
	                    inserting.setString(4, fname);
	                    int rowsAffected = inserting.executeUpdate();
	                    // Handle the result of the database insertion as needed

	                    System.out.println("------------------------");
	                

//	                	String query="insert into "+stname+" values(?,?,?,?)";
//	                	PreparedStatement inserting=con.prepareStatement(query);
//	                	inserting.setInt(1,facid);
//	                	inserting.setString(2,subj);
//	                	inserting.setString(3,sec);
//	                	inserting.setString(4,facname);
//	                	 int rowsAffected=inserting.executeUpdate();
	                	//store the faculty details in request attribute
	                
	                System.out.println("request sending.....");
	                System.out.println(fid);
	                System.out.println(cycle);
	                System.out.println(acc);
	                System.out.println(ss);
	                System.out.println(id);
//	                 request.setAttribute("facultyInfoList", facultyInfoList);
	                 request.setAttribute("cycle",cycle);
	                 request.setAttribute("acc_year",acc);
	                 request.setAttribute("sec",ss);
	                 request.setAttribute("id",id);					/* request.setAttribute("currentIndex", 0); */
	            }
	                
	                RequestDispatcher dd = request.getRequestDispatcher("question.jsp");
	                dd.forward(request, response);	                }

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
