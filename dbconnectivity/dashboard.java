package dbconnectivity;

import java.util.Scanner;

public class dashboard {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		dashboard db=new dashboard();
		admin a=new admin();
		client c=new client();
		System.out.println("Enter the option: \n\t1.Admin acces \n\t2.Client acces \n\t3.Fees");
		int ch=sc.nextInt();
		if(ch==1) {
			System.out.println("Enter Username:");
			String User=sc.next();
			System.out.println("Enter Password:");
			String pass=sc.next();
			a.aprint();
		}
		else if(ch==2) {
			c.cprint();
			
		}else if(ch==3) {
			
		}else {
			System.out.println("Operation Terminated");
			System.exit(0);
		}

	}

}
