package com.projects.strings;

/**
 Given a robot which can only move in four directions, UP(U), DOWN(D), LEFT(L), RIGHT(R). Given a string consisting of instructions to move. Output the coordinates of a robot after executing the instructions. Initial position of robot is at origin(0, 0).

Examples: 

Input : move = “UDDLRL” 
Output : (-1, -1)
Explanation:
Move U : (0, 0)–(0, 1)
Move D : (0, 1)–(0, 0)
Move D : (0, 0)–(0, -1)
Move L : (0, -1)–(-1, -1)
Move R : (-1, -1)–(0, -1)
Move L : (0, -1)–(-1, -1)
Therefore final position after the complete
movement is: (-1, -1)

Input : move = “UDDLLRUUUDUURUDDUULLDRRRR”
Output : (2, 3)
 */
//Java implementation to find final position
//of robot after the complete movement

import java.io.*;

public class Robot_movement {

	// function to find final position of
	// robot after the complete movement
	static void finalPosition(String move)
	{

		int l = move.length();
		int countUp = 0, countDown = 0;
		int countLeft = 0, countRight = 0;

		// traverse the instruction string
		// 'move'
		for (int i = 0; i < l; i++)
		{
			// for each movement increment
			// its respective counter
			if (move.charAt(i) == 'U')
				countUp++;

			else if (move.charAt(i) == 'D')
				countDown++;

			else if (move.charAt(i) == 'L')
				countLeft++;

			else if (move.charAt(i) == 'R')
				countRight++;
		}

		// required final position of robot
		System.out.println("Final Position: ("
						+ (countRight - countLeft) + ", "
						+ (countUp - countDown) + ")");
	}

	// Driver code
	public static void main(String[] args)
	{
		String move = "UDDLLRUUUDUURUDDUULLDRRRR";
		finalPosition(move);
	}
}

