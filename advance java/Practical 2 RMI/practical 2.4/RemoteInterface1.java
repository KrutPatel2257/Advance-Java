import java.rmi.*;

public interface RemoteInterface1 extends Remote
{
  public boolean insertInDB(String enroll, String name)throws Exception;
}