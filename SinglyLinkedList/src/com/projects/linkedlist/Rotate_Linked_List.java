package com.projects.linkedlist;

/**
 For example, if the given linked list is 10->20->30->40->50->60 and k is 4, 
 the list should be modified to 50->60->10->20->30->40. Assume that k is smaller than the count of nodes in linked list.
 */
//Java program to rotate
//a linked list counter clock wise

public class Rotate_Linked_List {

	/* Link list node */
	static class Node {

		int data;
		Node next;
	};

	static Node head = null;

//This function rotates a linked list
//counter-clockwise and updates the
//head. The function assumes that k is
//smaller than size of linked list.
	static void rotate(int k) {
		if (k == 0)
			return;

		// Let us understand the below
		// code for example k = 4 and
		// list = 10.20.30.40.50.60.
		Node current = head;

		// Traverse till the end.
		while (current.next != null)
			current = current.next;

		current.next = head;
		current = head;

		// traverse the linked list to k-1 position which
		// will be last element for rotated array.
		for (int i = 0; i < k - 1; i++)
			current = current.next;

		// update the head_ref and last element pointer to null
		head = current.next;
		current.next = null;
	}
	
	
	//another approcah
	// This function rotates a linked list counter-clockwise
    // and updates the head. The function assumes that k is
    // smaller than size of linked list. It doesn't modify
    // the list if k is greater than or equal to size
    void rotateAnother(int k)
    {
        if (k == 0)
            return;
 
        // Let us understand the below code for example k = 4
        // and list = 10->20->30->40->50->60.
        Node current = head;
 
        // current will either point to kth or NULL after this
        // loop. current will point to node 40 in the above example
        int count = 1;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }
 
        // If current is NULL, k is greater than or equal to count
        // of nodes in linked list. Don't change the list in this case
        if (current == null)
            return;
 
        // current points to kth node. Store it in a variable.
        // kthNode points to node 40 in the above example
        Node kthNode = current;
 
        // current will point to last node after this loop
        // current will point to node 60 in the above example
        while (current.next != null)
            current = current.next;
 
        // Change next of last node to previous head
        // Next of 60 is now changed to node 10
 
        current.next = head;
 
        // Change head to (k+1)th node
        // head is now changed to node 50
        head = kthNode.next;
 
        // change next of kth node to null
        kthNode.next = null;
    }

	/* UTILITY FUNCTIONS */
	/* Function to push a node */
	static void push(int new_data) {

		/* allocate node */
		Node new_node = new Node();

		/* put in the data */
		new_node.data = new_data;

		/* link the old list off the new node */
		new_node.next = head;

		/* move the head to point to the new node */
		head = new_node;
	}

	/* Function to print linked list */
	static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	/* Driver code */
	public static void main(String[] args) {
		/* Start with the empty list */

		// create a list 10.20.30.40.50.60
		for (int i = 60; i > 0; i -= 10)
			push(i);

		System.out.print("Given linked list \n");
		printList(head);
		rotate(4);

		System.out.print("\nRotated Linked list \n");
		printList(head);
	}
}
