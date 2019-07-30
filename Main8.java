package com.test.question;

import java.util.Scanner;

public class Main8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n = sc.nextInt();
		String[] s = getString(str,n);
		if(s==null||n<0)
			System.out.println(-1);
		else {
			for(int i=0;i<s.length;i++)
				System.out.println(s[i]);
		}
	}

	private static String[] getString(String str, int n) {
		// TODO Auto-generated method stub
		String[] result = null ;
		if(str.length()>=n) {
			result = new String[str.length()-n+1];
			for(int i=0;i<=str.length()-n;i++) {
				result[i] = substring(str, i, i+n-1);
			}
		}
		return result;
	}
	static String substring(String str ,int begin ,int end) {
		String result ="";
		char[] s = str.toCharArray();
		for(int i = begin;i<=end;i++) {
			result=result+s[i];

		}
		//System.out.println(result);
		return result;
		
	}
}
