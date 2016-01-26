import java.rmi.*;
import java.io.*;
import java.util.Scanner;

public class Client {
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		String enroll, name;
		try {
			System.out.println("Enroll no: 130050131071");
			String ip="rmi://localhost/SERVICE3";
			RemoteInterface s = (RemoteInterface)Naming.lookup(ip);
			System.out.println("Enter Enrollno: ");
			enroll = in.nextLine();
			System.out.println("Enter Name: ");
			name = in.nextLine();
			if(s1.insertInDB(enroll, name)){
				System.out.println("Data Inserted.");
			}else {
				System.out.println("Data Not Inserted.");
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}