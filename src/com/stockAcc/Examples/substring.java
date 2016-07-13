package com.stockAcc.Examples;

import java.util.Scanner;

public class substring {

	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String original=sc.next();
		
		System.out.println(original);
		System.out.println(original.length());
		
		String result= original.substring(1, 6);
		

		System.out.println(result);
	}

}
