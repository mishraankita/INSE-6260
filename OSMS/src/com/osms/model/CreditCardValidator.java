package com.osms.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditCardValidator {
	private String cardNumber;
	private String expiryDate;
	private String name;
	
	public CreditCardValidator(String cardNumber, String expiryDate, String name) {
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.name = name;
	}

	public boolean Validate(StringBuilder error) {
		String pattern = "\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}";
		if (!cardNumber.matches(pattern)) {
			error.append("Error in credit card number");
			return false;
		}

		pattern = "\\d{4}";
		if (!expiryDate.matches(pattern)) {
			error.append("Error in expiry date");
			return false;
		}

		int month = Integer.parseInt(expiryDate.substring(0, 2));
		int year = Integer.parseInt(expiryDate.substring(2));
		if (month < 0 || month > 12 || year < 14 || year > 20) {
			error.append("Error in expiry date");
			return false;
		}

		Date now = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String textDate = "20" + year + "-" + month + "-01";
		Date cardExpiryDate;
		try {
			cardExpiryDate = ft.parse(textDate);
		} catch (ParseException e) {
			error.append("Error in expiry date");
			return false;
		}

		if (now.after(cardExpiryDate)) {
			error.append("Card has expired");
			return false;
		}

		if (name == null || name.isEmpty()) {
			error.append("Error in cardholder name");
			return false;
		}

		return true;
	}
}
