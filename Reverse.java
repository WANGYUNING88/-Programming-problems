package com.test.question;
import java.util.*;

public class Reverse {
    public String reverseString(String iniString) {
        String reverse = "";
        for(int i =iniString.length()-1;i>=0;i--) {
        	reverse+=String.valueOf(iniString.charAt(i));
        }
        return reverse;
    }
}