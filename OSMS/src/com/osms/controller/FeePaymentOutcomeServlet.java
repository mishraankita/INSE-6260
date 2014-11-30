package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FeePaymentOutcome
 */
public class FeePaymentOutcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeePaymentOutcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userID");
		
		String message = "Connection failed. Please try again later";

		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs;
			
			//We need UserID PaymentDate PaymentAmount PaymentFeeDeadLine
			SimpleDateFormat ft = 
				      new SimpleDateFormat ("dd/MM/yyyy");
			String now = ft.format(new Date());

			String amountPaid = "5000";

			rs = stmt
					.executeQuery("select PaymentFeeDeadLine from feepayment where UserID = 0");

			String paymentDeadline = null;
			if (rs.next())
				paymentDeadline = rs.getString("PaymentFeeDeadLine");

			boolean recordExists = false;
			rs = stmt
					.executeQuery("select * from feepayment where UserID = " + userID);
			if (rs.next())
				recordExists= true;

			if (userID == null || userID.equals("0")) {
				message = "Payment request error";
			} else {
				String sqlStatement = null;
				if (recordExists) {
					sqlStatement = "UPDATE feepayment SET PaymentDate = \""
							+ now + "\",PaymentAmount=" + amountPaid
							+ ",PaymentFeeDeadLine=\"" + paymentDeadline
							+ "\" WHERE UserID = " + userID + ";";
				} else {
					sqlStatement = "INSERT INTO feepayment VALUES (" + userID
							+ ",\"" + now + "\"," + amountPaid + ",\""
							+ paymentDeadline + "\");";
				}
				stmt.executeUpdate(sqlStatement);
				message = "Payment made in full";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request
				.getRequestDispatcher("./feePaymentOutcome.jsp");
		request.setAttribute("resultsMessage", message);
		rd.forward(request, response);
	}

}
