
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HoustonEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("List of Employees part of the Research Department:");
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g","pdatla2","phejyc");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		int j=1;
		try
		{
			//ArrayList<String> l1= new ArrayList<String>();
			Statement st;
			System.out.println("List of Employees working in Houston");
			st = con.createStatement();
			ResultSet rs=st.executeQuery("select E.Lname, E.Ssn, W.Hours from Employee E, Dept_locations DL, Works_on W, Project P where E.Dno=DL.Dnumber and Dlocation='Houston' and E.ssn=W.Essn and P.Pname='ProductX' and W.Pno=P.Pnumber");
			//i=ps.executeUpdate();
			while(rs.next())
			{
				System.out.println(j+")");
				System.out.print("Last Name: "+rs.getString(1));
				System.out.print("	SSN: "+rs.getString(2));
				System.out.println("	Hours_worked: "+rs.getString(3));
				//l1.add(rs.getString(1));
				j++;
			}
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("catch block in studentDAO reached");
			e.printStackTrace();
	}
	}
}