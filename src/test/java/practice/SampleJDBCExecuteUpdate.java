package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException 
	{
		/* Step 1: Register the Driver */
		 Driver driver=new Driver();
		 DriverManager.registerDriver(driver);
		
		/* Step 2 :get connection with database - provide db name */
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");
		 
		/* Step 3 :issue create statement*/
		 Statement state = con.createStatement();
		 
		/* Step 4 :execute a query */
		 int result = state.executeUpdate("insert into eployeeinfo values (4,'Tharun','mangalore');");
		 
		 if(result==1)
		 {
			 System.out.println(data added );
		 }
		 
		/* Step 5 :close the connection */
		 
	}

}
