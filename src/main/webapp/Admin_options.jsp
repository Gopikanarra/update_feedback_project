<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style>
        #div2 {
            margin-left: 150px;
            float: left;
        }
         td {
            padding: 10px; /* Adjust the value to add the desired space */
        }

        #div1 {
            text-align: center;
            float: left;
        }

        #div4 {
          
            box-sizing:border-box;
            border-radius:2px;
            background:lightgrey;
            padding-top:50px;
            box-shadow: 1px 1px 1px 1px;
            width: 400px;
            height: 300px;
           justify-content:center;
        }
        #div4 a{
        display: inline-block;
    background: linear-gradient(45deg,#12B0E8,#E03B8B);
    border-radius: 6px;
    padding: 10px 20px;
    box-sizing: border-box;
    text-decoration: none;
    color: white;
    box-shadow: 3px 8px 22px rgba(94,28,68,0.15);
    transition: 0.6s;
    }
    </style>
</head>
<body>
<!-- <div id="div2">
    <img src="vvitlogo.png" style="width:120px;height:120px;">
</div> -->
<div style="background-color: #f0f0f0">
	 <table align="center">
  <tr>
 
    <td><img src="vvitlogo1.jpg" style="width:150px; height:120px;"></td>
    <td align="center">
      <h2 style="font-size: 24px;">Vasireddy Venkatadri Institute of Technology</h2>
      <h6 style="font-size: 12px;">Approved by AICTE - Permanently Affiliated to JNTUK - ISO 9001-2015 Certified<br>Accredited by NAAC with 'A' Grade - B.Tech ECE, MECH, CSE, EEE & IT are accredited by NBA</h6>
    </td>
    <td><img src="nba.jpg" style="width:150px; height:100px;"></td>
    <td><img src="naac.jpg" style="width:150px; height:100px;"></td>
  </tr>
</table>
</div><br/><br/><br/><br/>
<center>
<form>
<table align="center" cellpadding="50">
  <tr>
    <td >
      <a href="Add_Teacher.html">
        <img src="add_faculty_image.png" width="300" height="300"><br>
        <h2 align="center">Add Faculty</h2>
      </a>
    </td>

    <td>
      <a href="admin.html">
        <img src="log_out_here.png" width="300" height="300"><br>
        <h2 align="center">log out</h2>
      </a>
    </td>

    
  </tr>
</table>
</form>
</center>
<br><br>
</body>
</html>