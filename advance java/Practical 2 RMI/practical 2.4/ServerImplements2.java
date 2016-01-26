import java.rmi.*;
import java.rmi.server.*;
import java.lang.String;
import java.sql.*;
import java.util.*;

public class ServerImplements2 extends UnicastRemoteObject implements RemoteInterface2 {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://127.0.0.1:5433/postgres";
	
	//  Database credentials
	static final String USER = "postgres";
	static final String PASS = "12345";
	
	public ServerImplements2()throws Exception {
	    super();
	}
	
	public ArrayList<Student> selectFromDB() {
		
		ArrayList<Student> data = new ArrayList<Student>();
	    //Student is another class;
		
		Connection conn = null;
		Statement stmt = null;
		
		//String[] data = new String[2];
		
		try{
			//STEP 2: Register JDBC driver
		    Class.forName(JDBC_DRIVER);
		    
		    //STEP 3: Open a connection
		    System.out.println("Connecting to selected database...");
		    conn = DriverManager.getConnection(DB_URL, USER, PASS);
		    System.out.println("Connected database successfully...");

		    //STEP 4: Execute a query
		    System.out.println("Fetching data from Table 'studentinfo' of Database 'postgres'...");
		    stmt = conn.createStatement();

		    String sql = "SELECT enrollno, name FROM studentinfo";
		    
		    ResultSet rs = stmt.executeQuery(sql);
		    System.out.println("Data Inserted successfully...");
		    
		    
		    
		    
		    while(rs.next()){
		    	String enrollno = rs.getString("enrollno");
		    	String name = rs.getString("name");
		    	Student student = new Student();
		    	student.setEnrollno(enrollno);
		    	student.setName(name);
		    	//data[0] = enrollno;
		    	//data[1] = name;
		    	data.add(student);
		    	
		    }
		    
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
		return data;
	}
}