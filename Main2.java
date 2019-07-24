package com.test.question;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		if(0<n&&n<=1000) {
			String s = sc.nextLine();
		    System.out.println(count(s,n));	
			
			
		}else if(n==0){
			System.out.println("W");
		}else {
			System.out.println("非法");
		}
		
	}
	
	public static String count(String srcStr,int n) {
		int countL = 0;
		int countR = 0;
		int index = 0;
		String count = "非法";
		
		if(srcStr.length()==n) {

			while ((index = srcStr.indexOf("L", index)) != -1) {
				index = index + "L".length();
				countL++;// 找到一次统计一次
				
	 
			}
			while ((index = srcStr.indexOf("R", index)) != -1) {
				index = index + "R".length();
				countR++;// 找到一次统计一次

				
			}

			if((countL+countR)==srcStr.length()) {
				count = getResult(countL-countR);
			}
		}
		return count;
	}
	public static String getResult(int n) {
		String result = "";
		if(n>=0) {
			switch (n%4) {
			case 0:
				result= "N";
				break;
			case 1:
				result= "W";
				break;
			case 2:
				result= "S";
				break;
			case 3:
				result= "E";
				break;
			}
		}else{
			n=-n;
			switch (n%4) {
			case 0:
				result= "N";
				break;
			case 1:
				result= "E";
				break;
			case 2:
				result= "S";
				break;
			case 3:
				result= "W";
				break;
			}
		}
		return result;
	}


}
