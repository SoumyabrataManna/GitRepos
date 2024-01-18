package com.java.assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HashmapSearch {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int maxHash = Integer.valueOf(reader.readLine());
		int i = 0;
		boolean numeric = true;
		HashMap<Integer, String> employeeHash = new HashMap<Integer, String>();
		while (i < maxHash) {
			String in = reader.readLine();
			String[] inputNumbers = in.split(" ");
			if (inputNumbers.length > 1) {
				employeeHash.put(Integer.valueOf(inputNumbers[0]), inputNumbers[1]);
			} else {
				inputNumbers = null;
			}
			i++;
		}
		String findValue = reader.readLine();

		numeric = findValue.matches("-?\\d+(\\.\\d+)?");

		if (numeric == true && employeeHash.containsKey(Integer.parseInt(findValue))) {
			System.out.println(employeeHash.get(Integer.parseInt(findValue)));
		} else if (numeric == false && employeeHash.containsValue(findValue)) {
			for (Map.Entry m : employeeHash.entrySet()) {
				if (m.getValue().equals(findValue)) {
					System.out.println(m.getKey());
				}
			}
		} else {
			System.out.println("-1");
		}

	}

}
