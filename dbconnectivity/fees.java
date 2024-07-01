package dbconnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class fees {
   //insert
	void insert() {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnectivity","root","accord");
	    	System.out.println("DBconnected");
			//insert query
			String q="insert into fees values(?,?,?,?)";
			System.out.println("Enter the ID");
			int id=sc.nextInt();
			System.out.println("Enter the NAME");
			String name=sc.next();
			System.out.println("Fees paid or not");
			String f=sc.next();
			System.out.println("Enter the MEMBERSHIP:");
			String membership=sc.next();
			//Preparing statement
			PreparedStatement pst=con.prepareStatement(q);
			pst.setInt(1,id);
			pst.setString(2,name);
			pst.setString(3, f);
			pst.setString(4,membership );
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
	void update(){
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnectivity","root","accord");
			System.out.println("DBconnected");
			//query
			String q="update fees set feespaid=? where id=?";
			System.out.print("enter the ID whose value has to be updated");
			int id=sc.nextInt();
			System.out.print("enter the updated fees paid or not");
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
	void delete(){
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnectivity","root","accord");
			System.out.println("DBconnected");
			//query
			String q="delete from fees where id=?";
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
	void view(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnectivity","root","accord");
			System.out.println("DBconnected");
			//query
			String q="select * from fees";
			//preparing statement
			Statement smt=con.createStatement();
			//executing
			ResultSet rs=smt.executeQuery(q);
			System.out.println("ID\tNAME\tFEES PAID OR NOT\tMEMBERSHIP");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t\t\t"+rs.getString(4));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
    }
	//search
	void search(){
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnectivity","root","accord");
			System.out.println("DBconnected");
			//query
			String q="select * from fees where id=?";
			System.out.println("Enter Id to view the record :");
			int id=sc.nextInt();
			//preparing statement
			PreparedStatement pst =con.prepareStatement(q);
			pst.setInt(1,id);
			//executing
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println("ID\tNAME\tFEES PAID OR NOT\tMEMBERSHIP");
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t\t\t"+rs.getString(4));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
