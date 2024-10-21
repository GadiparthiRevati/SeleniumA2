package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/* this class contains reusable methods to read or write to database
 * @author revati
 */


public class DataBaseUtility {
	Connection connection;
	Statement statement;
	/* this method initializes database connection
	 * @param jdbcurl
	 * @oarma username
	 * @param password
	 */
	public void databaseInIt(String jdbcUrl, String username, String password) {
		try {
			connection=DriverManager.getConnection(jdbcUrl, username, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			statement=connection.createStatement();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	public List<Object> readFromDataBase(String query, String columnName) {
		ResultSet result = null;
				List<Object> list=new ArrayList<Object>();
				try {
					result=statement.executeQuery(query);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				try {
					while(result.next()) {
						
							list.add(result.getObject(columnName));
					}
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
					
				
				return list;
	}
	/*
	 * this method modifies the database
	 * @param query
	 * @parm int
	 */
	public int modifyDatabase(String query) {
		int result = 0;
		try {
			result = statement.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
		
	}
	/*
	 * this method closes database connection
	 */
	
	public void closeDatabase() {
		try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
				
				
	
	

}
