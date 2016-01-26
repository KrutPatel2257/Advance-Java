import java.rmi.*;

public interface RemoteInterface2 extends Remote
{
  public int[][] mul(int[][] x,int[][] y)throws Exception;
}