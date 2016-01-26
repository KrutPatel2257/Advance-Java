import java.net.*;
import java.io.*;

public class ClientUDP {
	public static void main(String args[]) {
		
        
        DatagramSocket datagramSocket = null;
        
        try {
        	
            datagramSocket = new DatagramSocket();     
            
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));
			String userInput;
			
			System.out.print ("input: ");
			while ((userInput = stdIn.readLine()) != null) {
				if (userInput.equals("Bye.")) 
					break;
				
				byte[] b = userInput.getBytes();
				InetAddress host = InetAddress.getByName("localhost");
	           
				
	            DatagramPacket dataPacket = new DatagramPacket(b, b.length, host, 10007);
	     //        System.out.println ("Attemping to connect to host " +
						// dataPacket.getAddress() + " on port 10007.");
	            
	            datagramSocket.send(dataPacket);
	            
	            System.out.println("Client: "+userInput);
	            
	            
	            byte[] buffer = new byte[50];
	            
	            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
	            datagramSocket.receive(reply);
	            String word = new String(reply.getData());
	            System.out.println("Server: "+word);
	            
	            System.out.print ("input: ");
			}
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: localhost");
			e.printStackTrace();
            System.exit(1);
        }
        
        datagramSocket.close();
	}
}