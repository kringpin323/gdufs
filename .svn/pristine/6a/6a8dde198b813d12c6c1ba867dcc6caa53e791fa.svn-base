package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.fro.utils.LabParameter;

public class Tee {
	public static Connection con;
	public static Connection getCon(){
		String driverName = "com.microsoft.jdbc.sqlserver.SQLServerDriver"; 
		String dbURL = "jdbc:microsoft:sqlserver://192.168.0.111:1433;DatabaseName=gdufs"; 
		String userName = "sa"; 
		String userPwd = "frotech.com"; 

		try { 
		Class.forName(driverName).newInstance(); 
		System.out.println("load......"); 
		con = DriverManager.getConnection(dbURL,userName,userPwd); 
		System.out.println("Connection Successful!"); 
		} 
		catch (Exception e) { 
			System.out.println("Connection fail!"); 
		    e.printStackTrace(); 
		} 
		return con;
	}	
	public static void close(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch 
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getCon());
		LabParameter lp=new LabParameter();
	lp.operate="CLOSE";
	lp.AutoNavigation();
		
	}
}
