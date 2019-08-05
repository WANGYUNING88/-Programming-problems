package com.test.question;
import java.util.*;

public class Zipper {
    public static  String zipString(String iniString) {
    	
    	String result = "";
    	for(int i =0;i<iniString.length();i++) {
    		int count = 1;
    		int j=i;
    		while(j<iniString.length()-1&&iniString.charAt(j)==iniString.charAt(j+1)) {
    			count++;
    			j++;
    		}
    		result=result+(char)iniString.charAt(i)+count;
    		i=j;
    	}
    	
    	return iniString.length() > result.length() ? result :iniString;
    	
    	
    	
    	
    	
//    	 int count=0;
//         StringBuilder sb=new StringBuilder();
//         char c=iniString.charAt(0);
//         for(int i=0;i<iniString.length();i++){
//             if(c==iniString.charAt(i)){
//                 count++;
//             }else{
//                 sb.append(c);
//                 sb.append(count);
//                 c=iniString.charAt(i);
//                 count=1;
//  
//             }
//  
//         }
//                     sb.append(c);
//             sb.append(count);
//         String str=sb.toString();
//         return str.length()<iniString.length()?str:iniString;
    }
    public static void main(String[] args) {
		//System.out.println(zipString("jjjjjjxxxxxxxooZLLLLLLLLQQQQQQQQQLLLLLLLLECXXXXXXXIIIIIIIIIhjjyyySSooooooooommmuuEEEEEEEEEnnnnnnnffffffAAAAAllllllllbbbbkkkkkkkkkkkkKKKKKKhhhhhhhhhooooooooooYCCCCCCOOOOOOOOOMMMMMMMMMMiiiiiivvvvvvvWWWWkkkkkkwwwwwwwMmmmmmmmmLLLwwwwwwwkkkjjjjjjttttQQQQQQQQQaaaaaaaFFFFFFFlllllllllggggggggggPPPPPPuuuuuuuuaYYYYYYwQQQFFFFFFFFFFaaaaapXXXXXXXxxxxxxQQQQQQQQQsssssGGGGfffffffddddddpppQQQQQQHHHTTTaaaaaaGGGGGGddyyyyyMhhllllllllllNNNNNNNNUUUWWWWWWLLLLLLLLLYYYYYYYYYYTTKKKKKKKKiiiiiiitttttttXXXXXXXXXLLLHZZZZZZZssssjjJJJEEEEEOOOOOttttttttttBBttttttTTTTTTTTTTrrrrttttRRRRRyyooooooaaaaaaaaarrrrrrrPPPPPPPjjPPPPddddddddddHHHHnnnnnnnnnnSSSSSSSSSSzzHHHHHHHHHddddddDDDzzzhhhhhfffffffffftttttteeeeeeeeEEEEEEEEEaaaaaaccccccccccFFFFFFFF"));
    	System.out.println(zipString("welcometonowcoderrrrr"));
    	System.out.println(zipString("abcdefg"));
    }
}