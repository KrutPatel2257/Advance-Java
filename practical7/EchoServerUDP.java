import java.net.*;
import java.io.*;

public class EchoServerUDP {
	public static void main(String args[]) {
		
		DatagramSocket datagramSocket = null;
		
		try {
			datagramSocket = new DatagramSocket(10007);
			System.out.println ("Waiting for connection.....");
			
			
			while(true) {
				byte [] buffer = new byte[500];
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				
			    
				datagramSocket.receive(request);
				System.out.println("Enroll: 130050130171");
				System.out.println ("Connection successful");
			    System.out.println ("Waiting for input.....");
				
				String arrayMsg = new String(request.getData()).trim();
				System.out.println("From: " + request.getAddress() + " Port: " + request.getPort());
				System.out.println("Client: ");
				System.out.println("_______ ");
	            System.out.println(arrayMsg);
				
				
				//convert to uppercase
				arrayMsg = arrayMsg.toUpperCase();
				
				byte[] sendMsg = arrayMsg.getBytes();
				
				DatagramPacket reply = new DatagramPacket(sendMsg, sendMsg.length, request.getAddress(), request.getPort());
				
				datagramSocket.send(reply);
				String line = new String(reply.getData()).trim();
				System.out.println();
				System.out.println("Server: ");
				System.out.println("_______ ");
	            System.out.println(line);
				
				
				System.out.println ("Waiting for connection.....");
			}
		}catch(Exception ex) {
			
		}
		
	    datagramSocket.close();
	}
}