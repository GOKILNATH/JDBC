package dbconnectivity;

import java.util.Scanner;

public class dashboard {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		dashboard db=new dashboard();
		admin a=new admin();
		client c=new client();
		fees fs=new fees();
		while(true) {
		System.out.println("Enter the option: \n\t1.Admin access \n\t2.Client Data \n\t3.Fees Details");
		int ch=sc.nextInt();
		if(ch==1) {
			 System.out.println("Enter Username:");
			 String User=sc.next();
			 System.out.println("Enter Password:");
			 String pass=sc.next();
			 a.aprint();
		}
		else if(ch==2) {
			System.out.println("Acessing data as admin or client.......");
			System.out.println("\n\t1.Admin\n\t2.Client");
			int g=sc.nextInt();
			if(g==1) {
			    c.adprint();
			}else {
			    c.cprint();
			}
		}else if(ch==3) {
			while(true) {
			 System.out.println("Access fees database from \n\t1.Admin \n\t2.Client.");
			 int f=sc.nextInt();
			 if(f==1) {
				 System.out.println("Welcome To Admin Access Fees Data");
				 System.out.println("Enter Username:");
				String User=sc.next();
				System.out.println("Enter Password:");
				String pass=sc.next();
				while(true) {
				System.out.println("Select the options:\n\t1.Insert \n\t2.Update\n\t3.Delete\n\t4.View\n\t5.Search\n\t6.Exit");
				int af=sc.nextInt();
				if(af==1) {
					fs.insert();
				}else if(af==2) {
					fs.update();
				}else if(af==3) {
					fs.delete();
				}else if(af==4) {
					fs.view();
				}else if(af==5) {
					fs.search();
				}else if(af==6) {
				    System.out.println("Fees Operation Terminated");	
				    System.exit(0);
				}
				}
			 }else if(f==2) {
				 while(true) {
				 System.out.println("Welcome To Client Fees Data");
				 System.out.println("Select the options:\n\t1.View\n\t2.Search\n\t3.Exit");
				 int cf=sc.nextInt();
				 if(cf==1) {
					 fs.view();
				 }else if(cf==2) {
					 fs.search();
				 }else if(cf==3) {
					 System.out.println("Fees Operation Terminated");	
						System.exit(0);
				 }
				 }
			 }
			}
		}else {
			System.out.println("Operation Terminated");
			System.exit(0);
		}
		
		}
	}

}
