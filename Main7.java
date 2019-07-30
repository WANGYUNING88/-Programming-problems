package com.test.question;

import java.util.Scanner;

public class Main7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int[][] clockTime = new int[N][2];
		for(int i = 0;i<N;i++) {
			clockTime[i][0]=sc.nextInt();
			clockTime[i][1]=sc.nextInt();
			sc.nextLine();
		}
		int time = sc.nextInt();
		sc.nextLine();
		int[] arriveTime = new int[2];
		arriveTime[0] = sc.nextInt();
		arriveTime[1] = sc.nextInt();
		int[] latestClockTime = getClockTime(getLastTime(time, arriveTime), clockTime);
		System.out.println(latestClockTime[0]+" "+latestClockTime[1]);
//		int[] t = getLastTime(time, arriveTime);
//		System.out.println(t[0]+" "+t[1]);
	}
	static int[] getLastTime (int time ,int[] arriveTime) {
		int a = time/60;
		int b = time%60;
		if(arriveTime[1]>=b) {
			arriveTime[1] = arriveTime[1]-b;
			arriveTime[0] = arriveTime[0]-a;
		}else {
			arriveTime[0] = arriveTime[0]-1-a;
			arriveTime[1] = 60+arriveTime[1]-b;
		}
		return arriveTime;
	}
	static int[] getClockTime(int[] lastTime,int[][] clockTime) {
		int[] latestClockTime = new int[2];
		for(int i =0;i<clockTime.length;i++) {
			
			if(lastTime[0]>clockTime[i][0]||
					(lastTime[0]==clockTime[i][0]&&lastTime[1]>=clockTime[i][1])){
				latestClockTime = max(latestClockTime, clockTime[i]);
			}
			
		}
		return latestClockTime;
	}
	static int[] max(int[] a,int[] b) {
		if(a[0]>b[0]||(a[0]==b[0]&&a[1]>=b[1])) {
			return a;
		}else {
			return b;
		}
	}

}
