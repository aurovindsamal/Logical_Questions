package com.projects.problemStatement;

public class Add_digits {
	
	//Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

			public int addDigits(int num) {
			    return num - 9*((num-1)/9);
			}

			//2nd Approach
			public int addDigitssecond(int num) {
			    int sum=0;
			 
			    String s = String.valueOf(num);
			    for(int i=0; i<s.length(); i++){
			        sum = sum + (s.charAt(i)-'0');
			    }
			 
			    if(sum < 10){
			        return sum;
			    }else{
			        return addDigits(sum);
			    }
			}

}
