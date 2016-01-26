import java.net.*;
import java.io.*;

public class ServerUDP {
	public static void main(String args[]) {

		DatagramSocket datagramSocket = null;

		try {
			datagramSocket = new DatagramSocket(10009);
			System.out.println("Enroll: 130050131063");
			System.out.println ("Waiting for connection.....");


			while(true) {
				byte [] buffer = new byte[50];
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);


				datagramSocket.receive(request);
				System.out.println ("Connection successful");
			    System.out.println ("Waiting for input.....");

				String arrayMsg = new String(request.getData());
				System.out.println("From: " + request.getAddress() + " Port: " + request.getPort());
				System.out.println("Client: "+arrayMsg);

				int ans[] = new ProcessString(arrayMsg).process();
				String answer = "No of characters is: "+ans[1]+" No of digits is: "+ans[0];

				byte[] sendMsg = answer.getBytes();

				DatagramPacket reply = new DatagramPacket(sendMsg, sendMsg.length, request.getAddress(), request.getPort());

				datagramSocket.send(reply);
				String word = new String(reply.getData());
				//System.out.println("Server: "+word);

				System.out.println ("Waiting for connection.....");
			}
		}catch(Exception ex) {

		}

	    datagramSocket.close();
	}
}
