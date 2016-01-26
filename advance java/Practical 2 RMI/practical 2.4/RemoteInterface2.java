import java.rmi.*;
import java.util.*;

public interface RemoteInterface2 extends Remote
{
  public ArrayList<Student> selectFromDB()throws Exception;
}