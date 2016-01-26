import java.rmi.*;

public interface RemoteInterface extends Remote
{
  public boolean insertInDB(String enroll, String name)throws Exception;
}