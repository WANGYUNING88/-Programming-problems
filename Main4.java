package com.test.question;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] inputArray =
				input.substring(1,input.length()-1).replaceAll("\"","").split(",");
		
		System.out.println(getMax(inputArray));
	}
	
	public  static int getMax(String[] array){
		int max = 0;
		if(array.length>=2) {
			for(int i = 0;i<array.length-1;i++) {
				for(int j=i+1;j<array.length;j++) {
					max = Math.max(max, getNum(array[i], array[j]));
				}
			}
		}
		return max;
		
	}
	public static int getNum(String a, String b) {
		char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
		
		for(int i =0;i<a.length();i++) {
			for(int j =0;j<b.length();j++) {
				if(arrayA[i]==arrayB[j]) {
					return 0;
				}
			}
		}
		System.out.println(a+"和"+b+"的乘积是："+a.length()*b.length());
		return a.length()*b.length();
	}

}
