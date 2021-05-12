package com.projects.linkedlist;

/**
 * Input : 23->28->28->35->49->49->53->53 Output : 23->35
 * 
 * Input : 11->11->11->11->75->75 Output : empty List
 */
//Java program to remove all occurrences of
//duplicates from a sorted linked list

//class to create Linked lIst
public class Remove_all_occurences_of_elements_in_sorted_Linked_list {

	Node head = null;

	class Node {
		int val;
		Node next;

		Node(int v) {
			val = v;
			next = null;
		}
	}

	public void insert(int data) {
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}

	public void removeAllDuplicates() {

		Node dummy = new Node(0);

		// Dummy node points to the original head
		dummy.next = head;
		Node prev = dummy;
		Node current = head;

		while (current != null) {
			// Until the current and previous values
			// are same, keep updating current
			while (current.next != null && prev.next.val == current.next.val)
				current = current.next;

			if (prev.next == current)
				prev = prev.next;

			else
				prev.next = current.next;

			current = current.next;
		}

		head = dummy.next;
	}

//Function to print the list elements
	public void printList() {
		Node trav = head;
		if (head == null)
			System.out.print(" List is empty");

		while (trav != null) {
			System.out.print(trav.val + " ");
			trav = trav.next;
		}
	}

//Driver code
	public static void main(String[] args) {
		Remove_all_occurences_of_elements_in_sorted_Linked_list ll = new Remove_all_occurences_of_elements_in_sorted_Linked_list();
		ll.insert(53);
		ll.insert(53);
		ll.insert(49);
		ll.insert(49);
		ll.insert(35);
		ll.insert(28);
		ll.insert(28);
		ll.insert(23);

		System.out.println("Before removal of duplicates");
		ll.printList();

		ll.removeAllDuplicates();

		System.out.println("\nAfter removal of duplicates");
		ll.printList();
	}
}
