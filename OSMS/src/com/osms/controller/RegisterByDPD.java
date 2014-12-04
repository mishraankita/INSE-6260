package com.osms.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.osms.model.CourseRegistrationByDPD;

/**
 * Servlet implementation class CourseRegistrationServlet
 */
public class RegisterByDPD extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> sessionMap;
	HttpServletResponse response;
	HttpServletRequest request;
	
	public void registerByDPD() {
		List<String> rowItems = new ArrayList<String>();

		CourseRegistrationByDPD coursesRegistrationByDPD = new CourseRegistrationByDPD();
		// Iterate through courseOffed table and addCourseOffered
		// THIS MUST BE DONE BEFORE LOADING courseTaken
		try {
			//String userID = (String) sessionMap.get("userID");
			//to get value of the searched student and not the dpd
			String userID = request.getParameter("userID");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + userID);
			
			String studentUserID = "";
			if(userID!=null){
				System.out.println("userID is second call inside first if " + userID);
				sessionMap.put("studentUserID", userID);
			}
			
			studentUserID = (String) sessionMap.get("studentUserID");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + studentUserID);
			if(userID == null){
				userID = (String) sessionMap.get("studentUserID");
				System.out.println("studentID in second call inside second if" + studentUserID);
			}
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			
//			ResultSet rs = stmt.executeQuery("select DepartmentID from studentdetails where UserID = " + userID);
//			int departmentID = 0;
//			if(rs.next())
//				departmentID = rs.getInt("DepartmentID");
			
			ResultSet rs = stmt
					.executeQuery("select * from studentdetails where UserID='"
							+ userID + "'");
			
			if(!rs.next()){
				request.setAttribute("resultsMessage", "Record not found! Please enter valid Student Id !");
				RequestDispatcher rd = request.getRequestDispatcher("./RegistrationByDpd.jsp");
	    		rd.forward(request, response);
	    		con.close();
			}
			
			
			rs = stmt.executeQuery("select * from courseoffered;");

			while (rs.next()) {
				coursesRegistrationByDPD.addCourseOffered(rs.getInt("CourseID"),
						rs.getString("CourseName"), rs.getInt("DepartmentID"),
						rs.getString("Schedule"),
						rs.getString("SessionOffered"),
						rs.getInt("PreRequisiteCourseID"),
						rs.getInt("CapacityOfStudent"));
			}

			// Iterate through coursetaken table and addCourseTaken
			// This will use information loaded in courseOffered
			rs = stmt.executeQuery("select * from coursetaken where UserID='"
					+ userID + "'");
			while (rs.next()) {
				coursesRegistrationByDPD.addCourseTaken(rs.getInt("CourseID"),
						rs.getString("GradesObtained"));
			}

			// Build list/table
			coursesRegistrationByDPD.buildRegistrationList(rowItems);

			PrintWriter out = getServletResponse().getWriter();
			out.println("<html><body><form action=\"./CourseChangeStudentServletByDPD\" method=POST>"
					+ "<h1 align=center ><font color=blue>Course Registration</font></h1>"
					+ "<a href=\"./dpdsuccess.jsp\">Return</a>"
					+ "<br><table border =1 align=center >"
					+ "<tr><th>Selection</th><th>Course Name</th><th>Schedule</th></tr>");

			for (ListIterator<String> iter = rowItems.listIterator(); iter
					.hasNext();) {
				String rowItem = iter.next();
				String delimiter = "[$]";
				String[] tokens = rowItem.split(delimiter);
				if (tokens.length < 4)// error, expecting 4 items: buttonLabel,
										// courseName, courseSchedule, courseID
					continue;
				String activeState = "disabled";
				if (tokens[0].equals("Add") || tokens[0].equals("Drop"))
					activeState = "enabled";

				String name = tokens[0] + "$" + tokens[3] + "$" + userID;
				String row = "<tr><td><input name= \"" + name
						+ "\" type=\"submit\" value="
						+ tokens[0] + " " + activeState + "></td><td>"
						+ tokens[1] + "</td><td>" + tokens[2] + "</td></tr>"; 
				out.println(row);
			}

			out.println("</table border=3 ></form></body></html>");
			out.println("<br/><br/>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap) map;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletRequest getServletRequest() {
		return this.request;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpServletResponse getServletResponse() {
		return this.response;
	}
}

