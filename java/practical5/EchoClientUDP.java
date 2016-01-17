import java.net.*;
import java.io.*;

public class EchoClientUDP {
	public static void main(String args[]) {
		
        
        DatagramSocket datagramSocket = null;
        
        try {
        	
            datagramSocket = new DatagramSocket();     
            
			String requestTime = "Requesting time.";
			
				
				byte[] b = requestTime.getBytes();
				InetAddress host = InetAddress.getByName("localhost");
	            
				System.out.println ("Attemping to connect to host " +
						host.getAddress() + " on port 10007.");
				
	            DatagramPacket dataPacket = new DatagramPacket(b, b.length, host, 10007);
	            
	            
	            datagramSocket.send(dataPacket);
	            
	            System.out.println("Client: "+requestTime);
	            
	            
	            byte[] buffer = new byte[100];
	            
	            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
	            datagramSocket.receive(reply);
	            String word = new String(reply.getData()).trim();
	            System.out.println("Server: "+word);
			
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