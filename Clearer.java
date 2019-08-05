package com.test.question;

import java.util.HashSet;
import java.util.Set;

public class Clearer {
	 public int[][] clearZero(int[][] mat, int n) {
	       int[][] newMat = new int[n][n];
	       newMat = mat.clone();
	       Set<Integer> hang = new HashSet<Integer>();
	       Set<Integer> lie = new HashSet<Integer>();
	       for(int i=0;i<n;i++) {
	    	   for(int j=0;j<n;j++) {
	    		   if(mat[i][j]==0) {
	    			   hang.add(i);
	    			   lie.add(j);
	    		   }
		    	   
		       }
	       }
	       if(hang.size()==0&&lie.size()==0) {
	    	   return mat;
	       }else {
	    	   for(int i:hang) {
	    		   for(int j = 0;j<n;j++) {
	    			   newMat[i][j]=0;
	    		   }
	    	   }
	    	   for(int i:lie) {
	    		   for(int j = 0;j<n;j++) {
	    			   newMat[j][i]=0;
	    		   }
	    	   }
	       }
	       return newMat;
	 }
}
