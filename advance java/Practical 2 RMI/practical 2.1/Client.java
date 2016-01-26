import java.rmi.*;
import java.io.*;
import java.util.Scanner;

public class Client {
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		int num1, num2;
		try {
			System.out.println("Enroll no: 130050131071");
			String ip="rmi://localhost/SERVICE";
			RemoteInterface s = (RemoteInterface)Naming.lookup(ip);
			System.out.println("Enter num 1: ");
			num1 = in.nextInt();
			System.out.println("Enter num 2: ");
			num2 = in.nextInt();
			System.out.println("sum: "+ s.add(num1, num2));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}