import java.io.*;
import oracle.jdbc.driver.*;
import java.util.*;
import java.sql.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servelt1
 */
@WebServlet("/Servelt1")
public class Servelt1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servelt1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try
		{
	
		Employee e = new Employee();
		ConnectionClass con1 = new ConnectionClass();
		Connection condb = con1.connect();
		String click=request.getParameter("button1");
			System.out.println("Click:"+click);
		if(click==null)
		{
		String address1;
		String something = request.getParameter("manager_ssn1");
		//response.getWriter().append("Served at: ").append(request.getContextPath()).append("managerssn").append(something);
		
		BusinessLogic bl = new BusinessLogic();
		String manager_login_status = bl.authenticate_manager(something, condb);
		System.out.println(manager_login_status);
		if(manager_login_status.equalsIgnoreCase("success"))
			address1="/Emp_details.jsp";
		else {
			address1="/msginputwrong.jsp";
		}
		
			RequestDispatcher dispatcher =  request.getRequestDispatcher(address1);
			dispatcher.forward(request, response);
			
		}
		
		else
		{
			//if((request.getParameter("hours"))!=null && ((request.getParameter("pno1"))!=null))
			//{
			double prohours1=Double.parseDouble(request.getParameter("hours"));	
			String[] project12 = request.getParameterValues("pno1");
			String[] hours12 = request.getParameterValues("hours1");
			//System.out.println(project1);
			int len12=project12.length;
			System.out.println(len12);
			long[] arr12 = new long[len12];
			double[] arr22 = new double[len12];
			double sum_hours = prohours1;
			for(int l=0;l<len12;l++)
			{
				arr12[l] = Long.parseLong(project12[l]);
				arr22[l] = Double.parseDouble(hours12[l]);
				sum_hours = sum_hours + arr22[l];
			}
			System.out.println("SUM HOURS"+sum_hours);
			
			
			if(sum_hours>40)
			{
			   	  response.setContentType("text/html");
				  PrintWriter out = response.getWriter();
				  RequestDispatcher rd=request.getRequestDispatcher("/error.jsp");

				 // out.println("<script>");
				 // out.println("alert('Project Hours can't be greated than 40')");
				 // out.println("document.getElementById('error').innerText=Total No of Project Hours can't exceed 40 for each employee, please correct them!");
				  //out.println("</script>");
				  rd.forward(request, response);
			}
			
			else
			{
		String fname=request.getParameter("fname");
		String mname=request.getParameter("mname");
		String lname=request.getParameter("lname");
		String ssn=request.getParameter("ssn");
		String bdate=request.getParameter("bdate");
		String address=request.getParameter("address");
		char sex=request.getParameter("sex").charAt(0);
		double salary=Double.parseDouble(request.getParameter("salary"));
		String superssn=request.getParameter("superssn");
		long depno=Long.parseLong(request.getParameter("depno"));
		String email=request.getParameter("email");
		
		
		/*System.out.println("fname:"+fname);
		System.out.println("Minit"+mname);
		System.out.println("Lname:"+lname);
		System.out.println("SSN:"+ssn);
		System.out.println("Bdate:"+bdate);
		System.out.println("Address:"+address);
		System.out.println("Sex:"+sex);
		System.out.println("Salary:"+salary);
		System.out.println("SuperSSN:"+superssn);
		System.out.println("DepNo:"+depno);
		System.out.println("Email:"+email);*/
		
		e.setFname(fname);
		e.setMinit(mname);
		e.setLname(lname);
		e.setSsn(ssn);
		e.setBdate(bdate);
		e.setAddress(address);
		e.setSex(sex);
		e.setSalary(salary);
		e.setSuperssn(superssn);
		e.setDno(depno);
		e.setEmail(email);
		System.out.println(e);
		String sql="insert into EMPLOYEE(fname,minit,lname,ssn,bdate,address,sex,salary,superssn,dno,email) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = condb.prepareStatement(sql);
		/*
		ps.setString(1, e.getFname());
		//ps.setString(parameterIndex, x);
		ps.setString(2, e.getMinit());
		ps.setString(3, e.getLname());
		ps.setString(4, e.getSsn());
		ps.setString(5, e.getBdate());
		ps.setString(6, e.getAddress());
		ps.setString(7, String.valueOf(e.getSex()));
		ps.setDouble(8, e.getSalary());
		ps.setString(9, e.getSuperssn());
		ps.setLong(10, e.getDno());
		ps.setString(11, e.getEmail());
		int i = ps.executeUpdate();
		*/
		
		ps.setString(1, fname);
		ps.setString(2, mname);
		ps.setString(3, lname);
		ps.setString(4, ssn);
		ps.setString(5, bdate);
		ps.setString(6, address);
		ps.setString(7, sex+"");
		ps.setDouble(8, salary);
		ps.setString(9, superssn);
		ps.setLong(10, depno);
		ps.setString(11, email);
		int i = ps.executeUpdate();
		
		if(i==0)
			System.out.println("Adding of Employee : FAILED");
		else
			System.out.println("Adding of Employee : SUCCESSFUL");
		
		request.setAttribute("EmpStatus", i); 
		
		String depopt = request.getParameter("dependentoption");
		System.out.println("Dependent Option: "+depopt);
		if(depopt == "no")
		{
			
		}
		else
		{
			System.out.println("Dependent option chosen is YES and entered IF block");
        String depname=request.getParameter("depname");
        char depsex=request.getParameter("depsex").charAt(0);
        String depbdate=request.getParameter("depbdate");
        String deprelation=request.getParameter("deprelation");
        if(depname != "" && (depsex+"") != "" && depbdate != "" && deprelation != "")
        {
        	System.out.println("Dependent Details : FULL");
        	Dependent dobj = new Dependent();
        	dobj.setEssn(ssn);
        	dobj.setDependentName(depname);
        	dobj.setSex(depsex);
        	dobj.setBdate(depbdate);
        	dobj.setRelationship(deprelation);
        	
        	String sql_dependent="insert into Dependent(Essn, Dependent_name, Sex, Bdate, Relationship) values(?,?,?,?,?)";
    		PreparedStatement ps1 = condb.prepareStatement(sql_dependent);
    		ps1.setString(1, ssn);
    		ps1.setString(2, depname);
    		ps1.setString(3, depsex+"");
    		ps1.setString(4, depbdate);
    		ps1.setString(5, deprelation);
    		int i1 = ps1.executeUpdate();
    		
    		if(i1==0)
    			System.out.println("Adding of Dependent : FAILED");
    		else
    			System.out.println("Adding of Dependent : SUCCESSFUL");
    		
    		request.setAttribute("DepStatus", i1);
        }
        else 
        	System.out.println("Dependent Details : EMPTY - Please correct them");
        
		}
		
        
		String projectoptthing = request.getParameter("projectoption");
        	
		System.out.println("Project Works_on Option chosen:"+projectoptthing);
		//if(projectoptthing == "yes")
		{
        long prohours10 = Long.parseLong(request.getParameter("pno"));
        double prohours=Double.parseDouble(request.getParameter("hours"));
        if(((request.getParameter("pno"))!= "") && ((request.getParameter("hours")) != ""))
        {
        	System.out.println("Works_On Details : FULL");
        	WorksOn w = new WorksOn();
        	w.setEssn(ssn);
        	w.setPno(prohours10);
        	w.setHours(prohours);
        	
        	String sql_workson="insert into Works_on(Essn, Pno, Hours) values(?,?,?)";
    		PreparedStatement ps2 = condb.prepareStatement(sql_workson);
    		ps2.setString(1, ssn);
    		ps2.setLong(2, prohours10);
    		ps2.setDouble(3, prohours);

    		int i2 = ps2.executeUpdate();
    		
    		if(i2==0)
    			System.out.println("Adding of Works_On : FAILED");
    		else
    			System.out.println("Adding of Works_On : SUCCESSFUL");
    		
    		request.setAttribute("WorksStatus",i2);
    		
    		//if(((request.getParameter("pno1[c]"))!= "") && ((request.getParameter("hours1[c]")) != ""))
    		{	
    			//System.out.println(request.getElementById("pno11"));
    			String[] project1 = request.getParameterValues("pno1");
    			String[] hours1 = request.getParameterValues("hours1");
    			//System.out.println(project1);
    			int len1=project1.length;
    			if(len1!=0)
    			{
    			//System.out.println(len1);
    			long[] arr1 = new long[len1];
    			double[] arr2 = new double[len1];
    			for(int l=0;l<len1;l++)
    			{
    				arr1[l] = Long.parseLong(project1[l]);
    				arr2[l] = Double.parseDouble(hours1[l]);
    				WorksOn w1=new WorksOn();
    
    	        	w1.setEssn(ssn);
    	        	w1.setPno(arr1[l]);
    	        	w1.setHours(arr2[l]);
    	        	
    	        	String sql_workson1="insert into Works_on(Essn, Pno, Hours) values(?,?,?)";
    	    		PreparedStatement ps3 = condb.prepareStatement(sql_workson1);
    	    		ps3.setString(1, ssn);
    	    		ps3.setLong(2, arr1[l]);
    	    		ps3.setDouble(3, arr2[l]);

    	    		int i3 = ps3.executeUpdate();
    	    		
    	    		if(i3==0)
    	    			System.out.println("Adding of Works_On additional field: FAILED");
    	    		else
    	    			System.out.println("Adding of Works_On additional field: SUCCESSFUL");
    	    		
    	    		request.setAttribute("WorksAddStatus",i3);
    	    		
    			}
    			
    			}
    			
    			//System.out.println("New project added:");
    			//long project1 = Long.parseLong(request.getParameter("pno1[c]"));
    			//System.out.println("Second Project:"+(request.getParameter("pno1[c]"))+"");
    			//double hours1 = Double.parseDouble(request.getParameter("hours1[c]"));
    			//System.out.println("Hours:"+(request.getParameter("hours1[c]"))+"");
    		}
    		
        }
        else
        	System.out.println("Works_On Details : EMPTY - Please correct them");
        
		}
        
        
        
	   /* if (depopt == "yes")
	    {
	        System.out.println("dependentoptionselected: " + depopt);
	        
	    }
	    	
	    else
	        System.out.println("dependentoptionselected: " + depopt);
	        */
		}
			 //response.setContentType("text/html");
			 //PrintWriter out1 = response.getWriter();
			RequestDispatcher dispatcherfinal =  request.getRequestDispatcher("/successreport.jsp");
			dispatcherfinal.forward(request, response);
			
			
			

			  RequestDispatcher rd=request.getRequestDispatcher("/error.jsp");

			 // out.println("<script>");
			 // out.println("alert('Project Hours can't be greated than 40')");
			 // out.println("document.getElementById('error').innerText=Total No of Project Hours can't exceed 40 for each employee, please correct them!");
			  //out.println("</script>");
			  rd.include(request, response);
			
		}
		}
		catch(Exception e)
		{
		e.printStackTrace(); }
	}

}
