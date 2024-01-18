package com.java.assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FrequencyOfDigits {
	public static void Frequency(int strInput1, int str) {
		int mainInput = strInput1;
		int[] digitCount = new int[10];
		while (mainInput != 0) {
			// Get the lastDigit of inputNumber
			int lastDigit = mainInput % 10;
			// incrementing the lastDigit's count

			digitCount[lastDigit]++;

			// Removing the lastDigit from inputNumber
			mainInput = mainInput / 10;
		}
		for (int i = 0; i < digitCount.length; i++) {
			if (digitCount[i] != 0 && i == str) {
				System.out.println(i + ": " + digitCount[i]);
			} else if (digitCount[i] != 0 && str == 0) {
				System.out.println(i + ": " + digitCount[i]);
			}
		}
	}

	public static void main(String[] args) throws IOException,NumberFormatException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int firstNum = 0, secondNum = 0;
		boolean numeric = true;
		boolean numeric2 = true;
		String strfirstNum = null;
		String inputStr = null;
		String in=reader.readLine();
		String[] inputNumbers=in.split(",");
		if (inputNumbers.length>1) {
		 strfirstNum = inputNumbers[0];
		 inputStr = inputNumbers[1];
		}else {
			 strfirstNum = inputNumbers[0];
			 inputStr = "0";
		}
		
		numeric = strfirstNum.matches("-?\\d+(\\.\\d+)?");
		numeric2 = inputStr.matches("-?\\d+(\\.\\d+)?");

		if (strfirstNum.isEmpty() ) {
		
		}else if(inputStr.isEmpty()==false && numeric2==false ) {
			
		}else if(inputStr.isEmpty() && numeric==true ) {
			firstNum = Integer.valueOf(strfirstNum);
			secondNum = 0;
			Frequency(firstNum, secondNum);
		} else if (numeric==true && numeric2==true) {
			firstNum = Integer.valueOf(strfirstNum);
			secondNum = Integer.valueOf(inputStr);
			Frequency(firstNum, secondNum);
		}

		reader.close();
		System.exit(0);
	}

}
