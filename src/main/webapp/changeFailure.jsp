<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Password Change Failed</title>
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"/>
    
    <style>
    body{
    
    background-color:lightblue;
    
    }
    .first{
    padding-top:280px;
    width: 350px;
     height:450px;
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
<center>
<div class="first">
<i class="fa-solid fa-circle-xmark"></i>
    <h2>Password Change Failed</h2>
    <c:choose>
        <c:when test="${param.error eq 'fields_required'}">
            <p>All fields are required. Please fill in all fields.</p>
        </c:when>
        <c:when test="${param.error eq 'password_mismatch'}">
            <p>Password and Confirm Password do not match. Please try again.</p>
        </c:when>
        <c:when test="${param.error eq 'password_not_unique'}">
            <p>The chosen password is not unique. Please choose a different password.</p>
        </c:when>
        <c:when test="${param.error eq 'update_failed'}">
            <p>There was an error updating your password. Please try again.</p>
        </c:when>
        <c:otherwise>
            <p>There was an error changing your password. Please try again.</p>
        </c:otherwise>
    </c:choose>
    <a href="changepwd.jsp">Go back to Change Password</a>
</div>
</center>

</body>
</html>
