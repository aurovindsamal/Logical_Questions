package com.projects.linkedlist;

//Java program to delete alternate nodes of a linked list
public class Delete_alternate_nodes
{
	Node head; // head of list

	/* Linked list Node*/
	class Node
	{
		int data;
		Node next;
		Node(int d) {data = d; next = null; }
	}

	void deleteAlt()
	{
	if (head == null)
		return;

	Node prev = head;
	Node now = head.next;

	while (prev != null && now != null)
	{		
		/* Change next link of previous node */
		prev.next = now.next;

		/* Free node */
		now = null;

		/*Update prev and now */
		prev = prev.next;
		if (prev != null)
			now = prev.next;
	}
	}				

					
	/* Utility functions */

	/* Inserts a new Node at front of the list. */
	public void push(int new_data)
	{
		/* 1 & 2: Allocate the Node &
				Put in the data*/
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	/* Function to print linked list */
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
		Delete_alternate_nodes llist = new Delete_alternate_nodes();
		
		/* Constructed Linked List is 1->2->3->4->5->null */
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);
		
		System.out.println("Linked List before calling deleteAlt() ");
		llist.printList();
		
		llist.deleteAlt();
		
		System.out.println("Linked List after calling deleteAlt() ");
		llist.printList();
	}
}
