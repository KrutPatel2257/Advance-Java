import java.net.*;
import java.io.*;
import java.util.*;

public class ServerUDP {
	public static void main(String args[]) {

		DatagramSocket datagramSocket = null;

		try {
			datagramSocket = new DatagramSocket(10007);
			System.out.println ("Waiting for connection.....");

			String inputLine;
			String[] inputTemp;

			while(true) {
				byte [] buffer = new byte[50];
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);


				datagramSocket.receive(request);
				System.out.println ("Enroll: 130050131063");
				System.out.println ("Connection successful");
			    System.out.println ("Waiting for input.....");

				String arrayMsg = new String(request.getData());
				System.out.println("From: " + request.getAddress() + " Port: " + request.getPort());
				System.out.println("Client: "+arrayMsg);

				inputTemp = arrayMsg.split(" ");
	            int input[] = new int[inputTemp.length];

				try {
		            for(int i = 0; i<input.length ; i++){
		            	String temp = inputTemp[i].trim();
		            	input[i] = Integer.parseInt(temp, 10);
		            }
  				} catch (NumberFormatException e) {
    					System.exit(1);
    			}

	            int ans[] = new BubbleSort(input, input.length).sort();
	            StringBuffer sbAns = new StringBuffer();
	            for(int i=0;i<ans.length;i++) {
	            	sbAns.append(ans[i]+" ");
	            }

	            //System.out.println("Server: " + sbAns);
	            String replyAns = sbAns.toString();
	            String Msg = new String("Sorted array is: "+replyAns);

	            byte[] sendMsg = Msg.getBytes();

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
