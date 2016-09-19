package com.room.sample.view.Test;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import com.room.sample.view.ValidateInput;

public class ValidateInputTest {

	ValidateInput validateInput;
	@Before
	public void setup(){
		validateInput = new ValidateInput();
	}
	
	@Test
	public void testCorrectEmailId() {
		String email = "abc@xyz.com";
		Assert.assertEquals(true,validateInput.ValidateEmail(email));
	}
	
	@Test
	public void testInCorrectEmailId() {
		String email = "abcxyz.com";
		Assert.assertEquals(false,validateInput.ValidateEmail(email));
	}
	@Test
	public void testInCorrectMobile() {
		String mobile = "abcxyz";
		Assert.assertEquals(false,validateInput.ValidateMobile(mobile));
	}
	@Test
	public void testCorrectMobile() {
		String mobile = "1234567890";
		Assert.assertEquals(true,validateInput.ValidateMobile(mobile));
	}
	
}

