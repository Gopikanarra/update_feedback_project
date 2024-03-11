

/*package com.project;*/

//import java.io.IOException;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/Feedback_Calculate")
//public class Feedback_Calculate extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    private static final String JDBC_URL = "jdbc:mysql:///feedback";
//    private static final String DB_USER = "root";
//    private static final String DB_PASSWORD = "gopikapassword";
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try (Connection connection = getConnection()) {
//            String academicYear = request.getParameter("acc_year");
//            String section = request.getParameter("section");
//            String branch = request.getParameter("branch");
//            String cycle = request.getParameter("cycle");
//            String year = request.getParameter("year");
//            String semester = request.getParameter("semester");
//            String ss = year + "_" + semester + "_" + branch + "_" + cycle + "_" + section;
//
//            String sql = "SELECT q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15 " +
//                    "FROM feedback_details " +
//                    "WHERE acc_year = ? AND sec = ?";
//
//            System.out.println("SQL Query: " + sql);
//
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                statement.setString(1, academicYear);
//                statement.setString(2, ss);
//
//                try (ResultSet resultSet = statement.executeQuery()) {
//                    double overallAverage = 0;
//                    int rowCount = 0;
//
//                    // Iterate over the result set
//                    while (resultSet.next()) {
//                        double rowAverage = calculateRowAverage(resultSet);
//                        overallAverage += rowAverage;
//                        rowCount++;
//                        // You can also process individual row averages here
//                        System.out.println("Row " + rowCount + " Average: " + rowAverage);
//                    }
//
//                    System.out.println("Total Rows: " + rowCount);
//
//                    if (rowCount > 0) {
//                        overallAverage /= rowCount;
//                    }
//
//                    // Send the HTML response back to the client
//                    response.setContentType("text/html");
//                    try (PrintWriter out = response.getWriter()) {
//                        out.println("<html><body>");
//                        out.println("<h2>Overall Average: " + overallAverage + "</h2>");
//                        out.println("</body></html>");
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // Handle the exception appropriately
//        }
//    }
//
//    private double calculateRowAverage(ResultSet resultSet) throws SQLException {
//        int questionCount = 15;
//        double rowSum = 0;
//
//        // Iterate over the columns q1, q2, ..., q15
//        for (int i = 1; i <= questionCount; i++) {
//            rowSum += resultSet.getInt("q" + i);
//        }
//
//        return rowSum / questionCount;
//    }
//
//    private Connection getConnection() throws SQLException {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
//        } catch (ClassNotFoundException e) {
//            throw new SQLException("JDBC driver not found", e);
//        }
//    }
//}
/*
 * package com.feedback;
 * 
 * import java.io.IOException; import java.io.PrintWriter; import
 * java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.PreparedStatement; import java.sql.ResultSet; import
 * java.sql.SQLException; import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * @WebServlet("/Feedback_Calculate") public class Feedback_Calculate extends
 * HttpServlet { private static final long serialVersionUID = 1L;
 * 
 * private static final String JDBC_URL = "jdbc:mysql:///feedback"; private
 * static final String DB_USER = "root"; private static final String DB_PASSWORD
 * = "gopikapassword";
 * 
 * public void doGet(HttpServletRequest request, HttpServletResponse response)
 * throws ServletException, IOException { try (Connection connection =
 * getConnection()) { String academicYear = request.getParameter("acc_year");
 * String section = request.getParameter("section"); String branch =
 * request.getParameter("branch"); String cycle = request.getParameter("cycle");
 * String year = request.getParameter("year"); String semester =
 * request.getParameter("semester"); String ss = year + "_" + semester + "_" +
 * branch + "_" + cycle + "_" + section;
 * 
 * String sql =
 * "SELECT q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15 " +
 * "FROM feedback_details " + "WHERE acc_year = ? AND sec = ?";
 * 
 * System.out.println("SQL Query: " + sql);
 * 
 * try (PreparedStatement statement = connection.prepareStatement(sql)) {
 * statement.setString(1, academicYear); statement.setString(2, ss);
 * 
 * try (ResultSet resultSet = statement.executeQuery()) { double overallAverage
 * = 0; int rowCount = 0;
 * 
 * // Arrays to store data for chart.js StringBuilder labels = new
 * StringBuilder("["); StringBuilder data = new StringBuilder("[");
 * 
 * // Iterate over the result set while (resultSet.next()) { double rowAverage =
 * calculateRowAverage(resultSet); overallAverage += rowAverage; rowCount++;
 * 
 * // Add data for chart.js if (rowCount > 1) { labels.append(", ");
 * data.append(", "); } labels.append("\"Row ").append(rowCount).append("\"");
 * data.append(rowAverage); }
 * 
 * labels.append("]"); data.append("]");
 * 
 * System.out.println("Total Rows: " + rowCount);
 * 
 * if (rowCount > 0) { overallAverage /= rowCount; }
 * 
 * // Send the HTML response back to the client
 * response.setContentType("text/html"); try (PrintWriter out =
 * response.getWriter()) { out.println("<html><head>");
 * out.println("<script src='https://cdn.jsdelivr.net/npm/chart.js'></script>");
 * out.println("</head><body>"); out.println("<h2>Overall Average: " +
 * overallAverage + "</h2>");
 * 
 * // Add a canvas for the pie chart
 * out.println("<canvas id='myPieChart' width='400' height='400'></canvas>");
 * 
 * // Add JavaScript to create the pie chart out.println("<script>"); out.
 * println("var ctx = document.getElementById('myPieChart').getContext('2d');");
 * out.println("var myPieChart = new Chart(ctx, {");
 * out.println("type: 'pie',"); out.println("data: {"); out.println("labels: " +
 * labels + ","); out.println("datasets: [{"); out.println("data: " + data +
 * ","); out.println("backgroundColor: ["); // Define colors for each data point
 * out.
 * println("'rgba(255, 99, 132, 0.7)', 'rgba(54, 162, 235, 0.7)', 'rgba(255, 206, 86, 0.7)', 'rgba(75, 192, 192, 0.7)'"
 * ); out.println("],"); out.println("borderWidth: 1"); out.println("}]");
 * out.println("},"); out.println("options: { responsive: false }");
 * out.println("});"); out.println("</script>");
 * 
 * out.println("</body></html>"); } } } } catch (SQLException e) {
 * e.printStackTrace(); // Handle the exception appropriately } }
 * 
 * private double calculateRowAverage(ResultSet resultSet) throws SQLException {
 * int questionCount = 15; double rowSum = 0;
 * 
 * // Iterate over the columns q1, q2, ..., q15 for (int i = 1; i <=
 * questionCount; i++) { rowSum += resultSet.getInt("q" + i); }
 * 
 * return rowSum / questionCount; }
 * 
 * private Connection getConnection() throws SQLException { try {
 * Class.forName("com.mysql.cj.jdbc.Driver"); return
 * DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD); } catch
 * (ClassNotFoundException e) { throw new SQLException("JDBC driver not found",
 * e); } } }
 */

/*
 * package com.feedback;
 * 
 * import java.io.IOException; import java.io.PrintWriter; import
 * java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.PreparedStatement; import java.sql.ResultSet; import
 * java.sql.SQLException;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * @WebServlet("/Feedback_Calculate") public class Feedback_Calculate extends
 * HttpServlet { private static final long serialVersionUID = 1L;
 * 
 * private static final String JDBC_URL = "jdbc:mysql:///feedback"; private
 * static final String DB_USER = "root"; private static final String DB_PASSWORD
 * = "gopikapassword";
 * 
 * public void doGet(HttpServletRequest request, HttpServletResponse response)
 * throws ServletException, IOException { try (Connection connection =
 * getConnection()) {
 * 
 * String academicYear = request.getParameter("acc_year"); String section =
 * request.getParameter("section"); String branch =
 * request.getParameter("branch"); String cycle = request.getParameter("cycle");
 * String year = request.getParameter("year"); String semester =
 * request.getParameter("semester"); String ss = year + "_" + semester + "_" +
 * branch + "_" + cycle + "_" + section;
 * 
 * String sql =
 * "SELECT AVG((q1 + q2 + q3 + q4 + q5 + q6 + q7 + q8 + q9 + q10 + q11 + q12 + q13 + q14 + q15) / 15) AS overall_average "
 * + "FROM feedback_details " + "WHERE acc_year = ? AND sec = ?";
 * 
 * System.out.println("SQL Query: " + sql);
 * 
 * try (PreparedStatement statement = connection.prepareStatement(sql)) {
 * statement.setString(1, academicYear); statement.setString(2, ss);
 * 
 * try (ResultSet resultSet = statement.executeQuery()) { double overallAverage
 * = 0; int rowCount = 0;
 * 
 * // Iterate over the result set and calculate the overall average while
 * (resultSet.next()) { overallAverage = resultSet.getDouble("overall_average");
 * rowCount++; }
 * 
 * // Calculate the overall percentage (assuming a 5-point scale) double
 * overallPercentage = overallAverage * 20;
 * 
 * // Send the HTML response back to the client
 * response.setContentType("text/html"); try (PrintWriter out =
 * response.getWriter()) { out.println("<html><body>");
 * out.println("<h2>Overall Average: " + overallAverage + "</h2>");
 * out.println("<h2>Overall Percentage: " + overallPercentage + "%</h2>");
 * 
 * // Include Chart.js library and generate pie chart
 * out.println("<script src='https://cdn.jsdelivr.net/npm/chart.js'></script>");
 * out.println("<canvas id='myPieChart' width='200' height='200'></canvas>");
 * out.println("<script>"); out.
 * println("var ctx = document.getElementById('myPieChart').getContext('2d');");
 * out.println("var myPieChart = new Chart(ctx, {");
 * out.println("type: 'pie',"); out.println("data: {");
 * out.println("labels: ['Excellent', 'Good's, 'Average', 'Poor'],");
 * out.println("datasets: [{"); out.println("data: [" + overallPercentage +
 * ", 100 - " + overallPercentage + "],"); out.println("backgroundColor: [");
 * out.println("'green', 'lightgray'"); out.println("]"); out.println("}]");
 * out.println("},"); out.println("options: {");
 * out.println("legend: { display: true, position: 'right' },");
 * out.println("title: { display: true, text: 'Overall Feedback Percentage' }");
 * out.println("}"); out.println("});"); out.println("</script>");
 * 
 * out.println("</body></html>"); } } } } catch (SQLException e) {
 * e.printStackTrace(); // Handle the exception appropriately } }
 * 
 * private Connection getConnection() throws SQLException { try {
 * Class.forName("com.mysql.cj.jdbc.Driver"); return
 * DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD); } catch
 * (ClassNotFoundException e) { throw new SQLException("JDBC driver not found",
 * e); } } }
 */


/*
 * package com.feedback;
 * 
 * import java.io.IOException; import java.io.PrintWriter; import
 * java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.PreparedStatement; import java.sql.ResultSet; import
 * java.sql.SQLException;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * @WebServlet("/Feedback_Calculate") public class Feedback_Calculate extends
 * HttpServlet { private static final long serialVersionUID = 1L;
 * 
 * private static final String JDBC_URL = "jdbc:mysql:///feedback"; private
 * static final String DB_USER = "root"; private static final String DB_PASSWORD
 * = "gopikapassword";
 * 
 * public void doGet(HttpServletRequest request, HttpServletResponse response)
 * throws ServletException, IOException { try (Connection connection =
 * getConnection()) { String academicYear = request.getParameter("acc_year");
 * String section = request.getParameter("section"); String branch =
 * request.getParameter("branch"); String cycle = request.getParameter("cycle");
 * String year = request.getParameter("year"); String semester =
 * request.getParameter("semester"); String ss = year + "_" + semester + "_" +
 * branch + "_" + cycle + "_" + section;
 * 
 * String sql =
 * "SELECT AVG((q1 + q2 + q3 + q4 + q5 + q6 + q7 + q8 + q9 + q10 + q11 + q12 + q13 + q14 + q15) / 15) AS overall_average "
 * + "FROM feedback_details " + "WHERE acc_year = ? AND sec = ?";
 * 
 * System.out.println("SQL Query: " + sql);
 * 
 * try (PreparedStatement statement = connection.prepareStatement(sql)) {
 * statement.setString(1, academicYear); statement.setString(2, ss);
 * 
 * try (ResultSet resultSet = statement.executeQuery()) { double overallAverage
 * = 0; int rowCount = 0;
 * 
 * // Iterate over the result set and calculate the overall average while
 * (resultSet.next()) { overallAverage = resultSet.getDouble("overall_average");
 * rowCount++; }
 * 
 * // Calculate the overall percentage (assuming a 5-point scale) double
 * overallPercentage = overallAverage * 20;
 * 
 * // Send the HTML response back to the client
 * response.setContentType("text/html"); try (PrintWriter out =
 * response.getWriter()) { out.println("<html><head>");
 * out.println("<script src='https://cdn.jsdelivr.net/npm/chart.js'></script>");
 * out.println("</head><body>"); out.println("<h2>Overall Average: " +
 * overallAverage + "</h2>"); out.println("<h2>Overall Percentage: " +
 * overallPercentage + "%</h2>");
 * 
 * // Add a canvas for the pie chart
 * out.println("<canvas id='myPieChart' width='400' height='400'></canvas>");
 * 
 * // Add JavaScript to create the pie chart out.println("<script>"); out.
 * println("var ctx = document.getElementById('myPieChart').getContext('2d');");
 * out.println("var myPieChart = new Chart(ctx, {");
 * out.println("type: 'pie',"); out.println("data: {");
 * out.println("labels: ['Excellent', 'Remaining'],");
 * out.println("datasets: [{"); out.println("data: [" + overallPercentage + ", "
 * + (100 - overallPercentage) + "],"); out.println("backgroundColor: [");
 * out.println("'green', 'lightgray'"); out.println("]"); out.println("}]");
 * out.println("},"); out.println("options: { responsive: false }");
 * out.println("});"); out.println("</script>");
 * 
 * out.println("</body></html>"); } } } } catch (SQLException e) {
 * e.printStackTrace(); // Handle the exception appropriately } }
 * 
 * private Connection getConnection() throws SQLException { try {
 * Class.forName("com.mysql.cj.jdbc.Driver"); return
 * DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD); } catch
 * (ClassNotFoundException e) { throw new SQLException("JDBC driver not found",
 * e); } } }
 */











/*
 * package com.feedback; // Import JFreeChart classes import java.io.File;
 * import java.io.IOException; import java.io.PrintWriter; import
 * java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.PreparedStatement; import java.sql.ResultSet; import
 * java.sql.SQLException;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.jfree.chart.ChartFactory; import org.jfree.chart.ChartUtilities;
 * import org.jfree.chart.JFreeChart; import
 * org.jfree.data.general.DefaultPieDataset;
 * 
 * // ... (other import statements)
 * 
 * @WebServlet("/Feedback_Calculate") public class Feedback_Calculate extends
 * HttpServlet { private static final long serialVersionUID = 1L;
 * 
 * private static final String JDBC_URL = "jdbc:mysql:///feedback"; private
 * static final String DB_USER = "root"; private static final String DB_PASSWORD
 * = "gopikapassword";
 * 
 * public void doGet(HttpServletRequest request, HttpServletResponse response)
 * throws ServletException, IOException { try (Connection connection =
 * getConnection()) {
 * 
 * String academicYear = request.getParameter("acc_year"); String section =
 * request.getParameter("section"); String branch =
 * request.getParameter("branch"); String cycle = request.getParameter("cycle");
 * String year = request.getParameter("year"); String semester =
 * request.getParameter("semester"); String ss = year + "_" + semester + "_" +
 * branch + "_" + cycle + "_" + section;
 * 
 * String sql =
 * "SELECT AVG((q1 + q2 + q3 + q4 + q5 + q6 + q7 + q8 + q9 + q10 + q11 + q12 + q13 + q14 + q15) / 15) AS overall_average "
 * + "FROM feedback_details " + "WHERE acc_year = ? AND sec = ?";
 * 
 * System.out.println("SQL Query: " + sql);
 * 
 * try (PreparedStatement statement = connection.prepareStatement(sql)) {
 * statement.setString(1, academicYear); statement.setString(2, ss);
 * 
 * try (ResultSet resultSet = statement.executeQuery()) { double overallAverage
 * = 0; int rowCount = 0;
 * 
 * // Iterate over the result set and calculate the overall average while
 * (resultSet.next()) { overallAverage = resultSet.getDouble("overall_average");
 * rowCount++; }
 * 
 * // Calculate the overall percentage (assuming a 5-point scale) double
 * overallPercentage = overallAverage * 20;
 * 
 * // Create a dataset for the pie chart DefaultPieDataset dataset = new
 * DefaultPieDataset(); dataset.setValue("Excellent", overallPercentage);
 * dataset.setValue("Remaining", 100 - overallPercentage);
 * 
 * // Create a pie chart JFreeChart chart = ChartFactory.createPieChart(
 * "Overall Feedback Percentage", dataset, true, true, false );
 * 
 * // Save the chart as an image file (adjust the file path)
 * ChartUtilities.saveChartAsJPEG(new File("D://chart.jpg"), chart, 400, 400);
 * 
 * // Send the HTML response back to the client
 * response.setContentType("text/html"); try (PrintWriter out =
 * response.getWriter()) { out.println("<html><body>");
 * out.println("<h2>Overall Average: " + overallAverage + "</h2>");
 * out.println("<h2>Overall Percentage: " + overallPercentage + "%</h2>");
 * 
 * // Add an image tag to display the pie chart out.
 * println("<img src='D://chart.jpg' alt='Overall Feedback Percentage Chart'>");
 * 
 * out.println("</body></html>"); } } } } catch (SQLException e) {
 * e.printStackTrace(); // Handle the exception appropriately } }
 * 
 * private Connection getConnection() throws SQLException { try {
 * Class.forName("com.mysql.cj.jdbc.Driver"); return
 * DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD); } catch
 * (ClassNotFoundException e) { throw new SQLException("JDBC driver not found",
 * e); } } }
 */









/*
 * package com.project;
 * 
 * import java.io.IOException; import java.io.PrintWriter; import
 * java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.PreparedStatement; import java.sql.ResultSet; import
 * java.sql.SQLException;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * @WebServlet("/Feedback_Calculate") public class Feedback_Calculate extends
 * HttpServlet { private static final long serialVersionUID = 1L;
 * 
 * private static final String JDBC_URL = "jdbc:mysql:///feedback"; private
 * static final String DB_USER = "root"; private static final String DB_PASSWORD
 * = "gopikapassword";
 * 
 * public void doGet(HttpServletRequest request, HttpServletResponse response)
 * throws ServletException, IOException { try (Connection connection =
 * getConnection()) { String academicYear = request.getParameter("acc_year");
 * String section = request.getParameter("section"); String branch =
 * request.getParameter("branch"); String cycle = request.getParameter("cycle");
 * String year = request.getParameter("year"); String semester =
 * request.getParameter("semester"); String ss = year + "_" + semester + "_" +
 * branch + "_" + cycle + "_" + section;
 * 
 * String sql =
 * "SELECT AVG((q1 + q2 + q3 + q4 + q5 + q6 + q7 + q8 + q9 + q10 + q11 + q12 + q13 + q14 + q15) / 15) AS overall_average "
 * + "FROM feedback_details " + "WHERE acc_year = ? AND sec = ?";
 * 
 * System.out.println("SQL Query: " + sql);
 * 
 * try (PreparedStatement statement = connection.prepareStatement(sql)) {
 * statement.setString(1, academicYear); statement.setString(2, ss);
 * 
 * try (ResultSet resultSet = statement.executeQuery()) { double overallAverage
 * = 0; int rowCount = 0;
 * 
 * // Iterate over the result set and calculate the overall average while
 * (resultSet.next()) { overallAverage = resultSet.getDouble("overall_average");
 * rowCount++; }
 * 
 * // Calculate the overall percentage (assuming a 5-point scale) double
 * overallPercentage = overallAverage * 20;
 * 
 * // Send the HTML response back to the client
 * response.setContentType("text/html"); try (PrintWriter out =
 * response.getWriter()) { out.println("<html><head>");
 * out.println("<script src='https://cdn.jsdelivr.net/npm/chart.js'></script>");
 * out.println("</head><body>"); out.println("<h2>Overall Average: " +
 * overallAverage + "</h2>"); out.println("<h2>Overall Percentage: " +
 * overallPercentage + "%</h2>");
 * 
 * // Add a canvas for the pie chart
 * out.println("<canvas id='myPieChart' width='400' height='400'></canvas>");
 * 
 * // Add JavaScript to create the pie chart out.println("<script>"); out.
 * println("var ctx = document.getElementById('myPieChart').getContext('2d');");
 * out.println("var myPieChart = new Chart(ctx, {");
 * out.println("type: 'pie',"); out.println("data: {");
 * out.println("labels: ['Excellent', 'Remaining'],");
 * out.println("datasets: [{"); out.println("data: [" + overallPercentage + ", "
 * + (100 - overallPercentage) + "],"); out.println("backgroundColor: [");
 * out.println("'green', 'lightgray'"); out.println("]"); out.println("}]");
 * out.println("},"); out.println("options: { responsive: false }");
 * out.println("});"); out.println("</script>");
 * 
 * out.println("</body></html>"); } } } } catch (SQLException e) {
 * e.printStackTrace(); // Handle the exception appropriately } }
 * 
 * private Connection getConnection() throws SQLException { try {
 * Class.forName("com.mysql.cj.jdbc.Driver"); return
 * DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD); } catch
 * (ClassNotFoundException e) { throw new SQLException("JDBC driver not found",
 * e); } } }
 */





package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Feedback_Calculate")
public class Feedback_Calculate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String JDBC_URL = "jdbc:mysql:///feedback";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "gopikapassword";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection connection = getConnection()) {

