package com.projects.linkedlist;

//Java program to move all occurrences of a
//given key to end.
public class Move_all_occurrences_of_an_element_to_end_in_a_linked_list {

	// A Linked list Node
	static class Node {
		int data;
		Node next;
	}

	// A urility function to create a new node.
	static Node newNode(int x)
	{
		Node temp = new Node();
		temp.data = x;
		temp.next = null;
		return temp;
	}

	// Utility function to print the elements
	// in Linked list
	static void printList(Node head)
	{
		Node temp = head;
		while (temp != null) {
			System.out.printf("%d ", temp.data);
			temp = temp.next;
		}
		System.out.printf("\n");
	}

	// Moves all occurrences of given key to
	// end of linked list.
	static void moveToEnd(Node head, int key)
	{
		// Keeps track of locations where key
		// is present.
		Node pKey = head;

		// Traverse list
		Node pCrawl = head;
		while (pCrawl != null) {
			// If current pointer is not same as pointer
			// to a key location, then we must have found
			// a key in linked list. We swap data of pCrawl
			// and pKey and move pKey to next position.
			if (pCrawl != pKey && pCrawl.data != key) {
				pKey.data = pCrawl.data;
				pCrawl.data = key;
				pKey = pKey.next;
			}

			// Find next position where key is present
			if (pKey.data != key)
				pKey = pKey.next;

			// Moving to next Node
			pCrawl = pCrawl.next;
		}
	}

	// Driver code
	public static void main(String args[])
	{
		Node head = newNode(10);
		head.next = newNode(20);
		head.next.next = newNode(10);
		head.next.next.next = newNode(30);
		head.next.next.next.next = newNode(40);
		head.next.next.next.next.next = newNode(10);
		head.next.next.next.next.next.next = newNode(60);

		System.out.printf("Before moveToEnd(), the Linked list is\n");
		printList(head);

		int key = 10;
		moveToEnd(head, key);

		System.out.printf("\nAfter moveToEnd(), the Linked list is\n");
		printList(head);
	}
}

