package com.test.question;
import java.util.*;

public class Replacement {
    public static String replaceSpace(String iniString, int length) {
    	String [] str =new String[length]; 
        for(int i=0;i<length;i++) {
        	if(iniString.charAt(i)==32) 
        		str[i]  = "%20";
        	else
        		str[i]= String.valueOf(iniString.charAt(i));
        }
        String s = "";
        for(int i=0;i<length;i++)
        	s+=str[i];
        return s;
    }
    public static void main(String[] args) {
		System.out.println(replaceSpace("q w",3));
	}
}