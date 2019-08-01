package com.test.question;

public class ReverseEqual {
	public static boolean checkReverseEqual(String s1, String s2) {
        if(s1.length()!=s2.length())
        	return false;
        int[] hash1 = new int[256];
        int[] hash2 = new int[256];
        
        for(int i=0; i<s1.length();i++) {
        	hash1[s1.charAt(i)]++;
        	hash2[s2.charAt(i)]++;
        }
        for(int i=0;i<256;i++) {
        	if(hash1[i]!=hash2[i])
        		return false;
        }
        return true;
    }
	public static void main(String[] args) {
		System.out.println(checkReverseEqual("waterbottle","erbottlewat"));
	}
}
