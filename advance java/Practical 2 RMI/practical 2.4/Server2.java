import java.rmi.*;
import java.net.*;

public class Server2
{
  public static void main(String args[])
  {
  try
  {
  ServerImplements2 s2=new ServerImplements2();
  Naming.rebind("SERVICE2",s2);
  System.out.println("Server 2 Started ");
  }
  catch(Exception e)
  {
  System.out.println(e.getMessage());
  }
  }

}