package com.example.demomobilesecurity.utility;

public class ConstantValues {

	public ConstantValues() {
		// TODO Auto-generated constructor stub
	}
	
	public static final String PREFERENCE_NAME = "DEMO_MOBILE";
	public static final String USER_PASSWORD = "PASSWORD";
	public static final String FILE_SIZE = "FILE_SIZE";
	public static final String FILE_PREFIX  = "FILE_";
	
	public static String getFileOrder(int order) {
		return FILE_PREFIX.concat(String.valueOf(order));
	}
	

}
