package dbconnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class client {
	//view
    void view() {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnectivity","root","accord");
			System.out.println("DBconnected");
			//query
			String q="select * from client";
			//preparing statement
			Statement smt=con.createStatement();
			//executing
			ResultSet rs=smt.executeQuery(q);
			System.out.println("ID\tNAME\tPHONE\t\tDATE_OF_JOIN\tEND_DATE\tMEMBERSHIP");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getLong(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
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
        	//query
        	String q="select * from client where id=?";
        	System.out.println("Enter ID to view the record");
        	int id=sc.nextInt();
        	//prepare statement
        	PreparedStatement pst=con.prepareStatement(q);
        	pst.setInt(1,id);
        	ResultSet rs=pst.executeQuery();
        	System.out.println("ID\tNAME\tPHONE\tDATE_OF_JOIN\tEND_DATE\tMEMBERSHIP");
        	while(rs.next()) {
        		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getLong(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
        	}
        }
        catch(ClassNotFoundException | SQLException e){
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
			String q="update client set membership=? where id=?";
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
  //insert
    void insert() {
    	Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnectivity","root","accord");
	    	System.out.println("DBconnected");
			//insert query
			String q="insert into client values(?,?,?,?,?,?)";
			System.out.println("Enter the ID");
			int id=sc.nextInt();
			System.out.println("Enter the NAME");
			String name=sc.next();
			System.out.println("Enter the PHONE");
			Long phone=sc.nextLong();
			System.out.println("Enter the JOIN_OF_DATE");
			String jod=sc.next();
			System.out.println("Enter the END_DATE");
			String ed=sc.next();
			System.out.println("Enter the MEMBERSHIP:");
			String membership=sc.next();
			//Preparing statement
			PreparedStatement pst=con.prepareStatement(q);
			pst.setInt(1,id);
			pst.setString(2,name);
			pst.setLong(3, phone);
			pst.setString(4, jod);
			pst.setString(5, ed );
			pst.setString(6,membership );
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
    //delete
    void delete() {
    	Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnectivity","root","accord");
			System.out.println("DBconnected");
			//query
			String q="delete from client where id=?";
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
    //client access
    void cprint() {
    	while(true) {
        	client c=new client();
    		Scanner sc =new Scanner(System .in);
            System.out.println("Welcome To Client database");
            System.out.println("Select the Options\n\t1.View\n\t2.Search\n\t3.Update\n\t4.Exit");
            int ch=sc.nextInt();
            if(ch==1) {
            	c.view();
            }
            else if(ch==2) {
            	c.search();
            }
            else if(ch==3) {
            	c.update();
            }
            else if(ch==4) {
            	System.out.println("Operation Terminated");
            	System.exit(0);
            }
        }
    }
    
    //admin access
    void adprint(){
    	while(true) {
        	client c=new client();
    		Scanner sc =new Scanner(System .in);
            System.out.println("Welcome To Admin Client database");
            System.out.println("Select the Options:\n\t1.Insert\n\t2.View\n\t3.Search\n\t4.Update\n\t5.Delete\n\t6.Exit");
            int ch=sc.nextInt();
            if(ch==1) {
            	c.insert();
            }
            else if(ch==2){
                c.view();	
            }
            else if(ch==3) {
            	c.search();
            }
            else if(ch==5){
            	c.delete();
            }
            else if(ch==4) {
            	c.update();
            }if(ch==6) {
            	System.out.println("Operation Terminated");
            	System.exit(0);
            }
        }
    }
	public static void main(String[] args) {
	
        
	}

}
