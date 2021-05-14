package com.projects.arrays;

public class Unique_Elements {
	
	public static void main(String[] args) {
		
		int[] a = { 7, 7, 8, 8, 9, 1, 1, 4, 2, 2 };
			int	i = 1, m = 9;
		if (a[0] == a[m - 1]) {
	        i = 2;
	        m = m - 1;
	    }
	    else
	        System.out.println(+a[m-1]); // For cases like { 7, 7, 8, 8, 9, 1, 1, 4, 2, 3 }, a[] = { 7, 7, 8, 8, 9, 1, 1, 4, 4, 2 }
	    for (; i < m; i++)
	        if (a[i] == a[i - 1])
	            i++;
	        else
	            System.out.println(a[i - 1]);

	}

}
