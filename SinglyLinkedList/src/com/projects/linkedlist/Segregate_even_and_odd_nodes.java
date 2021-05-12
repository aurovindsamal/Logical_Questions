package com.projects.linkedlist;

/**
 * Input: 17->15->8->12->10->5->4->1->7->6->NULL
Output: 8->12->10->4->6->17->15->5->1->7->NULL
 * @author aurovind.samal
 *
 *
 *The idea is to split the linked list into two: one containing all even nodes and other containing all odd nodes. And finally attach the odd node linked list after the even node linked list.
To split the Linked List, traverse the original Linked List and move all odd nodes to a separate Linked List of all odd nodes. At the end of loop, the original list will have all the even nodes and the odd node list will have all the odd nodes. To keep the ordering of all nodes same, we must insert all the odd nodes at the end of the odd node list. And to do that in constant time, we must keep track of last pointer in the odd node list.


 */
//Java program to segregate even and odd nodes in a
//Linked List
import java.io.*;

public class Segregate_even_and_odd_nodes {
	
	Node head; // head of list

	/* Linked list Node*/
	class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	public void segregateEvenOdd() {
		
		Node evenStart = null;
		Node evenEnd = null;
		Node oddStart = null;
		Node oddEnd = null;
		Node currentNode = head;
		
		while(currentNode != null) {
			int element = currentNode.data;
			
			if(element % 2 == 0) {
				
				if(evenStart == null) {
					evenStart = currentNode;
					evenEnd = evenStart;
				} else {
					evenEnd.next = currentNode;
					evenEnd = evenEnd.next;
				}
				
			} else {
				
				if(oddStart == null) {
					oddStart = currentNode;
					oddEnd = oddStart;
				} else {
					oddEnd.next = currentNode;
					oddEnd = oddEnd.next;
				}
			}
						// Move head pointer one step in forward direction
			currentNode = currentNode.next;	
		}
		
		
		if(oddStart == null || evenStart == null) {
			return;
		}
		
		evenEnd.next = oddStart;
		oddEnd.next = null;
		head=evenStart;
	}
	
	/* Given a reference (pointer to pointer) to the head
		of a list and an int, push a new node on the front
		of the list. */
	void push(int new_data)
	{
		/* 1 & 2: Allocate the Node &
				Put in the data*/
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	// Utility function to print a linked list
	void printList()
	{
		Node temp = head;
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	/* Driver program to test above functions */
	public static void main(String args[])
	{
		Segregate_even_and_odd_nodes llist = new Segregate_even_and_odd_nodes();
		llist.push(11);
		llist.push(10);
		llist.push(9);
		llist.push(6);
		llist.push(4);
		llist.push(1);
		llist.push(0);
		System.out.println("Origional Linked List");
		llist.printList();

		llist.segregateEvenOdd();

		System.out.println("Modified Linked List");
		llist.printList();
	}
}

