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

/**
 * Servlet implementation class FeePayment
 */
public class FeePaymentServlet extends ActionSupport implements SessionAware,
		ServletRequestAware {

	private static final long serialVersionUID = 1L;
	final int PAID = 0;
	final int DUE = 1;
	final int UNKNOWN = 2;
	int paymentStatus = UNKNOWN;
	private SessionMap<String, Object> sessionMap;
	private HttpServletRequest httpServletRequest;

	/**
	 * payfees TODO
	 */
	public String payFees() {
		String userID = (String) sessionMap.get("UserID");
		String message = "Connection failed. Please try again later";

		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("select PaymentFeeDeadLine from feepayment where UserID = 0");
			String paymentDeadline = null;
			if (rs.next())
				paymentDeadline = rs.getString("PaymentFeeDeadLine");

			rs = stmt
					.executeQuery("select PaymentAmount from feepayment where UserID = "
							+ userID);
			int amountAlreadyPaid = 0;
			if (rs.next())
				amountAlreadyPaid = rs.getInt("PaymentAmount");

			if (amountAlreadyPaid >= 5000) {
				message = "Fees are paid in full";
				paymentStatus = PAID;
			} else {
				Date deadline = new Date();
				// deadline is in format dd/MM/yyyy
				SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
				boolean parsePassed = false;
				try {
					deadline = ft.parse(paymentDeadline);
					parsePassed = true;
				} catch (ParseException e) {
					message = "Unable to determine payment deadline";
					paymentStatus = UNKNOWN;
				}

				if (parsePassed) {
					Date now = new Date();
					if (now.before(deadline)) {
						message = "Total fees are 5,000.00";
						paymentStatus = DUE;
					} else {
						message = "Payment deadline was "
								+ deadline.toString()
								+ " Total fees are 5,000.00 plus 75.00 late fee";
						paymentStatus = DUE;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			paymentStatus = UNKNOWN;
		}
		httpServletRequest.setAttribute("resultsMessage", message);
		httpServletRequest.setAttribute("paymentStatus", paymentStatus);
		return "feePayment";
	}

	public void setSession(Map<String, Object> arg0) {
		this.sessionMap=(SessionMap<String, Object>) arg0;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.httpServletRequest = arg0;
	}
}
