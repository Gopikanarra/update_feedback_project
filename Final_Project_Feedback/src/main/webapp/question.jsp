<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.feedback.FacultyInfo" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Date" %>
<%
    ArrayList<FacultyInfo> facultyInfoList = (ArrayList<FacultyInfo>)request.getAttribute("facultyInfoList");
    int facultyIndex = 0;
    String accYear =(String)request.getAttribute("acc_year"); 
    String cycle = (String)request.getAttribute("cycle"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback Form</title>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
  body {
    font-family: Times New Romar;
    font-size:20px;
    margin: 0px;
    display: flex;
    justify-content: center;
    align-items: center;
    
    
    background-color: #f4f4f4;
  }
  .page-container {
    background-color: #ffffff;
    padding: 20px;
    border-radius: 25px;
    box-shadow: 0 2px 4px rgba(0, 0, 0,0.5);
    width: 100%;
    max-width: 800px;
    border-color:"black";
    
  }
.page-container1 {
   
    padding: 20px;
    border-radius: 25px;
    
    width: 100%;
    max-width: 1000px;
    border-color:"black";
    
  }

#header {
		
            text-align: center;
}
   .header {
    text-align: center;
    margin-bottom: 30px;
  }
  .divider {
    height: 2px;
    background-color: #ccc;
    margin: 20px 0;
  }
  .question {
    margin-bottom: 10px;
    
  }
  .question-text {
    
    font-weight: bold;
    margin-bottom: 10px;
  }
  .options {
    display: flex;
    
  }
  label {
    margin-right: 10px;

    
  }
.submit {
  background-color: #4CAF50; /* Green */
  border: none;
  color: black;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}
</style>
    <script>
    $(document).ready(function () {
        var facultyIndex = 0;
        var facultyInfoList = <%= new Gson().toJson(facultyInfoList) %>;

        function submitForm() {
            $.ajax({
                type: 'POST',
                url: 'ValidateStudentTable',
                data: $('#questionsForm').serialize(),
                success: function (data) {
                    $('#questionsFormContainer').html(data);
                    facultyIndex++;
                    if (facultyIndex < facultyInfoList.length) {
                        loadFacultyForm();
                    } else {
                        window.location.href = 'complete.html';
                    }
                }
            });
        }

        function loadFacultyForm() {
            var faculty = facultyInfoList[facultyIndex];
            $('#fid1').val(faculty.getFid());
            $('#fname').val(faculty.getFname());
            $('#sub').val(faculty.getSub());
            $('#sec').val(faculty.getSec());
            $('#acc').val('<%= accYear %>');
            $('#cycle').val('<%= cycle %>');
            $('input[type="radio"]').prop('checked', false); // Uncheck all radio buttons
        }

        loadFacultyForm();

        $('#submitBtn').click(function (event) {
            event.preventDefault();
            submitForm();
        });
    });
</script>

</head>
<body>
   <div>
 <div class="page-container1">
    
<img src="logo.png">
    </div>


