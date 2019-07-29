package com.test.question;

import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if(a<=10&&a>=1&&b<=10&&b>=1&&c<=10&&c>=1) {
			int max = 0;
			int mid = 0;
			int min = 0;
			max=Math.max(Math.max(a, b),c);
			min=Math.min(Math.min(a, b),c);
			mid = getMid(a, b, c);
			System.out.println(Math.max(max*(min+mid), a*b*c));
			
		}
		
		
	
	}
	public static int getMid(int a,int b,int c) {
		if((a>=b&&b>=c)||(c>=b&&b>=a))
			return b;
		if((b>=a&&a>=c)||(c>=a&&a>=b))
			return a;
		if((a>=c&&c>=b)||(b>=c&&c>=a))
			return c;
		return 0;
	}
	
	
}
