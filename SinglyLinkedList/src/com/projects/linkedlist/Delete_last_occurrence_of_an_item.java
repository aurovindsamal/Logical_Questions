package com.projects.linkedlist;

//Java program to demonstrate deletion of last
//Node in singly linked list
public class Delete_last_occurrence_of_an_item {

//A linked list Node
	static class Node {
		int data;
		Node next;
	};

//Function to delete the last occurrence
	static void deleteLast(Node head, int x) {
		Node temp = head, ptr = null;
		while (temp != null) {

			// If found key, update
			if (temp.data == x)
				ptr = temp;
			temp = temp.next;
		}

		// If the last occurrence is the last node
		if (ptr != null && ptr.next == null) {
			temp = head;
			while (temp.next != ptr)
				temp = temp.next;
			temp.next = null;
		}

		// If it is not the last node
		if (ptr != null && ptr.next != null) {
			ptr.data = ptr.next.data;
			temp = ptr.next;
			ptr.next = ptr.next.next;
			System.gc();
		}
	}

	/*
	 * Utility function to create a new node with given key
	 */
	static Node newNode(int x) {
		Node node = new Node();
		node.data = x;
		node.next = null;
		return node;
	}

//This function prints contents of linked list
//starting from the given Node
	static void display(Node head) {
		Node temp = head;
		if (head == null) {
			System.out.print("null\n");
			return;
		}
		while (temp != null) {
			System.out.printf("%d --> ", temp.data);
			temp = temp.next;
		}
		System.out.print("null\n");
	}

	/* Driver code */
	public static void main(String[] args) {
		Node head = newNode(1);
		head.next = newNode(2);
		head.next.next = newNode(3);
		head.next.next.next = newNode(4);
		head.next.next.next.next = newNode(5);
		head.next.next.next.next.next = newNode(4);
		head.next.next.next.next.next.next = newNode(4);
		System.out.print("Created Linked list: ");
		display(head);
		deleteLast(head, 4);
		System.out.print("List after deletion of 4: ");
		display(head);
	}
}

/* This code is contributed by PrinciRaj1992 */
//Java program to demonstrate deletion of last
//Node in singly linked list
class GFG {

//A linked list Node
	static class Node {
		int data;
		Node next;
	};

//Function to delete the last occurrence
	static void deleteLast(Node head, int x) {
		Node temp = head, ptr = null;
		while (temp != null) {

			// If found key, update
			if (temp.data == x)
				ptr = temp;
			temp = temp.next;
		}

		// If the last occurrence is the last node
		if (ptr != null && ptr.next == null) {
			temp = head;
			while (temp.next != ptr)
				temp = temp.next;
			temp.next = null;
		}

		// If it is not the last node
		if (ptr != null && ptr.next != null) {
			ptr.data = ptr.next.data;
			temp = ptr.next;
			ptr.next = ptr.next.next;
			System.gc();
		}
	}

	/*
	 * Utility function to create a new node with given key
	 */
	static Node newNode(int x) {
		Node node = new Node();
		node.data = x;
		node.next = null;
		return node;
	}

//This function prints contents of linked list
//starting from the given Node
	static void display(Node head) {
		Node temp = head;
		if (head == null) {
			System.out.print("null\n");
			return;
		}
		while (temp != null) {
			System.out.printf("%d --> ", temp.data);
			temp = temp.next;
		}
		System.out.print("null\n");
	}

	/* Driver code */
	public static void main(String[] args) {
		Node head = newNode(1);
		head.next = newNode(2);
		head.next.next = newNode(3);
		head.next.next.next = newNode(4);
		head.next.next.next.next = newNode(5);
		head.next.next.next.next.next = newNode(4);
		head.next.next.next.next.next.next = newNode(4);
		System.out.print("Created Linked list: ");
		display(head);
		deleteLast(head, 4);
		System.out.print("List after deletion of 4: ");
		display(head);
	}
}
