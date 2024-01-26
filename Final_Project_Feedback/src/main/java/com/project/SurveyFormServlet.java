package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SurveyFormServlet")
public class SurveyFormServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/feedback";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "gopikapassword";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        
        try {
            
        	String name = request.getParameter("Name");
            String id = request.getParameter("id");
            String duration = request.getParameter("Duration");
            String ps = request.getParameter("Ps");
            String pgp = request.getParameter("pgp");
            String Q1 = request.getParameter("Q1");
            String Q2= request.getParameter("Q2");
            String Q3 = request.getParameter("Q3");
            String Q4 = request.getParameter("Q4");
            String Q5 = request.getParameter("Q5");
            String Q6= request.getParameter("Q6");
            String Q7 = request.getParameter("Q7");
            String Q8 = request.getParameter("Q8");
            String Q9 = request.getParameter("Q9");
            String Q10 = request.getParameter("Q10");
            String Q11 = request.getParameter("Q11");
            String Q12 = request.getParameter("Q12");
            String Q13 = request.getParameter("Q13");
            String Q14 = request.getParameter("Q14");
            String Q15 = request.getParameter("Q15");
            String Q16 = request.getParameter("Q16");
            String Q17 = request.getParameter("Q17");
            String Q18 = request.getParameter("Q18");
            String Q19 = request.getParameter("Q19");
            String Q20 =request.getParameter("Q20");           
            
            Class.forName("com.mysql.jdbc.Driver");

            
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            
            String sql1 = "INSERT INTO survey_responses (name, id, duration, ps, pgp,Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14,Q15,Q16,Q17,Q18,Q19,Q20 ) VALUES (?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql1);

            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, id);
            preparedStatement.setString(3, duration);
            preparedStatement.setString(4, ps);
            preparedStatement.setString(5, pgp);
            preparedStatement.setString(6, Q1);
            preparedStatement.setString(7, Q2);
            preparedStatement.setString(8, Q3);
            preparedStatement.setString(9, Q4);
            preparedStatement.setString(10, Q5);
            preparedStatement.setString(11, Q6);
            preparedStatement.setString(12, Q7);
            preparedStatement.setString(13, Q8);
            preparedStatement.setString(14, Q9);
            preparedStatement.setString(15, Q10);
            preparedStatement.setString(16, Q11);
            preparedStatement.setString(17, Q12);
            preparedStatement.setString(18, Q13);
            preparedStatement.setString(19, Q14);
            preparedStatement.setString(20, Q15);
            preparedStatement.setString(21, Q16);
            preparedStatement.setString(22, Q17);
            preparedStatement.setString(23, Q18);
            preparedStatement.setString(24, Q19);
            preparedStatement.setString(25, Q20);

            
            preparedStatement.executeUpdate();
            
            response.setContentType("text/html");
            PrintWriter out1 = response.getWriter();
			/*
			 * out1.println("<img src='thumb.png'/>");
			 * out1.println("Survey response saved successfully!");
			 * out1.println("<form action='DisplaySurveyResponses'>");
			 * out1.println("<input type='submit' value='View Survey Responses'>");
			 * out1.println("</form>");
			 */
            
            
            out1.println("<!DOCTYPE html>");
            out1.println("<html>");
            out1.println("<head>");
            out1.println("    <title>Survey Response Confirmation</title>");
            out1.println("    <style>");
            out1.println("        body {");
            out1.println("            display: flex;");
            out1.println("            flex-direction: column;");
            out1.println("            align-items: center;");
            out1.println("            background-color: lightblue;");
            out1.println("            justify-content: center;");
            out1.println("            height: 100vh;");
            out1.println("            margin: 0;");
            out1.println("        }");
            out1.println("");
            out1.println("        img {");
            out1.println("            size:60px");
            out1.println("            height: 50px;");
            out1.println("            margin-bottom: 20px;");
            out1.println("        }");
            out1.println("");
            out1.println("        p {");
            out1.println("            backgroung-color: violet;color: blue;");
            out1.println("            padding: 10px;"); // Add padding for better visual appearance
            out1.println("            border-radius: 8px;font-sixe:30px;"); // Add rounded corners
            out1.println("        }");
            out1.println("");
            out1.println("        form {");
            out1.println("            display: flex;");
            out1.println("            flex-direction: column;");
            out1.println("            align-items: center;");
            out1.println("        }");
            out1.println("    </style>");
            out1.println("</head>");
            out1.println("<body>");
            out1.print("<center>");
            out1.println("    <img src='thumbimage.png' alt='Survey Response Saved'/>");
            out1.println("    <p>Survey response saved successfully!</p>");
            out1.println("    <form action='DisplaySurveyResponses' method='get'>");
            out1.println("        <input type='submit' value='View Survey Responses'>");
            out1.println("    </form>");
            out1.print("</center>");
            out1.println("</body>");
            out1.println("</html>");

            

        } catch (ClassNotFoundException | SQLException e) {
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("Error: " + e.getMessage());
            e.printStackTrace();
            
           
        } finally {
            
            try {
                if (preparedStatement != null) 
                    preparedStatement.close();
                
                if (connection != null) 
                    connection.close();
                
            } catch (SQLException e) {
                e.printStackTrace();}
        }
}
}