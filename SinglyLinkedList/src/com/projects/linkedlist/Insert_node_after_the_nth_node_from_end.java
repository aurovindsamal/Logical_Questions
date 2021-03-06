package com.projects.linkedlist;

/**
 * Input : list: 1->3->4->5 n = 4, x = 2 Output : 1->2->3->4->5 4th node from
 * the end is 1 and insertion has been done after this node.
 * 
 * Input : list: 10->8->3->12->5->18 n = 2, x = 11 Output :
 * 10->8->3->12->5->11->18
 */
//Java implementation to
//insert a node after the
//nth node from the end
public class Insert_node_after_the_nth_node_from_end {

//structure of a node
	static class Node {
		int data;
		Node next;
	}

//function to get a new node
	static Node getNode(int data) {
		// allocate memory for the node
		Node newNode = new Node();

		// put in the data
		newNode.data = data;
		newNode.next = null;
		return newNode;
	}

//function to insert a node after
//the nth node from the end
	static void insertAfterNthNode(Node head, int n, int x) {
		// if list is empty
		if (head == null)
			return;

		// get a new node for the value 'x'
		Node newNode = getNode(x);

		// Initializing the slow
		// and fast pointers
		Node slow_ptr = head;
		Node fast_ptr = head;

		// move 'fast_ptr' to point to the
		// nth node from the beginning
		for (int i = 1; i <= n - 1; i++)
			fast_ptr = fast_ptr.next;

		// iterate until 'fast_ptr' points
		// to the last node
		while (fast_ptr.next != null) {

			// move both the pointers to the
			// respective next nodes
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next;
		}

		// insert the 'newNode' by making the
		// necessary adjustment in the links
		newNode.next = slow_ptr.next;
		slow_ptr.next = newNode;
	}

//function to print the list
	static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

//Driver code
	public static void main(String[] args) {
		// Creating list 1->3->4->5
		Node head = getNode(1);
		head.next = getNode(3);
		head.next.next = getNode(4);
		head.next.next.next = getNode(5);

		int n = 4, x = 2;
		System.out.println("Original Linked List: ");
		printList(head);

		insertAfterNthNode(head, n, x);
		System.out.println();
		System.out.println("Linked List After Insertion: ");
		printList(head);
	}
}
