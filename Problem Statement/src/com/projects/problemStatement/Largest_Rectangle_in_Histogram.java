package com.projects.problemStatement;

import java.util.Stack;

/**
 * 
 * @author aurovind.samal Above is a histogram where width of each bar is 1,
 *         given height = [2,1,5,6,2,3].
 */
public class Largest_Rectangle_in_Histogram {

	public static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int i = 0;

		while (i < height.length) {
			// push index to stack when the current height is larger than the previous one
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				// calculate max value when the current height is less than the previous one
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}
		}
		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int arr[] = {2,1,5,6,2,3};
		int result = largestRectangleArea(arr);
		System.out.println("The area is :" +result);
	}

}
