package com.projects.problemStatement;

import java.util.HashMap;

/**
 Design and implement a TwoSum class. It should support the following operations: add and find.
add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.
 */
public class Two_Sum_Find {
	
		private HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();
	 
		public void add(int number) {
			if (elements.containsKey(number)) {
				elements.put(number, elements.get(number) + 1);
			} else {
				elements.put(number, 1);
			}
		}
	 
		public boolean find(int value) {
			for (Integer i : elements.keySet()) {
				int target = value - i;
				if (elements.containsKey(target)) {
					if (i == target && elements.get(target) < 2) {
						continue;
					}
					return true;
				}
			}
			return false;
		}

	public static void main(String[] args) {
		
		
	}

}