<div class="page-container">
    <div class="header">
      <h2>STUDENT FEEDBACK ON FACULTY</h2>
     
    </div>
    
    <div class="divider"></div>
    
    <hr>
    
     <h4>Academic Year: <%= accYear %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Cycle: <%= cycle %></h4>
        <h4>Faculty Name: <span id="fname"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Faculty Id: <span id="fid1"></span></h4>
        <input type='hidden' value='$name' id='fid1' width="40px">
        <h5>Subject : <span id="sub"></span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>Section : <span id="sec"></span></h5>
        <hr>
     <div class="divider"></div>
     <div class="question">
        <p class="question-text">Q1. Student knowledge:</p><br>
        <div class="options">
          <label><input type="radio" name="q1" value="a"> Excellent</label>
          <label><input type="radio" name="q1" value="b"> Very Good</label>
          <label><input type="radio" name="q1" value="c"> Good</label>
          <label><input type="radio" name="q1" value="d"> Average</label>
          <label><input type="radio" name="q1" value="e"> Bad</label>
        </div>
      </div><br>
      <div class="question">
        <p class="question-text">Q2. Effectively utilizes Black Board:</p><br>
        <div class="options">
          <label><input type="radio" name="q2" value="a"> Excellent</label>
          <label><input type="radio" name="q2" value="b"> Very Good</label>
          <label><input type="radio" name="q2" value="c"> Good</label>
          <label><input type="radio" name="q2" value="d"> Average</label>
          <label><input type="radio" name="q2" value="e"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q3. Clear and audible voice:</p><br>
        <div class="options">
          <label><input type="radio" name="q3" value="a"> Excellent</label>
          <label><input type="radio" name="q3" value="b"> Very Good</label>
          <label><input type="radio" name="q3" value="c"> Good</label>
          <label><input type="radio" name="q3" value="d"> Average</label>
          <label><input type="radio" name="q3" value="e"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q4. Completes the syllabus in the stipulated time :</p><br>
        <div class="options">
          <label><input type="radio" name="q4" value="a"> Excellent</label>
          <label><input type="radio" name="q4" value="b"> Very Good</label>
          <label><input type="radio" name="q4" value="c"> Good</label>
          <label><input type="radio" name="q4" value="d"> Average</label>
          <label><input type="radio" name="q4" value="e"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q5. Provides information beyond the syllabus :</p><br>
        <div class="options">
          <label><input type="radio" name="q5" value="a"> Excellent</label>
          <label><input type="radio" name="q5" value="b"> Very Good</label>
          <label><input type="radio" name="q5" value="c"> Good</label>
          <label><input type="radio" name="q5" value="d"> Average</label>
          <label><input type="radio" name="q5" value="e"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q6. Comes regularly to the classes:</p><br>
        <div class="options">
          <label><input type="radio" name="q6" value="a"> Excellent</label>
          <label><input type="radio" name="q6" value="b"> Very Good</label>
          <label><input type="radio" name="q6" value="c"> Good</label>
          <label><input type="radio" name="q6" value="d"> Average</label>
          <label><input type="radio" name="q6" value="e"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q7. Shows interest in clearing student doubts:</p><br>
        <div class="options">
          <label><input type="radio" name="q7" value="a"> Excellent</label>
          <label><input type="radio" name="q7" value="b"> Very Good</label>
          <label><input type="radio" name="q7" value="c"> Good</label>
          <label><input type="radio" name="q7" value="d"> Average</label>
          <label><input type="radio" name="q7" value="e"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q8. Uses audio video when needed:</p><br>
        <div class="options">
          <label><input type="radio" name="q8" value="a"> Excellent</label>
          <label><input type="radio" name="q8" value="b"> Very Good</label>
          <label><input type="radio" name="q8" value="c"> Good</label>
          <label><input type="radio" name="q8" value="d"> Average</label>
          <label><input type="radio" name="q8" value="e"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q9. Conducts assignments/tutorials regularly:</p><br>
        <div class="options">
          <label><input type="radio" name="q9" value="a"> Excellent</label>
          <label><input type="radio" name="q9" value="b"> Very Good</label>
          <label><input type="radio" name="q9" value="c"> Good</label>
          <label><input type="radio" name="q9" value="d"> Average</label>
          <label><input type="radio" name="q9" value="e"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q10. Returns the valued test papers/records in time:</p><br>
        <div class="options">
          <label><input type="radio" name="q10" value="a"> Excellent</label>
          <label><input type="radio" name="q10" value="b"> Very Good</label>
          <label><input type="radio" name="q10" value="c"> Good</label>
          <label><input type="radio" name="q10" value="d"> Average</label>
          <label><input type="radio" name="q10" value="e"> Bad</label>
        </div>
        <div class="question">
        <p class="question-text">Q11. Encourages the originality and creativity :</p><br>
        <div class="options">
          <label><input type="radio" name="q11" value="a"> Excellent</label>
          <label><input type="radio" name="q11" value="b"> Very Good</label>
          <label><input type="radio" name="q11" value="c"> Good</label>
          <label><input type="radio" name="q11" value="d"> Average</label>
          <label><input type="radio" name="q11" value="e"> Bad</label>
        </div>
        <p class="question-text">Q12. Maintains students descipline:</p><br>
        <div class="options">
          <label><input type="radio" name="q12" value="a"> Excellent</label>
          <label><input type="radio" name="q12" value="b"> Very Good</label>
          <label><input type="radio" name="q12" value="c"> Good</label>
          <label><input type="radio" name="q12" value="d"> Average</label>
          <label><input type="radio" name="q12" value="e"> Bad</label>
        </div>
        <p class="question-text">Q13. Communication Skills:</p><br>
        <div class="options">
          <label><input type="radio" name="q13" value="a"> Excellent</label>
          <label><input type="radio" name="q13" value="b"> Very Good</label>
          <label><input type="radio" name="q13" value="c"> Good</label>
          <label><input type="radio" name="q13" value="d"> Average</label>
          <label><input type="radio" name="q13" value="e"> Bad</label>
        </div>
        <p class="question-text">Q14. Comes unprepared for the class:</p><br>
        <div class="options">
          <label><input type="radio" name="q14" value="a"> Never</label>
          <label><input type="radio" name="q14" value="b"> Occassionally</label>
          <label><input type="radio" name="q14" value="c"> Frequently</label>
          <label><input type="radio" name="q14" value="d"> Very Frequently</label>
          <label><input type="radio" name="q14" value="e"> Always</label>
        </div>
        <p class="question-text">Q15. Shows bias and discrimination among students:</p><br>
        <div class="options">
          <label><input type="radio" name="q15" value="a"> Never</label>
          <label><input type="radio" name="q15" value="b"> Occassionally</label>
          <label><input type="radio" name="q15" value="c"> Frequently</label>
          <label><input type="radio" name="q15" value="d"> Very Frequently</label>
          <label><input type="radio" name="q15" value="e"> Always</label>
        </div>


      </div>

                <button id="submitBtn" type="submit">Submit</button>
            </form>
        </div>
    </div>
