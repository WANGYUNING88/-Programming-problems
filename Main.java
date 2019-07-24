package com.test.question;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int l = s.nextInt();
		int r = s.nextInt();
		System.out.println(getCount(getArray(l, r)));
	}
	
	@SuppressWarnings("null")
	public static int[] getArray(int a, int b) {
		
		if(a>b||a<1)
			return null;
		else {
			int[] result = new int[b-a+1] ;
			String arrStr = "";
			for(int i= 1;i<a;i++) {
				arrStr+=i;
			}
			int index = 0;
			int value = 0;
			for(int i=a;i<=b;i++) {
				arrStr=arrStr + i;
				//System.out.println(arrStr);
				value = Integer.valueOf(arrStr.trim()).intValue();
				result[index] = value;
				index++;
			}
			
			return result;
		}
		
	}
	
	public static int getCount(int[] a) {
		if(a==null)
			return 0;
		else {
			int count = 0;
			for(int i:a) {
				if(i%3==0) {
					count++;
					System.out.println(i);
				}
				
			}
			return count;
		}
	}

}
