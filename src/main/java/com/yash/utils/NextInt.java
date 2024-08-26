package com.yash.utils;

public class NextInt {
	public static int idCount = 0; 
	
	public static int getNextInt() {
		idCount++;
		System.out.println("Inside getNextInt with int as: " + idCount);
		return idCount;
	}
}
