package com.projects.linkedlist;

/**
 * 
 * @author aurovind.samal 
 * Input: a: 5->10->15->40 b: 2->3->20 
 * Output: 
 * res: 40->20->15->10->5->3->2
 * 
 */
//Java program to merge two sorted linked list such that merged
//list is in reverse order

//Linked List Class
public class Merge_two_sorted_linked_lists_and_Display_In_Reverse_Order {

	Node head; // head of list
	static Node a, b;

	/* Node Class */
	static class Node {

		int data;
		Node next;

		// Constructor to create a new node
		Node(int d) {
			data = d;
			next = null;
		}
	}

	void printlist(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	Node sortedmerge(Node node1, Node node2) {
		
		// if both the nodes are null
		if (node1 == null && node2 == null) {
			return null;
		}

		// resultant node
		Node res = null;

		// if both of them have nodes present traverse them
		while (node1 != null && node2 != null) {

			// Now compare both nodes current data
			if (node1.data <= node2.data) {
				Node temp = node1.next;
				node1.next = res;
				res = node1;
				node1 = temp;
			} else {
				Node temp = node2.next;
				node2.next = res;
				res = node2;
				node2 = temp;
			}
		}

		// If second list reached end, but first list has
		// nodes. Add remaining nodes of first list at the
		// front of result list
		while (node1 != null) {
			Node temp = node1.next;
			node1.next = res;
			res = node1;
			node1 = temp;
		}

		// If first list reached end, but second list has
		// node. Add remaining nodes of first list at the
		// front of result list
		while (node2 != null) {
			Node temp = node2.next;
			node2.next = res;
			res = node2;
			node2 = temp;
		}

		return res;

	}

	public static void main(String[] args) {

		Merge_two_sorted_linked_lists_and_Display_In_Reverse_Order list = new Merge_two_sorted_linked_lists_and_Display_In_Reverse_Order();
		Node result = null;

		/*Let us create two sorted linked lists to test
		the above functions. Created lists shall be
		a: 5->10->15
		b: 2->3->20*/
		list.a = new Node(5);
		list.a.next = new Node(10);
		list.a.next.next = new Node(15);

		list.b = new Node(2);
		list.b.next = new Node(3);
		list.b.next.next = new Node(20);

		System.out.println("List a before merge :");
		list.printlist(a);
		System.out.println("");
		System.out.println("List b before merge :");
		list.printlist(b);

		result = list.sortedmerge(a, b);
		System.out.println("");
		System.out.println("Merged linked list : ");
		list.printlist(result);

	}
}
