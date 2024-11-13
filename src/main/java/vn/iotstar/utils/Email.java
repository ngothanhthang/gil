package vn.iotstar.utils;

import java.util.Random;

import vn.iotstar.models.UserModel;
public class Email {

	public String getRandom()
	{
		Random rnd=new Random();
		int number =rnd.nextInt(999999);
		return String.format("%06d",number);
	}
	/*
	 * public boolean sendEmail(UserModel user) { boolean test=false; return test;
	 * 
	 * 
	 * }
	 */
}
