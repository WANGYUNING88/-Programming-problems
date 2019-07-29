package com.test.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int times = Integer.parseInt(br.readLine());
	        int []load = new int[times];
	        String []cons = new String[times];
	        for(int i=0;i<times;i++) {
	            load[i] = Integer.parseInt(br.readLine());
	            cons[i] = br.readLine();
	        }
	        for(int i=0;i<times;i++) {
	            System.out.println(getLight(cons[i]));
	        }
	}

	private static int getLight(String s) {
		// TODO Auto-generated method stub
		int light = 0;
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='.') {
				light++;
				i+=2;
			}
		}
		
		return light;
	}

}
