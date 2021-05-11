package com.projects.linkedlist;

import com.projects.linkedlist.Get_Nth_Node.Node;

//Simple Java program to find n'th node from end of linked list
public class Get_Nth_Node_from_end {
	Node head; // head of the list

	/* Linked List node */
	class Node {
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	/* Function to get the nth node from the last of a
	linked list */
	void printNthFromLast(int n)
	{
		int len = 0;
		Node temp = head;

		// 1) count the number of nodes in Linked List
		while (temp != null) {
			temp = temp.next;
			len++;
		}

		// check if value of n is not more than length of
		// the linked list
		if (len < n)
			return;

		temp = head;

		// 2) get the (len-n+1)th node from the beginning
		for (int i = 1; i < len - n + 1; i++)
			temp = temp.next;

		System.out.println(temp.data);
	}

	/* Inserts a new Node at front of the list. */
	public void push(int new_data)
	{

		/* 1. Allocate the Node &
		2. Put in the data
		3. Set next as null */
		Node new_node = new Node(new_data);

		/* 4. If the Linked List is empty, then make the
			new node as head */
		if (head == null)
		{
			head = new Node(new_data);
			return;
		}

		/* 4. This new node is going to be the last node, so
			make next of it as null */
		new_node.next = null;

		/* 5. Else traverse till the last node */
		Node last = head;
		while (last.next != null)
			last = last.next;

		/* 6. Change the next of last node */
		last.next = new_node;
		return;
	}
	
	public void printList()
	{
		Node tnode = head;
		while (tnode != null)
		{
			System.out.print(tnode.data+" ");
			tnode = tnode.next;
		}
	}

	/*Driver program to test above methods */
	public static void main(String[] args)
	{
		Get_Nth_Node_from_end llist = new Get_Nth_Node_from_end();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(35);
		llist.push(36);
		llist.push(38);
		llist.push(51);

		llist.printList();
		System.out.println("\nThe element from last 4 is : ");
		llist.printNthFromLast(4);
	}
} // This code is contributed by Rajat Mishra

