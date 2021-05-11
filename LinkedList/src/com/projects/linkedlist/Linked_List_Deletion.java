package com.projects.linkedlist;

//A complete working Java program
//to demonstrate deletion
//in singly linked list
public class Linked_List_Deletion {
	Node head; // head of list

	/* Linked list Node */
	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/*
	 * Given a key, deletes the first occurrence of key in linked list
	 */
	void deleteNode(int key) {
		// Store head node
		Node temp = head, prev = null;

		// If head node itself holds the key to be deleted
		if (temp != null && temp.data == key) {
			head = temp.next; // Changed head
			return;
		}

		// Search for the key to be deleted, keep track of
		// the previous node as we need to change temp.next
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}

		// If key was not present in linked list
		if (temp == null)
			return;

		// Unlink the node from linked list
		prev.next = temp.next;
	}

	/*
	 * Given a reference (pointer to pointer) to the head of a list and a position,
	 * deletes the node at the given position
	 */
	void deleteNodeAtPosition(int position) {
		// If linked list is empty
		if (head == null)
			return;

		// Store head node
		Node temp = head;

		// If head needs to be removed
		if (position == 0) {
			head = temp.next; // Change head
			return;
		}

		// Find previous node of the node to be deleted
		for (int i = 0; temp != null && i < position - 1; i++)
			temp = temp.next;

		// If position is more than number of nodes
		if (temp == null || temp.next == null)
			return;

		// Node temp->next is the node to be deleted
		// Store pointer to the next of node to be deleted
		Node next = temp.next.next;

		temp.next = next; // Unlink the deleted node from list
	}
	
	void deleteLastNode(Node head)
    {
		if (head == null)
			System.out.println("No Node Present");
		if (head.next == null) {
            System.out.println("Linked List contains one node");
        }
  
        // Find the second last node
        Node second_last = head;
        while (second_last.next.next != null)
            second_last = second_last.next;
  
        // Change next of second last
        second_last.next = null;
    }
	
	public void deleteFromStart() {
		Node tail = null;  
		if (head == null) {
			System.out.println("List is empty");
		} else {
			if (head != tail) {
				head = head.next;
			}
			// If the list contains only one node
			// then, it will remove it and both head and tail will point to null
			else {
				head = tail = null;
			}
		}
	}

	/* Inserts a new Node at front of the list. */
	public void push(int new_data) {
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

	/*
	 * This function prints contents of linked list starting from the given node
	 */
	public void printList() {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
	}

	/*
	 * Driver program to test above functions. Ideally this function should be in a
	 * separate user class. It is kept here to keep code compact
	 */
	public static void main(String[] args) {
		Linked_List_Deletion llist = new Linked_List_Deletion();

		llist.push(1);
		llist.push(2);
		llist.push(3);
		llist.push(4);
		llist.push(5);
		llist.push(6);
		llist.push(7);
		llist.push(8);
		llist.push(9);
		llist.push(10);
		llist.push(11);
		llist.push(12);

		System.out.println("\nCreated Linked list is:");
		llist.printList();

		llist.deleteNode(4); // Delete node with data 1

		System.out.println("\nLinked List after Deletion of 4:");
		llist.printList();
		
		llist.deleteNodeAtPosition(3);
		System.out.println("\nLinked List after Deletion of position 3:");
		llist.printList();
		
		llist.deleteLastNode(llist.head);
		System.out.println("\nLinked List after Deletion of last node:");
		llist.printList();
		
		llist.deleteFromStart();
		System.out.println("\nLinked List after Deletion of first node:");
		llist.printList();
		
	}
}
