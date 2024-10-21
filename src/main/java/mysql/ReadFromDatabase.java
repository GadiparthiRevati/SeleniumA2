package mysql;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadFromDatabase {
	public static void main(String[] args) throws SQLException {
		//step 1 : create instance for database driver
		Driver dbDriver=new Driver();
		
		//step2 : register driver to JDBC connection
		DriverManager.registerDriver(dbDriver);
		
		//step 3 : establish JDBC connection 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel_a2","root","root");
		
		//step 4 : create statement
		Statement statement = connection.createStatement();
		
		//step 5: execute query
		ResultSet result = statement.executeQuery("select* from employee;");
		
		while(result.next()) {
			System.out.println(result.getInt("ID")+ "\t" + result.getString("Name")+ "\t" +result.getString("phoneno") + "\t" + result.getInt("salary"));
			
		}
			//step 6 : close database connection
			connection.close();
			
		
		
	}

}
