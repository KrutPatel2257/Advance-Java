import java.net.*;
import java.io.*;
import java.util.*;


public class ServerTCP extends Thread
{
 protected Socket clientSocket;

 public static void main(String[] args) throws IOException
   {
    ServerSocket serverSocket = null;

    try {
         serverSocket = new ServerSocket(10008);
		 System.out.println ("Enroll: 130050131071");
         System.out.println ("Connection Socket Created");
         try {
              while (true)
                 {
                  System.out.println ("Waiting for Connection");
                  new ServerTCP (serverSocket.accept());
                 }
             }
         catch (IOException e)
             {
              System.err.println("Accept failed.");
              System.exit(1);
             }
        }
    catch (IOException e)
        {
         System.err.println("Could not listen on port: 10008.");
         System.exit(1);
        }
    finally
        {
         try {
              serverSocket.close();
             }
         catch (IOException e)
             {
              System.err.println("Could not close port: 10008.");
              System.exit(1);
             }
        }
   }

 private ServerTCP(Socket clientSoc)
   {
    clientSocket = clientSoc;
    start();
   }

 public void run()
   {
    System.out.println ("New Communication Thread Started");

    try {
         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
                                      true);
         BufferedReader in = new BufferedReader(
                 new InputStreamReader( clientSocket.getInputStream()));

        String inputLine;
        String[] inputTemp;

         while ((inputLine = in.readLine()) != null) {
        	 System.out.println ("Server: " + inputLine);

        	 if (inputLine.equals("Bye."))
                 break;

      		 inputTemp = inputLine.split(" ");
             int input[] = new int[inputTemp.length];

             for(int i = 0; i<input.length ; i++){
            	String temp = inputTemp[i];
             	input[i] = Integer.parseInt(temp);
             }

             int ans[] = new BubbleSort(input, input.length).sort();

             StringBuffer sbAns = new StringBuffer();
             for(int i=0;i<ans.length;i++) {
            	 sbAns.append(ans[i]+" ");
             }

             //System.out.println ("Server: " + sbAns);
             String replyAns = sbAns.toString();
             out.println("Sorted array is: "+replyAns);



         }

         out.close();
         in.close();
         clientSocket.close();
        }
    catch (IOException e)
        {
         System.err.println("Problem with Communication Server");
         System.exit(1);
        }
    }
}
