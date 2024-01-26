package com.feedback;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    // Database connection parameters
    private static final String JDBC_URL = "jdbc:mysql:///feedback";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "gopikapassword";

    // JDBC driver and connection
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static Connection conn = null;
    private static PreparedStatement preparedstatement=null;
    private static ResultSet resultSet=null;
    
public static Connection getConnection(Connection conn) throws SQLException   {
try {
	Class.forName(JDBC_DRIVER);
	conn=DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
	return conn;
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
return null ;
}

public static void closeConnection(Connection conn,PreparedStatement pstmt,ResultSet rs) throws SQLException   {
	try {
		if(conn!=null) {
		conn.close();
		}
		if(pstmt!=null) {
		pstmt.close();
		}
		if(rs!=null) {
		rs.close();
		}
	} catch (Exception e) {
	e.printStackTrace();
   }

}



}
