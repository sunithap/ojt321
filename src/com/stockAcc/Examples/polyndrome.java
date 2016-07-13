package com.stockAcc.Examples;


import java.util.Scanner;

public class polyndrome {
	public static void main(String[] args) {
		String rev="";
		Scanner sc=new Scanner(System.in);
		String original=sc.next();
		System.out.println(original.length());
		int len=original.length();
		
		for (int i = len-1; i >=0; i--)
		{
			rev=rev+original.charAt(i);
			
		}
		
		System.out.println(rev);
		
		if (original.equals(rev))
		{
			System.out.println("Given number/string is polyndrome");
		}
		else
		{
			System.out.println("Given number/string is not a polyndrome");
		}

	}

}
