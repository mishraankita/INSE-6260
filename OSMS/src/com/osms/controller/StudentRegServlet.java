package com.osms.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StudentRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StudentName = request.getParameter("StudentName");
		String FatherName = request.getParameter("FatherName");
		String StuClass = request.getParameter("StuClass");
		String Section = request.getParameter("Section");
		
		System.out.println(StudentName);
		System.out.println(FatherName);
		System.out.println(StuClass);
		System.out.println(Section);
	    PreparedStatement psmt = null;      
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
			/*Statement stmt=con.createStatement();
			stmt.executeUpdate("insert into student values('"+StudentName+"','"+FatherName+"','"+StuClass+"','"+Section+"')");
        	*/
        	String query = "insert into student values(?,?,?,?)"; 
        	psmt = con.prepareStatement(query);
        	psmt.setString(1, StudentName);
        	psmt.setString(2, FatherName);
        	psmt.setString(3, StuClass);
        	psmt.setString(4, Section);
        	psmt.executeUpdate();
			
			String query1 = "insert into user values(?,?,?)"; 
        	psmt = con.prepareStatement(query1);
        	psmt.setString(1, StudentName);
        	psmt.setString(2, new String(new StringBuffer(StudentName).reverse()));
        	psmt.setString(3, "student");
        	psmt.executeUpdate();
			       	
				RequestDispatcher rd = request.getRequestDispatcher("./sturegsuccess.html");
	    		rd.forward(request, response);
				con.close();
        } 
        catch(Exception e){
        System.out.println(e);
        }
       

        
        }
	
		
		
	}
