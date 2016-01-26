import java.rmi.*;
import java.rmi.server.*;
import java.lang.String;


public class ServerImplements2 extends 
 UnicastRemoteObject implements RemoteInterface2
  {
  public ServerImplements2()throws Exception
  {
	  super();
  }
  
  public int[][] mul(int[][] x,int[][] y)
  {
	  int[][] mat_temp = new int[3][];
	  for(int i = 0; i<3; i++){
		  mat_temp[i] = new int[3];
		  for(int j = 0; j<3; j++){
			  mat_temp[i][j] = 0;
			  for(int k = 0; k<3; k++){
			  mat_temp[i][j] += x[i][k] * y[k][j]; 
			  }
		  } 
	  }
  return mat_temp;
  }
}