package com.projects.linkedlist;

//Java program to count occurrences in a linked list
public class count_the_number_of_times_a_given_element_occurs {
	Node head; // head of list
	static int frequency = 0;
	/* Linked list Node*/
	class Node {
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

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

	/* Counts the no. of occurrences of a node
	(search_for) in a linked list (head)*/
	int count(int search_for)
	{
		Node current = head;
		int count = 0;
		while (current != null) {
			if (current.data == search_for)
				count++;
			current = current.next;
		}
		return count;
	}

	/* Counts the no. of occurrences of a node using recursion
    (search_for) in a linked list (head)*/
    static int countRecursive(Node head, int key)
    {
        if (head == null)
            return frequency;
        if (head.data == key)
            frequency++;
        return countRecursive(head.next, key);
    }
    
	/* Driver function to test the above methods */
	public static void main(String args[])
	{
		count_the_number_of_times_a_given_element_occurs llist = new count_the_number_of_times_a_given_element_occurs();

		/* Use push() to construct below list
		1->2->1->3->1 */
		llist.push(1);
		llist.push(2);
		llist.push(1);
		llist.push(3);
		llist.push(1);
		llist.push(2);
		llist.push(2);
		llist.push(2);
		llist.push(2);

		/*Checking count function*/
		System.out.println("Count of 1 is " + llist.count(1));
		
		System.out.println("Count of 2 is " + count_the_number_of_times_a_given_element_occurs.countRecursive(llist.head,2));

	}
}
