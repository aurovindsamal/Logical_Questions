package com.projects.linkedlist;

/**
 * 
 * @author aurovind.samal Input : 11 -> 20 -> 40 -> 55 -> 77 -> 80 -> NULL
 *         Output : 11 -> 20 -> 55 -> 40 -> 77 -> 80 -> NULL 20, 40, 80 occur in
 *         even positions and 11, 55, 77 occur in odd positions.
 * 
 *         Input : 10 -> 1 -> 2 -> 3 -> 5 -> 6 -> 7 -> 8 -> NULL Output : 1 ->
 *         10 -> 3 -> 2 -> 5 -> 6 -> 7 -> 8 -> NULL 1, 3, 5, 7 occur in odd
 *         positions and 10, 2, 6, 8 occur at even positions in the list
 *
 */
//Java program to rearrange nodes
//as alternate odd even nodes in
//a Singly Linked List
public class Alternate_Odd_and_Even_Nodes {

//Structure node
	static class Node {
		int data;
		Node next;
	};

//A utility function to print
//linked list
	static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

//Function to create newNode
//in a linkedlist
	static Node newNode(int key) {
		Node temp = new Node();
		temp.data = key;
		temp.next = null;
		return temp;
	}

//Function to insert at beginning
	static Node insertBeg(Node head, int val) {
		Node temp = newNode(val);
		temp.next = head;
		head = temp;
		return head;
	}

//Function to rearrange the
//odd and even nodes
	static Node rearrange(Node head) {
		// Step 1: Segregate even and odd nodes
		// Step 2: Split odd and even lists
		// Step 3: Merge even list into odd list
		Node even;
		Node temp, prev_temp;
		Node i, j, k, l, ptr = null;

		// Step 1: Segregate Odd and Even Nodes
		temp = (head).next;
		prev_temp = head;

		while (temp != null) {

			// Backup next pointer of temp
			Node x = temp.next;

			// If temp is odd move the node
			// to beginning of list
			if (temp.data % 2 != 0) {
				prev_temp.next = x;
				temp.next = (head);
				(head) = temp;
			} else {
				prev_temp = temp;
			}

			// Advance Temp Pointer
			temp = x;
		}

		// Step 2
		// Split the List into Odd and even
		temp = (head).next;
		prev_temp = (head);

		while (temp != null && temp.data % 2 != 0) {
			prev_temp = temp;
			temp = temp.next;
		}

		even = temp;

		// End the odd List (Make last node null)
		prev_temp.next = null;

		// Step 3:
		// Merge Even List into odd
		i = head;
		j = even;

		while (j != null && i != null) {

			// While both lists are not
			// exhausted Backup next
			// pointers of i and j
			k = i.next;
			l = j.next;

			i.next = j;
			j.next = k;

			// ptr points to the latest node added
			ptr = j;

			// Advance i and j pointers
			i = k;
			j = l;
		}

		if (i == null) {

			// Odd list exhausts before even,
			// append remainder of even list to odd.
			ptr.next = j;
		}

		// The case where even list exhausts before
		// odd list is automatically handled since we
		// merge the even list into the odd list
		return head;
	}

//Driver Code
	public static void main(String args[]) {
		Node head = newNode(8);
		head = insertBeg(head, 7);
		head = insertBeg(head, 6);
		head = insertBeg(head, 3);
		head = insertBeg(head, 5);
		head = insertBeg(head, 1);
		head = insertBeg(head, 2);
		head = insertBeg(head, 10);

		System.out.println("Linked List:");
		printList(head);
		System.out.println("Rearranged List");
		head = rearrange(head);
		printList(head);
	}
}
