package com.test.question;

import java.util.Scanner;

public class Main6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		if(a.length()==1) {
			System.out.println(1);
		}else {
			System.out.println(getNum(a));
		}
		
		
		
	
	}
	public static int getNum(String s) {
		int result = 1;
		char[] sChar = s.toCharArray();
		for(int i=0;i<sChar.length-1;i++) {
			int shi =Integer.parseInt(String.valueOf(sChar[i]));
			System.out.println(shi);
			int ge = Integer.parseInt(String.valueOf(sChar[i+1]));
			System.out.println(ge);
			if(shi<=2&&ge<=6) {
				result = result+1;
			}
		}
		return result;
	}
	
	
}
