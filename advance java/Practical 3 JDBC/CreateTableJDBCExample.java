//STEP 1. Import required packages
import java.sql.*;

public class CreateTableJDBCExample {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.postgresql.Driver";
   static final String DB_URL = "jdbc:postgresql://127.0.0.1:5433/postgres";

   //  Database credentials
   static final String USER = "postgres";
   static final String PASS = "12345";

   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");

      //STEP 4: Execute a query
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();

 //     String sql = "CREATE TABLE RemoteREGISTRATION " +
 //                  "(id INTEGER not NULL, " +
  //                 " first VARCHAR(255), " +
   //                " last VARCHAR(255), " +
    //               " age INTEGER, " +
     //              " PRIMARY KEY ( id ))";

       String sql = "CREATE TABLE studentinfo " +
       "(enrollno VARCHAR(255) not NULL, " +
       " name VARCHAR(255), " +
       " PRIMARY KEY ( enrollno ))";


      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample
