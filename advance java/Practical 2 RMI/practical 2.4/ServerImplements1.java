import java.rmi.*;
import java.rmi.server.*;
import java.lang.String;
import java.sql.*;


public class ServerImplements1 extends UnicastRemoteObject implements RemoteInterface1 {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://127.0.0.1:5433/postgres";
	
	//  Database credentials
	static final String USER = "postgres";
	static final String PASS = "12345";
	
	public ServerImplements1()throws Exception {
	    super();
	}
	
	public boolean insertInDB(String enroll, String name) {
		Connection conn = null;
		Statement stmt = null;
	    System.out.println(enroll + name);		
		try{
			//STEP 2: Register JDBC driver
		    Class.forName(JDBC_DRIVER);
		    
		    //STEP 3: Open a connection
		    System.out.println("Connecting to selected database...");
		    conn = DriverManager.getConnection(DB_URL, USER, PASS);
		    System.out.println("Connected database successfully...");

		    //STEP 4: Execute a query
		    System.out.println("Inserting data in Table 'studentinfo' of Database 'postgres'...");
		    stmt = conn.createStatement();

		    String sql = "INSERT INTO studentinfo(enrollno, name) VALUES ('"+enroll+"', '"+name+"')";
		    
		    stmt.executeUpdate(sql);
		    System.out.println("Data Inserted successfully...");
		} catch(SQLException se) {
		      //Handle errors for JDBC
		      se.printStackTrace();
		} catch(Exception e)	{
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}finally{
		      //finally block used to close resources
		      try{
		    	  if(stmt!=null)
		    		  stmt.close();
		      } catch(SQLException se2) {
		      
		      }// nothing we can do
		      
		      try{
		    	  if(conn!=null)
		    		  conn.close();
		      } catch(SQLException se) {
		    	  se.printStackTrace();
		      
		      }//end finally try
		}//end try
		
		System.out.println("Goodbye!");
		return true;
	}
}