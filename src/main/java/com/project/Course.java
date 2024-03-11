package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Course")
public class Course extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String rollno = request.getParameter("rnumber");

        HttpSession session = request.getSession();
        session.setAttribute("userId", rollno);
        String year = request.getParameter("year");
        String sem = request.getParameter("sem");
        String branch = request.getParameter("branch");
        session.setAttribute("year", year);
        session.setAttribute("sem", sem);
        session.setAttribute("branch", branch);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        
        if(year.equals("1") &&sem.equals("1") &&branch.equals("it") ) {
        	
        	response.sendRedirect("1-1.html");
        }
        else if(year.equals("1")&&sem.equals("2")&&branch.equals("it")){
        	response.sendRedirect("1-2.html");	
        }
        else if(year.equals("2")&&sem.equals("1")&&branch.equals("it")){
        	response.sendRedirect("2-1.html");	
        }
        else if(year.equals("2")&&sem.equals("2")&&branch.equals("it")){
        	response.sendRedirect("2-2.html");	
        }
        else if(year.equals("3")&&sem.equals("1")&&branch.equals("it")){
        	response.sendRedirect("3-1.html");	
        }
        else if(year.equals("3")&&sem.equals("2")&&branch.equals("it")){
        	response.sendRedirect("3-2.html");	
        }
        else if(year.equals("4")&&sem.equals("1")&&branch.equals("it")){
        	response.sendRedirect("4-1.html");	
        }

        
        
    }
}