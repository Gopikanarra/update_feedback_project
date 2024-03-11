<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Password Changed Successfully</title>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"/>
    <style>
    body{
    
    background-color:lightblue;
    
    }
    .first{
    padding-top:280px;
    width: 350px;
     height:250px;
     padding: 10px;
     position: absolute;
     top: 50%;
     left: 50%;
      transform: translate(-50%, -50%);
      background-color: #ffffff;
      text-align: center;
       box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.4);
    
    }
    .first i {
            font-size: 36px; /* Adjust the font-size as needed */
        }
    .first a {
            display: inline-block;
            padding: 10px 20px;
            margin-top: 20px;
            background-color: #52D3D8; 
            color:black; /* Button text color */
            text-decoration: none;
            border-radius: 5px; /* Optional: Add rounded corners */
            transition: background-color 0.3s ease;
        }

        .first a:hover {
        color:white;
            background-color: #3887BE; /* Button background color on hover */
        }
    </style>
</head>
<body>
<br/>
<br/>
<center>
<div class="first">
<br/>
<br/>
<br/>
<i class="fa-solid fa-square-check"></i>

    <h2>Password Changed Successfully</h2>
    
    <a href="facultylogin.jsp">Go to Login Page</a>
    </center>
    </div>
</body>
</html>
