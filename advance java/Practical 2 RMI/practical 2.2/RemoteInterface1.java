import java.rmi.*;

public interface RemoteInterface1 extends Remote
{
  public int[][] add(int[][] x,int[][] y)throws Exception;
}