</body>
</html>



 --%>

<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.feedback.FacultyInfo" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Feedback Form</title>

    <style>
        body {
            font-family: "Times New Roman", Times, serif;
            font-size: 20px;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f4f4f4;
        }

        .page-container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 25px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
            width: 100%;
            max-width: 800px;
            border-color: black;
        }

        .page-container1 {
            padding: 20px;
            border-radius: 25px;
            width: 100%;
            max-width: 1000px;
            border-color: black;
        }

        #header {
            text-align: center;
        }

        .header {
            text-align: center;
            margin-bottom: 30px;
        }

        .divider {
            height: 2px;
            background-color: #ccc;
            margin: 20px 0;
        }

        .question {
            margin-bottom: 10px;
        }

        .question-text {
            font-weight: bold;
            margin-bottom: 10px;
        }

        .options {
            display: flex;
        }

        label {
            margin-right: 10px;
        }

        .submit {
            background-color: #4CAF50; /* Green */
            border: none;
            color: black;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
        }
    </style>

</head>
<body>
<div>
    <div class="page-container1">
        <img src="logo.png">
    </div>

    <div class="page-container">
        <div class="header">
            <h2>STUDENT FEEDBACK ON FACULTY</h2>
        </div>

        <div class="divider"></div>

        <hr>

        <h4>Academic Year: <%= accYear %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Cycle: <%= cycle %></h4>
        <h4>Faculty Name: <span id="fname"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Faculty Id: <span id="fid1"></span></h4>
        <input type='hidden' value='$name' id='fid1' width="40px">
        <h5>Subject : <span id="sub"></span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>Section : <span id="sec"></span></h5>
        <hr>
        <div class="divider"></div>

        <form id="questionsForm">
          <div class="question">
        <p class="question-text">Q1. Student knowledge:</p><br>
        <div class="options">
          <label><input type="radio" name="q1" value="a"> Excellent</label>
          <label><input type="radio" name="q1" value="b"> Very Good</label>
          <label><input type="radio" name="q1" value="c"> Good</label>
          <label><input type="radio" name="q1" value="d"> Average</label>
          <label><input type="radio" name="q1" value="e"> Bad</label>
        </div>
      </div><br>
      <div class="question">
        <p class="question-text">Q2. Effectively utilizes Black Board:</p><br>
        <div class="options">
          <label><input type="radio" name="q2" value="a"> Excellent</label>
          <label><input type="radio" name="q2" value="b"> Very Good</label>
          <label><input type="radio" name="q2" value="c"> Good</label>
          <label><input type="radio" name="q2" value="d"> Average</label>
          <label><input type="radio" name="q2" value="e"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q3. Clear and audible voice:</p><br>
        <div class="options">
          <label><input type="radio" name="q3" value="a"> Excellent</label>
          <label><input type="radio" name="q3" value="b"> Very Good</label>
          <label><input type="radio" name="q3" value="c"> Good</label>
          <label><input type="radio" name="q3" value="d"> Average</label>
          <label><input type="radio" name="q3" value="e"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q4. Completes the syllabus in the stipulated time :</p><br>
        <div class="options">
          <label><input type="radio" name="q4" value="a"> Excellent</label>
          <label><input type="radio" name="q4" value="b"> Very Good</label>
          <label><input type="radio" name="q4" value="c"> Good</label>
          <label><input type="radio" name="q4" value="d"> Average</label>
          <label><input type="radio" name="q4" value="e"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q5. Provides information beyond the syllabus :</p><br>
        <div class="options">
          <label><input type="radio" name="q5" value="a"> Excellent</label>
          <label><input type="radio" name="q5" value="b"> Very Good</label>
          <label><input type="radio" name="q5" value="c"> Good</label>
          <label><input type="radio" name="q5" value="d"> Average</label>
          <label><input type="radio" name="q5" value="e"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q6. Comes regularly to the classes:</p><br>
        <div class="options">
          <label><input type="radio" name="q6" value="a"> Excellent</label>
          <label><input type="radio" name="q6" value="b"> Very Good</label>
          <label><input type="radio" name="q6" value="c"> Good</label>
          <label><input type="radio" name="q6" value="d"> Average</label>
          <label><input type="radio" name="q6" value="e"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q7. Shows interest in clearing student doubts:</p><br>
        <div class="options">
          <label><input type="radio" name="q7" value="a"> Excellent</label>
          <label><input type="radio" name="q7" value="b"> Very Good</label>
          <label><input type="radio" name="q7" value="c"> Good</label>
          <label><input type="radio" name="q7" value="d"> Average</label>
          <label><input type="radio" name="q7" value="e"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q8. Uses audio video when needed:</p><br>
        <div class="options">
          <label><input type="radio" name="q8" value="a"> Excellent</label>
          <label><input type="radio" name="q8" value="b"> Very Good</label>
          <label><input type="radio" name="q8" value="c"> Good</label>
          <label><input type="radio" name="q8" value="d"> Average</label>
          <label><input type="radio" name="q8" value="e"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q9. Conducts assignments/tutorials regularly:</p><br>
        <div class="options">
          <label><input type="radio" name="q9" value="a"> Excellent</label>
          <label><input type="radio" name="q9" value="b"> Very Good</label>
          <label><input type="radio" name="q9" value="c"> Good</label>
          <label><input type="radio" name="q9" value="d"> Average</label>
          <label><input type="radio" name="q9" value="e"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q10. Returns the valued test papers/records in time:</p><br>
        <div class="options">
          <label><input type="radio" name="q10" value="a"> Excellent</label>
          <label><input type="radio" name="q10" value="b"> Very Good</label>
          <label><input type="radio" name="q10" value="c"> Good</label>
          <label><input type="radio" name="q10" value="d"> Average</label>
          <label><input type="radio" name="q10" value="e"> Bad</label>
        </div>
        <div class="question">
        <p class="question-text">Q11. Encourages the originality and creativity :</p><br>
        <div class="options">
          <label><input type="radio" name="q11" value="a"> Excellent</label>
          <label><input type="radio" name="q11" value="b"> Very Good</label>
          <label><input type="radio" name="q11" value="c"> Good</label>
          <label><input type="radio" name="q11" value="d"> Average</label>
          <label><input type="radio" name="q11" value="e"> Bad</label>
        </div>
        <p class="question-text">Q12. Maintains students descipline:</p><br>
        <div class="options">
          <label><input type="radio" name="q12" value="a"> Excellent</label>
          <label><input type="radio" name="q12" value="b"> Very Good</label>
          <label><input type="radio" name="q12" value="c"> Good</label>
          <label><input type="radio" name="q12" value="d"> Average</label>
          <label><input type="radio" name="q12" value="e"> Bad</label>
        </div>
        <p class="question-text">Q13. Communication Skills:</p><br>
        <div class="options">
          <label><input type="radio" name="q13" value="a"> Excellent</label>
          <label><input type="radio" name="q13" value="b"> Very Good</label>
          <label><input type="radio" name="q13" value="c"> Good</label>
          <label><input type="radio" name="q13" value="d"> Average</label>
          <label><input type="radio" name="q13" value="e"> Bad</label>
        </div>
        <p class="question-text">Q14. Comes unprepared for the class:</p><br>
        <div class="options">
          <label><input type="radio" name="q14" value="a"> Never</label>
          <label><input type="radio" name="q14" value="b"> Occassionally</label>
          <label><input type="radio" name="q14" value="c"> Frequently</label>
          <label><input type="radio" name="q14" value="d"> Very Frequently</label>
          <label><input type="radio" name="q14" value="e"> Always</label>
        </div>
        <p class="question-text">Q15. Shows bias and discrimination among students:</p><br>
        <div class="options">
          <label><input type="radio" name="q15" value="a"> Never</label>
          <label><input type="radio" name="q15" value="b"> Occassionally</label>
          <label><input type="radio" name="q15" value="c"> Frequently</label>
          <label><input type="radio" name="q15" value="d"> Very Frequently</label>
          <label><input type="radio" name="q15" value="e"> Always</label>
        </div>


      </div>
            <button id="submitBtn" type="submit">Submit</button>
        </form>
    </div>
