package com.osms.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.osms.domain.User;
import com.osms.model.CreditCardValidator;

/**
 * Servlet implementation class FeePaymentOutcome
 */
public class FeePaymentOutcomeServlet extends ActionSupport implements SessionAware,ServletRequestAware {

	
	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> sessionMap;
	private HttpServletRequest httpServletRequest;


	public String payFeesOutcome() {
		//HttpSession session = request.getSession();
		String userID = (String) sessionMap.get("UserID");
		
		String creditCardNumber = httpServletRequest.getParameter("creditcardnumber");
		String expiryMonthYear = httpServletRequest.getParameter("expirymonthyear");
		String cardHolderName = httpServletRequest.getParameter("cardholdername");
		
		StringBuilder error = new StringBuilder();
		if (!CreditCardValidator.Validate(error, creditCardNumber,
				expiryMonthYear, cardHolderName)) {
			httpServletRequest.setAttribute("resultsMessage", error.toString());
			return "feePaymentOutcome";
		}

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

			if (now.compareTo(paymentDeadline)<0)
				amountPaid = "5075";
			
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
		
		//RequestDispatcher rd = request
			//	.getRequestDispatcher("./feePaymentOutcome.jsp");
		httpServletRequest.setAttribute("resultsMessage", message);
		//rd.forward(request, response);
		return "feePaymentOutcome";
	}

	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
		
	}
	public void setServletRequest(HttpServletRequest arg0) {
		this.httpServletRequest = arg0;
	}

}
