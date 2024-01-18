package com.java.assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    
    public static int charSearch(String str,char ch){
    	int outputFreq=0;
    	int[] charFreq=new int[str.length()];
    	char[] covertChar=str.toCharArray();
    	
    	for(int i=0;i<str.length();i++) {
    		charFreq[i]=1;
    		for(int j=i+1;j<str.length();j++) {
    			if(covertChar[i]==covertChar[j]) {
    				charFreq[i]++;
    				covertChar[j]='0';
    			}
    		}
    	}
    	for(int i=0;i<charFreq.length;i++) {
    		if(charFreq[i] != ' ' && charFreq[i] != '0') {
    		if(covertChar[i]==ch) {
    			outputFreq=charFreq[i];
    		}
    		}
    		
            
    	}
        return outputFreq;
    }

public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        char ch = (char)reader.read();
       
        System.out.println(charSearch(str,ch));
        
        

    }
}