package com.project.stack;

/*package whatever //do not write package name here */
import java.util.ArrayList;

public class Customized_DataStructure {

// class Pair
	static class Pair {
		int element;
		int minElement;

		public Pair(int element, int minElement) {
			this.element = element;
			this.minElement = minElement;
		}
	}

	int min;
	ArrayList<Pair> stack = new ArrayList<>();

	public Customized_DataStructure() {
		this.min = Integer.MAX_VALUE;
	}

// utility function for adding a new element
	void addElement(int x) {
		if (stack.size() == 0 || x < min) {
			min = x;
		}
		Pair pair = new Pair(x, min);
		stack.add(pair);
		System.out.println(x + " inserted successfully");
	}

// utility function for returning last element of stack
	int getLastElement() {
		if (stack.size() == 0) {
			System.out.println("UnderFlow Error");
			return -1;
		} else {
			return stack.get(stack.size() - 1).element;
		}
	}

// utility function for removing last element successfully;
	void removeLastElement() {

		if (stack.size() == 0) {
			System.out.println("UnderFlow Error");
		} else if (stack.size() > 1) {
			min = stack.get(stack.size() - 2).minElement;
		} else {
			min = Integer.MAX_VALUE;
		}
		stack.remove(stack.size() - 1);
		System.out.println("removed successfully");
	}

// utility function for returning min element till now;
	int getMin() {
		if (stack.size() == 0) {
			System.out.println("UnderFlow Error");
			return -1;
		}
		return stack.get(stack.size() - 1).minElement;
	}

// Driver Code
	public static void main(String[] args) {
		Customized_DataStructure newStack = new Customized_DataStructure();
		newStack.addElement(5);
		newStack.addElement(7);
		newStack.addElement(3);
		System.out.println("min element :: " + newStack.getMin());
		newStack.removeLastElement();
		newStack.addElement(2);
		newStack.addElement(9);
		System.out.println("last element :: " + newStack.getLastElement());
		newStack.addElement(0);
		System.out.println("min element :: " + newStack.getMin());
		newStack.removeLastElement();
		newStack.addElement(11);
		System.out.println("min element :: " + newStack.getMin());
	}
}

