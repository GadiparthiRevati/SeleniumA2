package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Updatedatabase {
	public static void main(String[] args) throws SQLException {
		//stpe 1  : establish jdbc connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel_a2","root","root");
		//step2 : create statement
		Statement statement= connection.createStatement();
		//stpe 3: update query
		int result=statement.executeUpdate("insert into employee (ID,Name,phoneno,salary) values(105,'xyz','9542470171',15000);");
		System.out.println(result);
		
		//stpe 4 : close database
		connection.close();
		
	}
	

}
