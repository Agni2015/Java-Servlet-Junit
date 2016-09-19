package com.room.sample.view;

public class ValidateInput {
 // all the validations can be done using JQuery , this is just for JUnit understanding.
	public String ValidatePage(String email,String mobile)
	{
		String status = "Success";
		if (!ValidateEmail(email))
		{
			status = " Bad Email Id!!! ";
		} 
		
		if(!ValidateMobile(mobile))
		{
			status = " Mobile Number Invalid!!! ";
		} 
		
		
		return status;
	}
	
	public Boolean ValidateEmail(String email)
	{
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(EMAIL_REGEX);
	}
		
	public Boolean ValidateMobile(String mobile)
	{
		if(mobile.matches("\\d{10}"))
		{
			return true;
		}else {
			return false;
		}
	}
}
