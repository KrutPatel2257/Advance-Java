import java.rmi.*;
import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Client {
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		String enroll, name;
		try {
			System.out.println("Enroll no: 130050131071");
			String ip1="rmi://localhost/SERVICE1";
			RemoteInterface1 s1 = (RemoteInterface1)Naming.lookup(ip1);
			String ip2="rmi://localhost/SERVICE2";
			RemoteInterface2 s2 = (RemoteInterface2)Naming.lookup(ip2);
			System.out.println("Enter Enrollno: ");
			enroll = in.nextLine();
			System.out.println("Enter Name: ");
			name = in.nextLine();
			if(s1.insertInDB(enroll, name)){
				System.out.println("Data Inserted.");
			}else {
				System.out.println("Data Not Inserted.");
			}
			
			ArrayList<Student> data = new ArrayList<Student>();
			data = s2.selectFromDB();
			
			System.out.println();
			System.out.println("Data fetched from database");
			for(int i = 0; i < data.size(); i++){
				Student student = (Student) data.get(i);
				System.out.println("Enrollno: "+student.getEnrollno());
				System.out.println("Name: "+student.getName());
			}
			//String[] data = s2.selectFromDB();
			//System.out.println("Enrollno: "+data[0]);
			//System.out.println("Name: "+data[1]);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}