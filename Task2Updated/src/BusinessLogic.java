import java.io.*;
import java.util.*;
import java.sql.*;

public class BusinessLogic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String authenticate_manager(String ssn, Connection cond)
	{
		try {
		Statement st;
		st = cond.createStatement();
		ResultSet rs=st.executeQuery("select mgrssn from Department");
		int stat = 0;
		while(rs.next())
			{
			if(ssn.equalsIgnoreCase(rs.getString(1)))
			{
				stat = 1;
				break;
			}
			}
		 if(stat==1)
			 return "success";
		}
		catch(Exception e)
		{
			System.out.println("Business logic class Exception");
		}
		return "failure";
	}
}
