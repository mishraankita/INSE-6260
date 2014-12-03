package com.osms.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.osms.model.CourseRegistration;

/**
 * Servlet implementation class CourseRegistrationServlet
 */
public class CourseRegistrationServlet extends ActionSupport implements SessionAware,ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> sessionMap;
	HttpServletResponse response;
    
	
	public void registerCourse() {
		List<String> rowItems = new ArrayList<String>();

		CourseRegistration coursesRegistration = new CourseRegistration();
		// Iterate through courseOffed table and addCourseOffered
		// THIS MUST BE DONE BEFORE LOADING courseTaken
		try {
			String userID = (String) sessionMap.get("UserID");
			
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select DepartmentID from studentdetails where UserID = " + userID);
			int departmentID = 0;
			if(rs.next())
				departmentID = rs.getInt("DepartmentID");
			
			rs = stmt.executeQuery("select * from courseoffered where DepartmentID = " + departmentID);

			while (rs.next()) {
				coursesRegistration.addCourseOffered(rs.getInt("CourseID"),
						rs.getString("CourseName"), rs.getInt("DepartmentID"),
						rs.getString("Schedule"),
						rs.getString("SessionOffered"),
						rs.getInt("PreRequisiteCourseID"),
						rs.getInt("CapacityOfStudent"));
			}

			//Determine if Add/Drop deadline has passed
			String addDropDeadline = null;
			rs = stmt.executeQuery("Select AddDropDeadline from courseoffered where CourseID = 0");
			if(rs.next()){
				addDropDeadline = rs.getString("AddDropDeadline");
			}
			// deadline is in format dd/MM/yyyy
			SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
			Date addDropDeadlineDate = new Date();
			try {
				addDropDeadlineDate = ft.parse(addDropDeadline);
			} catch (ParseException e) {
				//use current date/time
			}
			boolean registrationClosed = addDropDeadlineDate.before(new Date());
			String registrationCloseText = null;
			if(registrationClosed) registrationCloseText = " is Closed";

			// Iterate through coursetaken table and addCourseTaken
			// This will use information loaded in courseOffered
			rs = stmt.executeQuery("select * from coursetaken where UserID='"
					+ userID + "'");
			while (rs.next()) {
				coursesRegistration.addCourseTaken(rs.getInt("CourseID"),
						rs.getString("GradesObtained"));
			}

			// Build list/table
			coursesRegistration.buildRegistrationList(rowItems);

			PrintWriter out = getServletResponse().getWriter();
			out.println("<html><body>"
					+ "<form action=\"./studentsuccess.jsp\" method=POST >"
					+ "<input type=\"submit\"  name=\"submit\" value=\"Return\" /></form>"
					+ "<form action=\"./CourseChangeStudentServlet\" method=POST>"
					+ "<h1 align=center ><font color=blue>Course Registration"
					+ registrationCloseText
					+ "</font></h1>"
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
				if (!registrationClosed)
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
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpServletResponse getServletResponse() {
		return this.response;
	}	
}