</div>
</body>
</html>

 --%>
 
 
 
  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.FacultyInfo" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%List<FacultyInfo> facultyInfoList = (List<FacultyInfo>) pageContext.getAttribute("facultyInfoList"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Feedback Form</title>

          <style>
        body {
            font-family: "Times New Roman", Times, serif;
            font-size: 20px;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f4f4f4;
        }

        .page-container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 25px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
            width: 100%;
            max-width: 800px;
            border-color: black;
        }

        .page-container1 {
            padding: 20px;
            border-radius: 25px;
            width: 100%;
            max-width: 1000px;
            border-color: black;
        }

        #header {
            text-align: center;
        }

        .header {
            text-align: center;
            margin-bottom: 30px;
        }

        .divider {
            height: 2px;
            background-color: #ccc;
            margin: 20px 0;
        }

        .question {
            margin-bottom: 10px;
        }

        .question-text {
            font-weight: bold;
            margin-bottom: 10px;
        }

        .options {
            display: flex;
        }

        label {
            margin-right: 10px;
        }

        .submit {
            background-color: #4CAF50; /* Green */
            border: none;
            color: black;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
        }
    
    </style>

    <script>
function updateFacultyInfo() {
    var facultyList = <%= facultyInfoList%>
    var currentIndex = parseInt(document.getElementById("currentIndex").value);
    var selectedFaculty = facultyList[currentIndex];

    // Update faculty details
    document.getElementById("fname").innerText = selectedFaculty.getFname();
    
    document.getElementById("fid1").value = selectedFaculty.getFid();
    document.getElementById("sub").innerText = selectedFaculty.getSub();
    document.getElementById("sec").innerText = selectedFaculty.sec;

    // Example: Update more elements dynamically
    // document.getElementById("anotherElement").innerText = selectedFaculty.getAnotherValue();

    // ... Update other elements as needed ...
}
</script>
    
