package com.osms.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userName = request.getParameter("userget");
		System.out.println("My name is :" + userName);

		try {
			// Class.forName("com.mysql.jdbc.Driver");
			// Connection con=
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/School",
			// "root", "");

			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from student where StudentName='"
							+ userName + "'");
			System.out.println("rs is :" + rs);
			if (rs.next()) {
				session.setAttribute("StudentName", rs.getString("StudentName"));
				session.setAttribute("FatherName", rs.getString("FatherName"));
				session.setAttribute("StuClass", rs.getString("StuClass"));
				session.setAttribute("Section", rs.getString("Section"));
				System.out.println(rs.getString("StudentName"));
				RequestDispatcher rd = request
						.getRequestDispatcher("./studentDetails.jsp");
				rd.forward(request, response);
				con.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
