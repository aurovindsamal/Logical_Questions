package com.projects.linkedlist;

import com.projects.linkedlist.Linked_List_Insertion.Node;

//Java program to find n'th node in linked list



public class Get_Nth_Node {
	Node head; // the head of list
	class Node {
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	/* Takes index as argument and return data at index*/
	public int GetNth(int index)
	{
		Node current = head;
		int count = 0; /* index of Node we are
						currently looking at */
		while (current != null)
		{
			if (count == index)
				return current.data;
			count++;
			current = current.next;
		}

		/* if we get to this line, the caller was asking
		for a non-existent element so we assert fail */
		assert (false);
		return 0;
	}

	/* Given a reference to the head of a list and an int,
	inserts a new Node on the front of the list. */
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

	/* Driver code*/
	public static void main(String[] args)
	{
		/* Start with empty list */
		Get_Nth_Node llist = new Get_Nth_Node();

		/* Use push() to construct below list
		1->12->1->4->1 */
		llist.push(1);
		llist.push(4);
		llist.push(1);
		llist.push(12);
		llist.push(1);

		/* Check the count function */
		System.out.println("The linked list elements are : ");
		llist.printList();
		System.out.println("\nElement at index 3 is " + llist.GetNth(3));
	}
}

