package com.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.osms.model.CreditCardValidator;

public class TestCreditCard {
	@Test
	public void testCreditCardValidator() {
		String creditCardNumber = "1234 5678 9012 3456";
		String expiryDate = "1218";
		String name = "Tina Turner";
		
		StringBuilder error = new StringBuilder();
		assertTrue(CreditCardValidator.Validate(error, creditCardNumber, expiryDate, name));
		error.delete(0,error.length());
		
		assertFalse(CreditCardValidator.Validate(error, "", expiryDate, name));
		error.delete(0,error.length());
		
		assertFalse(CreditCardValidator.Validate(error, "1234 1234 123401234", expiryDate, name));
		error.delete(0,error.length());
		
		assertFalse(CreditCardValidator.Validate(error, "1234123412341234", expiryDate, name));
		error.delete(0,error.length());
		
		assertFalse(CreditCardValidator.Validate(error, "1234", expiryDate, name));
		error.delete(0,error.length());
		
		assertFalse(CreditCardValidator.Validate(error, "12345678901324567890123456790", expiryDate, name));
		error.delete(0,error.length());
		
		assertFalse(CreditCardValidator.Validate(error, creditCardNumber, "", name));
		error.delete(0,error.length());
		
		assertFalse(CreditCardValidator.Validate(error, creditCardNumber, "123456", name));
		error.delete(0,error.length());
		
		assertFalse(CreditCardValidator.Validate(error, creditCardNumber, "1313", name));
		error.delete(0,error.length());
		
		assertFalse(CreditCardValidator.Validate(error, creditCardNumber, "1010", name));
		error.delete(0,error.length());
		
		assertFalse(CreditCardValidator.Validate(error, creditCardNumber, "115", name));
		error.delete(0,error.length());
		
		//this is only true if today's date is before Jan 2015
		assertTrue(CreditCardValidator.Validate(error, creditCardNumber, "0115", name));
		error.delete(0,error.length());
		
		assertFalse(CreditCardValidator.Validate(error, creditCardNumber, expiryDate, ""));
		error.delete(0,error.length());
	}
}
