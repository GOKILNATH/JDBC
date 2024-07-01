package dbconnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class admin {
	//insert
	void insert() {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnectivity","root","accord");
	    	System.out.println("DBconnected");
			//insert query
			String q="insert into admin values(?,?,?,?,?,?,?,?)";
			System.out.println("Enter the ID");
			int id=sc.nextInt();
			System.out.println("Enter the NAME");
			String name=sc.next();
			System.out.println("Enter the AGE");
			int age=sc.nextInt();
			System.out.println("Enter the WEIGHT");
			int weight=sc.nextInt();
			System.out.println("Enter the PHONE NO");
			Long ph=sc.nextLong();
			System.out.println("Enter the DATE OF JOIN");
			String dateofjoin=sc.next();
			System.out.println("Enter the END DATE");
			String enddate=sc.next();
			System.out.println("Enter the MEMBERSHIP:");
			String membership=sc.next();
			//Preparing statement
			PreparedStatement pst=con.prepareStatement(q);
			pst.setInt(1,id);
			pst.setString(2,name);
			pst.setInt(3, age);
			pst.setInt(4, weight);
			pst.setLong(5, ph );
			pst.setString(6,dateofjoin);
			pst.setString(7,enddate);
			pst.setString(8,membership );
			//execute
			int n=pst.executeUpdate();
			if(n>0){
				System.out.println("Record inserted");
			}
			else {
				System.out.println("Record Not inserted");
			}
							
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    }
	//update
	void update() {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnectivity","root","accord");
			System.out.println("DBconnected");
			//query
			String q="update admin set membership=? where id=?";
			System.out.print("enter the ID whose value has to be updated");
			int id=sc.nextInt();
			System.out.print("enter the updated membership value");
			String val=sc.next();
			//Preparing statement
			PreparedStatement pst =con.prepareStatement(q);
			pst.setString(1, val);
			pst.setInt(2, id);
			//executing
			int n=pst.executeUpdate();
			String res=n>0?" updated":" Not updated";
			System.out.println(res);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	//delete
	void delete() {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnectivity","root","accord");
			System.out.println("DBconnected");
			//query
			String q="delete from admin where id=?";
			System.out.print("enter the ID whose record to be deleted");
			int id=sc.nextInt();
			//Preparing statement
			PreparedStatement pst =con.prepareStatement(q);
			pst.setInt(1,id);
			//executing
			int n=pst.executeUpdate();
			String res=n>0?"Record deleted":"Record Not deleted";
			System.out.println(res);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	//view
	void view() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnectivity","root","accord");
			System.out.println("DBconnected");
			//query
			String q="select * from admin";
			//preparing statement
			Statement smt=con.createStatement();
			//executing
			ResultSet rs=smt.executeQuery(q);
			System.out.println("ID\tNAME\tAGE\tWEIGHT\tPHONE NO\tDATE_OF_JOIN\tEND_DATE\tMEMBERSHIP");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getLong(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
	}
	//search
	void search() {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnectivity","root","accord");
			System.out.println("DBconnected");
			//query
			String q="select * from admin where id=?";
			System.out.println("Enter Id to view the record :");
			int id=sc.nextInt();
			//preparing statement
			PreparedStatement pst =con.prepareStatement(q);
			pst.setInt(1,id);
			//executing
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println("ID\tNAME\tAGE\tWEIGHT\tPHONE NO\tDATE_OF_JOIN\tEND_DATE\tMEMBERSHIP");
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getLong(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	void aprint() {
		while(true) {
		Scanner sc=new Scanner(System.in);
		admin a=new admin();
		System.out.println("Welcome to admin access...\nPlease Select the options:\n\t1.Insert \n\t2.Update\n\t3.Delete\n\t4.View\n\t5.Search\n\t6.Exit");
		int ch=sc.nextInt();
		if(ch==1) {
			a.insert();
		}
		if(ch==2) {
		    a.update();
		}
        if(ch==3) {
        	a.delete();
        	
        }
        if(ch==4) {
        	a.view();  
        }
        if(ch==5) {
        	a.search();
        }
        else if(ch==6) {
			System.out.println("Operation terminated");
			System.exit(0);
        }
		}
	}
	public static void main(String[] args) {
		
    }
}




	