</head>

<body>

<div>
    <div class="page-container1">
        <img src="logo.png">
    </div>

    <div class="page-container">
        <div class="header">
            <h2>STUDENT FEEDBACK ON FACULTY</h2>
        </div>

        <div class="divider"></div>

        <hr>

        <h4>Academic Year: <%= request.getAttribute("acc_year") %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Cycle: <%= request.getAttribute("cycle") %></h4>
        
       <h4>Faculty Name: <span id="fname"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Faculty Id: <span id="fid1"></span></h4>
<h5>Subject: <span id="sub"></span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>Section: <span id="sec"></span></h5>


        <div class="divider"></div>

        <form id="questionsForm" action="SubmitFeedbackServlet" method="post">
          <div class="question">
        <p class="question-text">Q1. Student knowledge:</p><br>
        <div class="options">
          <label><input type="radio" name="q1" value="5"> Excellent</label>
          <label><input type="radio" name="q1" value="4"> Very Good</label>
          <label><input type="radio" name="q1" value="3"> Good</label>
          <label><input type="radio" name="q1" value="2"> Average</label>
          <label><input type="radio" name="q1" value="1"> Bad</label>
        </div>
      </div><br>
      <div class="question">
        <p class="question-text">Q2. Effectively utilizes Black Board:</p><br>
        <div class="options">
          <label><input type="radio" name="q2" value="5"> Excellent</label>
          <label><input type="radio" name="q2" value="4"> Very Good</label>
          <label><input type="radio" name="q2" value="3"> Good</label>
          <label><input type="radio" name="q2" value="2"> Average</label>
          <label><input type="radio" name="q2" value="1"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q3. Clear and audible voice:</p><br>
        <div class="options">
          <label><input type="radio" name="q3" value="5"> Excellent</label>
          <label><input type="radio" name="q3" value="4"> Very Good</label>
          <label><input type="radio" name="q3" value="3"> Good</label>
          <label><input type="radio" name="q3" value="2"> Average</label>
          <label><input type="radio" name="q3" value="1"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q4. Completes the syllabus in the stipulated time :</p><br>
        <div class="options">
          <label><input type="radio" name="q4" value="5"> Excellent</label>
          <label><input type="radio" name="q4" value="4"> Very Good</label>
          <label><input type="radio" name="q4" value="3"> Good</label>
          <label><input type="radio" name="q4" value="2"> Average</label>
          <label><input type="radio" name="q4" value="1"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q5. Provides information beyond the syllabus :</p><br>
        <div class="options">
          <label><input type="radio" name="q5" value="5"> Excellent</label>
          <label><input type="radio" name="q5" value="4"> Very Good</label>
          <label><input type="radio" name="q5" value="3"> Good</label>
          <label><input type="radio" name="q5" value="2"> Average</label>
          <label><input type="radio" name="q5" value="1"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q6. Comes regularly to the classes:</p><br>
        <div class="options">
          <label><input type="radio" name="q6" value="5"> Excellent</label>
          <label><input type="radio" name="q6" value="4"> Very Good</label>
          <label><input type="radio" name="q6" value="3"> Good</label>
          <label><input type="radio" name="q6" value="2"> Average</label>
          <label><input type="radio" name="q6" value="1"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q7. Shows interest in clearing student doubts:</p><br>
        <div class="options">
          <label><input type="radio" name="q7" value="5"> Excellent</label>
          <label><input type="radio" name="q7" value="4"> Very Good</label>
          <label><input type="radio" name="q7" value="3"> Good</label>
          <label><input type="radio" name="q7" value="2"> Average</label>
          <label><input type="radio" name="q7" value="1"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q8. Uses audio video when needed:</p><br>
        <div class="options">
          <label><input type="radio" name="q8" value="5"> Excellent</label>
          <label><input type="radio" name="q8" value="4"> Very Good</label>
          <label><input type="radio" name="q8" value="3"> Good</label>
          <label><input type="radio" name="q8" value="2"> Average</label>
          <label><input type="radio" name="q8" value="1"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q9. Conducts assignments/tutorials regularly:</p><br>
        <div class="options">
          <label><input type="radio" name="q9" value="5"> Excellent</label>
          <label><input type="radio" name="q9" value="4"> Very Good</label>
          <label><input type="radio" name="q9" value="3"> Good</label>
          <label><input type="radio" name="q9" value="2"> Average</label>
          <label><input type="radio" name="q9" value="1"> Bad</label>
        </div><br>
      <div class="question">
        <p class="question-text">Q10. Returns the valued test papers/records in time:</p><br>
        <div class="options">
          <label><input type="radio" name="q10" value="5"> Excellent</label>
          <label><input type="radio" name="q10" value="4"> Very Good</label>
          <label><input type="radio" name="q10" value="3"> Good</label>
          <label><input type="radio" name="q10" value="2"> Average</label>
          <label><input type="radio" name="q10" value="1"> Bad</label>
        </div>
        <div class="question">
        <p class="question-text">Q11. Encourages the originality and creativity :</p><br>
        <div class="options">
          <label><input type="radio" name="q11" value="5"> Excellent</label>
          <label><input type="radio" name="q11" value="4"> Very Good</label>
          <label><input type="radio" name="q11" value="3"> Good</label>
          <label><input type="radio" name="q11" value="2"> Average</label>
          <label><input type="radio" name="q11" value="1"> Bad</label>
        </div>
        <p class="question-text">Q12. Maintains students descipline:</p><br>
        <div class="options">
          <label><input type="radio" name="q12" value="5"> Excellent</label>
          <label><input type="radio" name="q12" value="4"> Very Good</label>
          <label><input type="radio" name="q12" value="3"> Good</label>
          <label><input type="radio" name="q12" value="2"> Average</label>
          <label><input type="radio" name="q12" value="1"> Bad</label>
        </div>
        <p class="question-text">Q13. Communication Skills:</p><br>
        <div class="options">
          <label><input type="radio" name="q13" value="5"> Excellent</label>
          <label><input type="radio" name="q13" value="4"> Very Good</label>
          <label><input type="radio" name="q13" value="3"> Good</label>
          <label><input type="radio" name="q13" value="2"> Average</label>
          <label><input type="radio" name="q13" value="1"> Bad</label>
        </div>
        <p class="question-text">Q14. Comes unprepared for the class:</p><br>
        <div class="options">
          <label><input type="radio" name="q14" value="5"> Never</label>
          <label><input type="radio" name="q14" value="4"> Occassionally</label>
          <label><input type="radio" name="q14" value="3"> Frequently</label>
          <label><input type="radio" name="q14" value="2"> Very Frequently</label>
          <label><input type="radio" name="q14" value="1"> Always</label>
        </div>
        <p class="question-text">Q15. Shows bias and discrimination among students:</p><br>
        <div class="options">
          <label><input type="radio" name="q15" value="5"> Never</label>
          <label><input type="radio" name="q15" value="4"> Occassionally</label>
          <label><input type="radio" name="q15" value="3"> Frequently</label>
          <label><input type="radio" name="q15" value="2"> Very Frequently</label>
          <label><input type="radio" name="q15" value="1"> Always</label>
        </div>


      </div>
          <input type="hidden" name="fid1" value="<%= request.getParameter("fid1") %>">
          <input type="hidden" name="sec" value="<%= request.getParameter("sec") %>">
            <button id="submitBtn" type="submit">Submit</button>
            <input type="hidden" id="currentIndex" name="currentIndex" value="<%= request.getAttribute("currentIndex") %>">
        </form>
    </div>
</div>
</body>
</html>
 