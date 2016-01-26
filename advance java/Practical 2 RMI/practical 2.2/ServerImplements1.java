import java.rmi.*;
import java.rmi.server.*;
import java.lang.String;


public class ServerImplements1 extends 
 UnicastRemoteObject implements RemoteInterface1
  {
  public ServerImplements1()throws Exception
  {
	  super();
  }
  
  
  public int[][] add(int[][] x,int[][] y)
  {
	  int[][] mat_temp = new int[3][];
	  for(int i = 0; i<3; i++){
		  mat_temp[i] = new int[3];
		  for(int j = 0; j<3; j++){
			  mat_temp[i][j] = x[i][j] + y[i][j]; 
		  } 
	  }
  return mat_temp;
  }
}