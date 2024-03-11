<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Change Password</title>
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
        .login-box {
            width: 350px;
            height:450px;
            padding: 10px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #ffffff;
            text-align: center;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
        }
        .login-box img {
            width: 100px;
            height: 100px;
            margin-bottom: 20px;
        }
        .login-box input,
        .login-box select {
            width: 50%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .login-box button {
            width: 50%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <center>
    <form id="loginForm"action="ChangePassword" method="post">
    <div class="login-box">
        <img src="vvitlogo.png" alt="Logo">
       
    <h2>Change Password</h2>
            <div id="studentFields"><br/>
            <table>
            <tr>
            <td><label for="userId">User ID:</label></td>
            <td><input type="text" id="userId" name="userId" required><br></td>
            </tr>
            <tr>
              <td>  <label for="newPassword">New Password:</label></td>
              <td> <input type="password" id="newPassword" name="newPassword" required><br></td>
                </tr>
                <tr>
               <td><label for="confirmNewPassword">Confirm New Password:</label></td>
                <td><input type="password" id="confirmNewPassword" name="confirmNewPassword" required><br></td>
                </tr>
                </table>
            </div>
            <br/>
            <button type="submit">Login</button>
            <p id="errorText" class="error"></p>
        </form>
    </div>
    </center>
</body>
</html>
