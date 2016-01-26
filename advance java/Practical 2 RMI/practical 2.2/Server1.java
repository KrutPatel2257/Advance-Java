import java.rmi.*;
import java.net.*;

public class Server1
{
  public static void main(String args[])
  {
  try
  {
  ServerImplements1 s1=new ServerImplements1();
  Naming.rebind("SERVICE1",s1);
  System.out.println("Server 1 Started ");
  }
  catch(Exception e)
  {
  System.out.println(e.getMessage());
  }
  }

}