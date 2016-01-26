import java.rmi.*;
import java.io.*;

public class Client {
	public static void main(String args[]) {
		
		int[][] matrice1 = {{1, 1, 1},{2, 2, 2},{3, 3, 3}};
		int[][] matrice2 = {{3, 3, 3},{2, 2, 2},{1, 1, 1}};
		int[][] matrice3 = new int[3][];
		matrice3[0] = new int[3];
		matrice3[1] = new int[3];
		matrice3[2] = new int[3];
		int[][] matrice4 = new int[3][];
		matrice4[0] = new int[3];
		matrice4[1] = new int[3];
		matrice4[2] = new int[3];
		
		try {
			System.out.println("Enroll no: 130050131071");
			String ip1="rmi://localhost/SERVICE1";
			String ip2="rmi://localhost/SERVICE2";
			RemoteInterface1 s1 = (RemoteInterface1)Naming.lookup(ip1);
			RemoteInterface2 s2 = (RemoteInterface2)Naming.lookup(ip2);
			
			System.out.println("Matrice 1 is: ");
			for(int i = 0; i<3; i++){
				for(int j = 0; j<3; j++){
					System.out.print(matrice1[i][j]+" "); 
				} 
				System.out.println();
			}
			System.out.println("Matrice 2 is: ");
			for(int i = 0; i<3; i++){
				for(int j = 0; j<3; j++){
					System.out.print(matrice2[i][j]+" "); 
				} 
				System.out.println();
			}
			
			matrice3 = s1.add(matrice1, matrice2);
			
			System.out.println("sum is: ");
			for(int i = 0; i<3; i++){
				for(int j = 0; j<3; j++){
					System.out.print(matrice3[i][j]+" "); 
				} 
				System.out.println();
			}
			
			matrice4 = s2.mul(matrice1, matrice2);
			
			System.out.println("product is: ");
			for(int i = 0; i<3; i++){
				for(int j = 0; j<3; j++){
					System.out.print(matrice4[i][j]+" "); 
				} 
				System.out.println();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}