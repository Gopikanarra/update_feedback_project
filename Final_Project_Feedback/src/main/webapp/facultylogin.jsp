<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>


<html>
	<head>
	
<link rel="stylesheet" type="text/css" href="style.css">
<style>
body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            background-image: url("vvit_drone_4k-min.jpg");
             background-repeat: no-repeat;
            background-size: cover;
        }


        #header h5 {
            font-size: 16px;
            color: #666;
        }

        #logo {
            float: left;
            margin-left: 20px;
        }

        #accreditation {
        	padding-left:20px;
            float: right;
            margin-right: 20px;
        }
        
        tr {
    display: table-row;
    vertical-align: inherit;
    border-color: inherit;
}
@keyframes pulse {
  0% {
    transform: scale(1);
  }
  50% {
    transform: scale(1.1);
  }
  100% {
    transform: scale(1);
  }
}

/* Apply the animation to the h1 element */
h1 {
  animation: pulse 2s infinite; /* 2s duration, infinite repetitions */
}

table {
    border-collapse: separate;
    text-indent: initial;
    white-space-collapse: collapse;
    text-wrap: wrap;
    line-height: normal;
    font-weight: normal;
    font-size: medium;
    font-style: normal;
    color:black;
    background-color:white;
    text-align: start;
    border-spacing: 2px;
    font-variant: normal;
}
input[type=submit] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border-radius: 4px;
    box-sizing: border-box;
    background-color: FF7F50;
    color: white;
}

input[type=text], [type=file], [type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
</style>
	</head>
	<div style="background-color: #f0f0f0">
	<!--  <table align="center">
  <tr>
 
    <td><img src="vvitlogo1.jpg" style="width:150px; height:120px;"></td>
    <td align="center">
      <h2 style="font-size: 24px;">Vasireddy Venkatadri Institute of Technology</h2>
      <h6 style="font-size: 12px;">Approved by AICTE - Permanently Affiliated to JNTUK - ISO 9001-2015 Certified<br>Accredited by NAAC with 'A' Grade - B.Tech ECE, MECH, CSE, EEE & IT are accredited by NBA</h6>
    </td>
    <td><img src="nba.jpg" style="width:150px; height:100px;"></td>
    <td><img src="naac.jpg" style="width:150px; height:100px;"></td>
  </tr>
</table> -->
</div>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<center>
<div style="background-color:white;box-shadow: 1px 1px 1px 1px;width: 400px;height: 300px;padding: 20px">

	<form method="post">
<h1>Faculty Login</h1>
	<table>
		<tr>
		<td>Faculty Id:</td>
		<td><input type="text" name="fid"></td>
		</tr>
		<tr>
		<td>Password:</td>
		<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
		<td></td>
		<th><input type="submit" value="Login" name="login"></th>
		</tr>
	</table>
	</form></div></center>
<%
        String url = "jdbc:mysql:///feedback";
        String user = "root";
        String password = "gopikapassword";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        HttpSession hp;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
			hp=request.getSession();
            // Handle form submission
            if (request.getParameter("login") != null) {
            	int faculty_id = 0; // Initialize with a default value, you can choose a different default value if needed
                try {
                    faculty_id = Integer.parseInt(request.getParameter("fid"));
                    hp.setAttribute("fid",request.getParameter("fid"));
                } catch (NumberFormatException e) {
                    // Handle the case where the faculty_id is not a valid integer
                    out.println("Invalid faculty ID format. Please enter a vali	d integer.");
                    return; // Exit the JSP processing
                }
                String user_pwd = request.getParameter("pwd");

                // SQL query to check faculty credentials
                String query = "SELECT * FROM faculty_login_table WHERE fac_id = ? AND fac_pwd = ?";

                pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, faculty_id);
                pstmt.setString(2, user_pwd);

                rs = pstmt.executeQuery();

                if (rs.next()) {
                    // Valid credentials, redirect to another page
                    hp.setAttribute("fname",rs.getString("fac_name"));
                    response.sendRedirect("faculty_display.jsp");
                } else {
                    // Invalid credentials, show an error message
                    out.println("Invalid credentials. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    %>

</body>

</html>
