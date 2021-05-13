package com.projects.strings;

//Java program to reverse a string using recursion

public class Reverse
{
	/* Function to print reverse of the passed string */
	void reverse(String str)
	{
		if ((str==null)||(str.length() <= 1))
		System.out.println(str);
		else
		{
			System.out.print(str.charAt(str.length()-1));
			reverse(str.substring(0,str.length()-1));
		}
	}
	
	static void reverseStr(String str)
    {
     int n = str.length();
     char []ch = str.toCharArray();
     char temp;
 
     // Swap character starting from two
     // corners
     for (int i=0, j=n-1; i<j; i++,j--)
     {
         temp = ch[i];
         ch[i] = ch[j];
         ch[j] = temp;
     }
         
      
     System.out.println(ch);
    }
	
	/* Driver program to test above function */
	public static void main(String[] args)
	{
		String str = "Geeks for Geeks";
		Reverse obj = new Reverse();
		obj.reverse(str);
	}	
}
