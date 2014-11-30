package com.osms.controller;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
//package com.servlet;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.student.Student;
//
//
public class GetStudentInfoServlet extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> sessionMap;

	
	public String payFees(){
		String userId = (String) sessionMap.get("UserID");
		//TODO Implement the business logic here
		System.out.println("Pay Fees");
		
		return "success";
		
		
	}
	
	public String accountSettingDetails(){
		String userId = (String) sessionMap.get("UserID");
		//TODO Implement the business logic here
		System.out.println("Account Setting Details");
		
		return "success";
		
		
	}
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		HttpSession session = request.getSession();
//		String userName = request.getParameter("userget");
//		System.out.println("My name is :"+userName);
//		List l = new ArrayList();
//		 PrintWriter out = response.getWriter();
//		
//		        try {
//		        	
//		    Connection con= DBConnection.getConnection();
//			Statement stmt=con.createStatement();
//			ResultSet rs=stmt.executeQuery("select * from studentdetails" );
//			System.out.println("rs is :"+rs);
//			
//			System.out
//			.println("===============students====  firstname, middlename, lastname, fname, dob, address, Curriculum, Grade;===========");
//
//		    out.println("<html><body background=welcome.jpg ><h1 align=center ><font color=blue>Student Details</font></h1><br><table border =1 align=center ><tr><th>FirstName</th><th>Middle Name</th><th>LastName</th> <th>Father Name</th> <th>Date of birth</th>  <th>Address</th>  <th>Curriculum</th>  <th>Grade</th></tr>");	
//			while(rs.next()){
//				
//				Student s = new Student();
//				s.setStudentid(rs.getInt(1));
//				s.setFirstname(rs.getString(2));
//				s.setMiddlename(rs.getString(3));
//				s.setLastname(rs.getString(4));
//				s.setFname(rs.getString(5));
//				s.setDob(rs.getString(6));
//				s.setAddress(rs.getString(7));
//				s.setCurriculum(rs.getString(8));
//				s.setGrade(rs.getString(9));
//	    	 	l.add(s);
//	    	 	System.out.println("student name:"+s.getFirstname());
//	    	 	out.println("<tr><td>"+s.getFirstname() +"</td><td>"+s.getMiddlename()+"</td><td>"+s.getLastname()+"</td><td>"+s.getFname()+"</td><td>"+s.getDob()+"</td><td>"+s.getAddress()+"</td><td>"+s.getCurriculum()+"</td><td>"+s.getGrade()+"</td></tr>");
//        } 
//			
//			out.println("</table border=3 ></body></html>");
//			out.println("<br/><br/>");
//			out.println(" <h2 align=center><a href=./student.jsp>Register a new Student</a><br/></h2>");
//			out.println(" <h2 align=center><a href=./adminsuccess.jsp> Go to Home</a></h2>");
//			System.out.println("==============================");
//			 request.setAttribute("List",l);
//		//	RequestDispatcher rd = request.getRequestDispatcher("./getstudentinfo.jsp");
//    		//rd.forward(request, response);
//    	
//			
//		        }
//        catch(Exception e){
//        System.out.println(e);
//        }
//       
//
//        
//        }
//	
//		
//		
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap) map;
	}
	
}
