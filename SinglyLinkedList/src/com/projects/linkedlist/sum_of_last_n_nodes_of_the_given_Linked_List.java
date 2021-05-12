package com.projects.linkedlist;

/**
 Input : 10->6->8->4->12, n = 2
Output : 16
Sum of last two nodes:
12 + 4 = 16

Input : 15->7->9->5->16->14, n = 4
Output : 44
 */
//Java implementation to find the sum of last
//'n' nodes of the Linked List
import java.util.*;

public class sum_of_last_n_nodes_of_the_given_Linked_List {

	/* A Linked list node */
	static class Node {
		int data;
		Node next;
	};

	static Node head;

//function to insert a node at the
//beginning of the linked list
	static void push(Node head_ref, int new_data) {
		/* allocate node */
		Node new_node = new Node();

		/* put in the data */
		new_node.data = new_data;

		/* link the old list to the new node */
		new_node.next = head_ref;

		/* move the head to point to the new node */
		head_ref = new_node;
		head = head_ref;
	}

	static void reverseList(Node head_ref) {
		Node current, prev, next;
		current = head_ref;
		prev = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		head_ref = prev;
		head = head_ref;
	}

//utility function to find the sum of last 'n' nodes
	static int sumOfLastN_NodesUtil(int n) {
		// if n == 0
		if (n <= 0)
			return 0;

		// reverse the linked list
		reverseList(head);

		int sum = 0;
		Node current = head;

		// traverse the 1st 'n' nodes of the reversed
		// linked list and add them
		while (current != null && n-- > 0) {

			// accumulate node's data to 'sum'
			sum += current.data;

			// move to next node
			current = current.next;
		}

		// reverse back the linked list
		reverseList(head);

		// required sum
		return sum;
	}

//Driver code
	public static void main(String[] args) {

		// create linked list 10.6.8.4.12
		push(head, 12);
		push(head, 4);
		push(head, 8);
		push(head, 6);
		push(head, 10);

		int n = 2;
		System.out.println("Sum of last " + n + " nodes = " + sumOfLastN_NodesUtil(n));
	}
}
