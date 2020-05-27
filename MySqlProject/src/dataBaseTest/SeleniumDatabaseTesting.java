package dataBaseTest;

import java.sql.*;


public class SeleniumDatabaseTesting
{
	public static void main(String[] args)
	{
		Connection conn=null;
		
		String url="jdbc:mysql://10.0.2.2:3306/MY_DB";
		String databaseName="mydatabase";
		String username="root";
		String password="root";
		 
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url+databaseName, username, password);
			String sqlQuerry = "Select * from signupdetails ORDER BY signupid DESC LIMIT1";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sqlQuerry);
			result.next();
			System.out.println(result.getString("emailaddress"));
			System.out.println(result.getString("zipcode"));
			System.out.println(result.getString("firstname"));
			System.out.println(result.getString("lastname"));
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally 
		{
			if (conn!=null)
			{
				conn=null;
			}
		}
	}
}
