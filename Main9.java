package com.test.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ram = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		int[] word = new int[n];
		for(int i =0;i<n;i++) {
			word[i] = sc.nextInt();
		}
		System.out.println(getCount(m,ram,word));
	}

	private static int getCount(int m, List<Integer> ram, int[] word) {
		int count =0;

		for(int i=0;i<word.length;i++) {
			
			if(!ram.contains(word[i])) {
				if(m>ram.size())
					ram.add(word[i]);
				else {
					ram.set(count%m, word[i]);
				}
				
				count++;
			}
		}
		return count;

	}

}
