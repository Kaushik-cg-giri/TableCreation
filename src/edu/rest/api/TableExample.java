package edu.rest.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class TableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con =null;
		PreparedStatement pstmt=null;
		Statement stmt =null;
		ResultSet rslt =null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String dburl="jdbc:mysql://localhost:3306/rest_schema";
			con= DriverManager.getConnection(dburl,"root","password");
			System.out.println(con);
			
			String insertquery = "insert into employees_details values (101,'Ajay','Edappally','945281010'),(102,'Binu','kurottu','8281454525'),(103,'Ebin','kanthn','757474747410')";
			pstmt=  con.prepareStatement(insertquery);
			
			int count = pstmt.executeUpdate();
			System.out.println(count);
			
			String retrivequery = "select * from employees_details";
			stmt = con.createStatement();
			
			rslt=stmt.executeQuery(retrivequery);
			while(rslt.next()) {
				System.out.println("Employee_id>>"+rslt.getInt(1));
				System.out.println("Employee_name>>"+rslt.getString(2));
				System.out.println("Employee_address>>"+rslt.getString(3));
				System.out.println("Employee  _number>>"+rslt.getString(4));
				System.out.println("------------------------------------------");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
