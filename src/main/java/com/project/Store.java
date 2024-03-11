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
import javax.servlet.http.HttpSession;

@WebServlet("/Store")
public class Store extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            con = DBConnect.connect();
            HttpSession session = request.getSession();
            String userId = (String) session.getAttribute("userId");
            String year = (String) session.getAttribute("year");
            String sem = (String) session.getAttribute("sem");
            String branch = (String) session.getAttribute("branch");
            String query ="INSERT INTO subjects (rollno,subject ,co1, co2, co3, co4, co5) VALUES (?, ?, ?, ?, ?, ?,?)";
            
            PreparedStatement Stmt1 = con.prepareStatement(query);
            PreparedStatement Stmt2 = con.prepareStatement(query);
            PreparedStatement Stmt3 = con.prepareStatement(query);
            PreparedStatement Stmt4 = con.prepareStatement(query);
            PreparedStatement Stmt5 = con.prepareStatement(query);
            if(year.equals("1") &&sem.equals("1") &&branch.equals("it") ) {
            	Stmt1.setString(2,"Mathematics (m-1) ");
            	Stmt2.setString(2,"applied chemistry");
            	Stmt3.setString(2,"BEEE");
            	Stmt4.setString(2,"Computer  Workshop");
            	Stmt5.setString(2," C Programming");
            	
            	 
            }
            else if(year.equals("1")&&sem.equals("2")&&branch.equals("it")){
            	Stmt1.setString(2,"Mathematics (m-2) ");
            	Stmt2.setString(2,"Applied Physics");
            	Stmt3.setString(2,"Communicative English");
            	Stmt4.setString(2," Python Programming");
            	Stmt5.setString(2,"Digital Logic Design");	
            }
            else if(year.equals("2")&&sem.equals("1")&&branch.equals("it")){
                	Stmt1.setString(2,"mathematics (m-3)");
                	Stmt2.setString(2,"MFCS ");
                	Stmt3.setString(2,"data structures");
                	Stmt4.setString(2,"java  Programming ");
                	Stmt5.setString(2,"software engineering");
            }
            else if(year.equals("2")&&sem.equals("2")&&branch.equals("it")){
            	Stmt1.setString(2,"probability and statistics");
            	Stmt2.setString(2,"Computer Organization");
            	Stmt3.setString(2,"Operating Systems");
            	Stmt4.setString(2,"Database Management Systems");
            	Stmt5.setString(2,"Advanced Java Programming");
            }
            else if(year.equals("3")&&sem.equals("1")&&branch.equals("it")){
            	Stmt1.setString(2,"Computer Networks");
            	Stmt2.setString(2,"Artificial Intelligence");
            	Stmt3.setString(2,"Automata Theory and Compiler Design");
            	Stmt4.setString(2,"Data Warehousing and Data Mining ");
            	Stmt5.setString(2,"Front End Development");
            }
            else if(year.equals("3")&&sem.equals("2")&&branch.equals("it")){
            	Stmt1.setString(2,"Engineering Economics and Management");
            	Stmt2.setString(2,"Design and Analysis of Algorithms");
            	Stmt3.setString(2,"Cryptography and Network Security");
            	Stmt4.setString(2,"Machine Learning");
            	Stmt5.setString(2,"Cloud computing");
            }
            else if(year.equals("4")&&sem.equals("1")&&branch.equals("it")){
            	Stmt1.setString(2,"nhv&nv");
            	Stmt2.setString(2,"Big Data Analytics");
            	Stmt3.setString(2,"Deep Learning");
            	Stmt4.setString(2,"Data Science");
            	Stmt5.setString(2,"Blockchain ");
            }
            


            // Set parameters for each subject's statement
            Stmt1.setString(1, userId);
            Stmt2.setString(1, userId);
            Stmt3.setString(1, userId);
            Stmt4.setString(1, userId);
            Stmt5.setString(1, userId);

            // Set feedback values for each subject
            for (int i = 1; i <=5 ; i++) {
                Stmt1.setString(i + 2, request.getParameter("co" + i));
                Stmt2.setString(i + 2, request.getParameter("aco" + i));
                Stmt3.setString(i + 2, request.getParameter("bco" + i));
                Stmt4.setString(i + 2, request.getParameter("cco" + i));
                Stmt5.setString(i + 2, request.getParameter("dco" + i));
            }

            // Execute the statements to insert feedback
            Stmt1.executeUpdate();
            Stmt2.executeUpdate();
            Stmt3.executeUpdate();
            Stmt4.executeUpdate();
            Stmt5.executeUpdate();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"ISO-8859-1\">");
            out.println("<title>Insert title here</title>");
            out.println("<style type=\"text/css\">");
            out.println("body {");
            out.println("    background: url('vvit_drone_blur.png');");
            out.println("    background-repeat: no-repeat;");
            out.println("    background-size: cover;");
            out.println("    width: 100%;");
            out.println("    height: 100vh;");
            out.println("    margin: 0;");
            out.println("    display: flex;");
            out.println("    flex-direction: column;");
            out.println("    align-items: center;");
            out.println("    justify-content: center;");
            out.println("}");
            out.println(".btn {");
            out.println("    background: linear-gradient(to right, #FF8F8F, #EC8F5E);");
            out.println("    background-size: 100% 100%;");
            out.println("    border-radius: 4px;");
            out.println("    text-align: center;");
            out.println("    padding: 10px 20px; /* Add padding for better appearance */");
            out.println("}");
            out.println(".header-container {");
            out.println("    display: flex;");
            out.println("    align-items: center;");
            out.println("}");
            out.println(".logo {");
            out.println("    width: 120px;");
            out.println("    height: 120px;");
            out.println("}");
            out.println(".header-text {");
            out.println("    margin-left: 20px; /* Adjust margin as needed */");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"header-container\">");
            out.println("    <img src=\"vvitlogo.png\" alt=\"VVIT Logo\" class=\"logo\">");
            out.println("    <div class=\"header-text\">");
            out.println("        <h1>Vasireddy Venkatadri Institute of Technology</h1>");
            out.println("        <h5>Approved by AICTE - Permanently Affiliated to JNTUK - ISO 9001-2015 Certified<br>Accredited by NAAC with 'A' Grade - B.Tech ECE, MECH, CSE, EEE & IT are accredited by NBA</h5>");
            out.println("    </div>");
            out.println("</div>");
            out.println("<marquee style=\"width: 70%; white-space: nowrap;\" behavior=\"scroll\" direction=\"left\" scrollamount=\"10\">");
            out.println("    <h1 style=\"text-align: center; color: white; font-size: 50px;\">You have successfully submitted the Feedback..!</h1>");
            out.println("</marquee>");
            out.println("<img src=\"finish.jpg\" alt=\"Your Image\" style=\"display: block; height: 360px; margin: 0 auto;\"><br/>");
            out.println("<button id=\"btn\" type=\"button\" onclick=\"window.location.href='index.html'\" class=\"btn\">Go Back :)</button>");
            out.println("</body>");
            out.println("</html>");

          

        
         
           
        }
       catch (Exception e) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("Error: " + e.getMessage());
        } finally {
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