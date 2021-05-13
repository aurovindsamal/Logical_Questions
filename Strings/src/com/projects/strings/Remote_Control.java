package com.projects.strings;

//Java program to print shortest possible path to
//type all characters of given string using a remote

/**
 Given a screen containing alphabets from A-Z, we can go from one character to another characters using a remote. The remote contains left, right, top and bottom keys.

Find shortest possible path to type all characters of given string using the remote. Initial position is top left and all characters of input string should be printed in order.

Screen:

A B C D E
F G H I J
K L M N O
P Q R S T
U V W X Y
Z
Example:

Input: “GEEK”
Output: 
Move Down
Move Right
Press OK
Move Up
Move Right
Move Right
Move Right
Press OK
Press OK
Move Left
Move Left
Move Left
Move Left
Move Down
Move Down
Press OK
 */
public class Remote_Control
{
	// Function to print shortest possible path to
	// type all characters of given string using a remote
	static void printPath(String str)
	{
		int i = 0;
		// start from character 'A' present at position (0, 0)
		int curX = 0, curY = 0;
		while (i < str.length())
		{
			// find cordinates of next character
			int nextX = (str.charAt(i) - 'A') / 5;
			int nextY = (str.charAt(i) - 'B' + 1) % 5;

			// Move Up if destination is above
			while (curX > nextX)
			{
				System.out.println("Move Up");
				curX--;
			}

			// Move Left if destination is to the left
			while (curY > nextY)
			{
				System.out.println("Move Left");
				curY--;
			}

			// Move down if destination is below
			while (curX < nextX)
			{
				System.out.println("Move Down");
				curX++;
			}

			// Move Right if destination is to the right
			while (curY < nextY)
			{
				System.out.println("Move Right");
				curY++;
			}

			// At this point, destination is reached
			System.out.println("Press OK");
			i++;
		}
	}
	
	// driver program
	public static void main (String[] args)
	{
		String str = "COZY";
		printPath(str);
	}
}

