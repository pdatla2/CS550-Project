import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import oracle.jdbc.driver.*;
public class ConnectionClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	
	}
	
	public Connection connect()
	{
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g","pdatla2","phejyc");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e) {
			//e.printStackTrace();
			System.out.println("connectionclass SQL exception");
		}
		catch(Exception e) {
			System.out.println("connectionclass exception");
		}
		
		return con;
	}

}
