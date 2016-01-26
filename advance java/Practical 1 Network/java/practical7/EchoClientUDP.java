import java.net.*;
import java.io.*;
import java.lang.*;

public class EchoClientUDP {
	public static void main(String args[]) {
		
		String read = null;
		StringBuffer line = new StringBuffer();
        DatagramSocket datagramSocket = null;
        FileReader fileReader = null;
        try {
        	
            datagramSocket = new DatagramSocket();     
            fileReader = new FileReader(new File("text.txt"));
            
            BufferedReader stdIn = new BufferedReader(fileReader);

			while ((read = stdIn.readLine()) != null) {
				line.append(read);
				line.append("\n");
			}
				
				String stringLines = line.toString();
				byte[] b = stringLines.getBytes();
				InetAddress host = InetAddress.getByName("localhost");
	            
				System.out.println ("Attemping to connect to host " +
						host.getAddress() + " on port 10007.");
				
	            DatagramPacket dataPacket = new DatagramPacket(b, b.length, host, 10007);
	            
	            
	            datagramSocket.send(dataPacket);
	            
	            System.out.println("Client: ");
	            System.out.println("_______ ");
	            System.out.println(line);
	            
	            
	            
	            byte[] buffer = new byte[500];
	            
	            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
	            datagramSocket.receive(reply);
	            String serverReply = new String(reply.getData()).trim();
	            System.out.println();
	            System.out.println("Server: ");
	            System.out.println("_______ ");
	            System.out.println(serverReply);
	            
        }
        catch (UnknownHostException e) {
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