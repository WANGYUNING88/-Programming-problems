package com.test.question;
import java.util.*;

public class Different {
    public boolean checkDifferent(String iniString) {
        // write code here
    	boolean result = false;
    	char[] s = iniString.toCharArray();
    	for(int i =iniString.length()-1;i>0;i--) {
    		if(iniString.substring(0, i).indexOf(s[i])>0)
    			return result;
    	}
    	
    	result = true;
    	
    	return result;
    }
}