            String academicYear = request.getParameter("acc_year");
            String section = request.getParameter("section");
            String branch = request.getParameter("branch");
            String cycle = request.getParameter("cycle");
            String year = request.getParameter("year");
            String semester = request.getParameter("semester");
            String ss = year + "" + semester + "" + branch + "" + cycle + "" + section;

            String sql = "SELECT AVG((q1 + q2 + q3 + q4 + q5 + q6 + q7 + q8 + q9 + q10 + q11 + q12 + q13 + q14 + q15) / 15) AS overall_average "
                    + "FROM feedback_details " + "WHERE acc_year = ? AND sec = ?";

            System.out.println("SQL Query: " + sql);

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, academicYear);
                statement.setString(2, ss);

                try (ResultSet resultSet = statement.executeQuery()) {
                    double overallAverage = 0;
                    int rowCount = 0;

                    // Iterate over the result set and calculate the overall average
//                    while (resultSet.next()) {
//                        overallAverage = resultSet.getDouble("overall_average");
//                        rowCount++;
//                    }
//
//                    // Calculate the overall percentage (assuming a 5-point scale)
//                    double overallPercentage = overallAverage * 20;
                    double overallAverage1 = 0;
                    int maxScorePerQuestion = 5;

                    // Iterate over the result set and calculate the overall average
                    while (resultSet.next()) {
                        overallAverage1 = resultSet.getDouble("overall_average");
                        rowCount++;
                    }

                    // Calculate the overall percentage (assuming a 5-point scale)
                    double overallPercentage = (overallAverage1 / maxScorePerQuestion) * 100;

                    // Send the HTML response back to the client
                    response.setContentType("text/html");
                    try (PrintWriter out = response.getWriter()) {
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Feedback Analysis</title>");
                        out.println("</head>");
                        out.println("<body style='font-family: Arial, sans-serif; background-color: #f0f0f0; margin: 0; padding: 0; display: flex; align-items: center; justify-content: center; min-height: 100vh;'>");
                        out.println("<form style='border: 1px solid black; margin: 20px; padding: 20px; border-style: solid; background-color: lightblue; max-width: 800px;'>");
                        out.println("<h1 style='text-align: center; border-style: outset; color: #007bff;'>Feedback Analysis</h1>");
                        out.println("<h2 style='font-size: 40px; color: red; text-align: center;'>Feedback On Faculty</h2>");
                        out.println("<h3 style='font-size: 20px; background-color: skyblue; border-style: inset; padding: 10px; margin: 10px 0;'>Overall Average: " + overallAverage1 + "</h3>");
                        out.println("<h3 style='font-size: 20px; background-color: skyblue; border-style: inset; padding: 10px; margin: 10px 0;'>Overall Percentage: " + overallPercentage + "%</h3>");
                        // Include Chart.js library and generate pie chart
                        out.println("<script src='https://cdn.jsdelivr.net/npm/chart.js'></script>");
                        out.println("<canvas id='myPieChart' width='200' height='200'></canvas>");
                        out.println("<script>");
                        out.println("var ctx = document.getElementById('myPieChart').getContext('2d');");
                        out.println("var myPieChart = new Chart(ctx, {");
                        out.println("type: 'pie',");
                        out.println("data: {");
                        out.println("labels: ['Excellent', 'Good', 'Average', 'Poor'],");
                        out.println("datasets: [{");
                        out.println("data: [" + overallPercentage + ", 100 - " + overallPercentage + "],");
                        out.println("backgroundColor: [");
                        out.println("'green', 'lightgray'");
                        out.println("]");
                        out.println("}]");
                        out.println("},");
                        out.println("options: {");
                        out.println("legend: { display: true, position: 'right' },");
                        out.println("title: { display: true, text: 'Overall Feedback Percentage' }");
                        out.println("}");
                        out.println("});");
                        out.println("</script>");
                        out.println("</form>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC driver not found", e);
        }
    }
}
