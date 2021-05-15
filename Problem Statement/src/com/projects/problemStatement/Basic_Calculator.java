package com.projects.problemStatement;

import java.util.ArrayList;
import java.util.Stack;

public class Basic_Calculator {
	
	public int calculatefirst(String s) {
		// delte white spaces
		s = s.replaceAll(" ", "");
	 
		Stack<String> stack = new Stack<String>();
		char[] arr = s.toCharArray();
	 
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ')
				continue;
	 
			if (arr[i] >= '0' && arr[i] <= '9') {
				sb.append(arr[i]);
	 
				if (i == arr.length - 1) {
					stack.push(sb.toString());
				}
			} else {
				if (sb.length() > 0) {
					stack.push(sb.toString());
					sb = new StringBuilder();
				}
	 
				if (arr[i] != ')') {
					stack.push(new String(new char[] { arr[i] }));
				} else {
					// when meet ')', pop and calculate
					ArrayList<String> t = new ArrayList<String>();
					while (!stack.isEmpty()) {
						String top = stack.pop();
						if (top.equals("(")) {
							break;
						} else {
							t.add(0, top);
						}
					}
	 
					int temp = 0;
					if (t.size() == 1) {
						temp = Integer.valueOf(t.get(0));
					} else {
						for (int j = t.size() - 1; j > 0; j = j - 2) {
							if (t.get(j - 1).equals("-")) {
								temp += 0 - Integer.valueOf(t.get(j));
							} else {
								temp += Integer.valueOf(t.get(j));
							}
						}
						temp += Integer.valueOf(t.get(0));
					}
					stack.push(String.valueOf(temp));
				}
			}
		}
	 
		ArrayList<String> t = new ArrayList<String>();
		while (!stack.isEmpty()) {
			String elem = stack.pop();
			t.add(0, elem);
		}
	 
		int temp = 0;
		for (int i = t.size() - 1; i > 0; i = i - 2) {
			if (t.get(i - 1).equals("-")) {
				temp += 0 - Integer.valueOf(t.get(i));
			} else {
				temp += Integer.valueOf(t.get(i));
			}
		}
		temp += Integer.valueOf(t.get(0));
	 
		return temp;
	}

	//2nd Approach
	public int calculate(String s) {
	    int md=-1; // 0 is m, 1 is d
	    int sign=1; // 1 is +, -1 is -
	    int prev=0;
	    int result=0;
	 
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	        if(Character.isDigit(c)){
	            int num = c-'0';
	            while(++i<s.length() && Character.isDigit(s.charAt(i))){
	                num = num*10+s.charAt(i)-'0';
	            }
	            i--; // back to last digit of number
	 
	            if(md==0){
	                prev = prev * num;
	                md=-1;
	            }else if(md==1){
	                prev = prev / num;
	                md=-1;
	            }else{
	                prev = num;
	            }
	        }else if(c=='/'){
	            md=1;
	        }else if(c=='*'){
	            md=0;
	        }else if(c=='+'){
	            result = result + sign*prev;
	            sign=1;
	        }else if(c=='-'){
	            result = result + sign*prev;
	            sign=-1;
	        }
	    }
	    result = result + sign*prev;
	    return result;
	}


}
