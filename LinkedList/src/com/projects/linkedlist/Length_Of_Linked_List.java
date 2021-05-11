package com.projects.linkedlist;

//Java program to count number of nodes in a linked list

/* Linked list Node*/
class Node
{
	int data;
	Node next;
	Node(int d) { data = d; next = null; }
}

//Linked List class
public class Length_Of_Linked_List
{
	Node head; // head of list

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

	/* Returns count of nodes in linked list */
	public int getCount()
	{
		Node temp = head;
		int count = 0;
		while (temp != null)
		{
			count++;
			temp = temp.next;
		}
		return count;
	}
	
    /* Returns count of nodes in linked list */
    public int getCountRecursive(Node node)
    {
        // Base case
        if (node == null)
            return 0;
  
        // Count is this node plus rest of the list
        return 1 + getCountRecursive(node.next);
    }
  
    /* Wrapper over getCountRec() */
    public int getCountRec()
    {
        return getCountRecursive(head);
    }

	/* Driver program to test above functions. Ideally
	this function should be in a separate user class.
	It is kept here to keep code compact */
	public static void main(String[] args)
	{
		/* Start with the empty list */
		Length_Of_Linked_List llist = new Length_Of_Linked_List();
		llist.push(1);
		llist.push(3);
		llist.push(1);
		llist.push(2);
		llist.push(1);

		System.out.println("Count of nodes is " + llist.getCount());
		System.out.println("Count of nodes in recursive is " + llist.getCountRecursive(llist.head));
	}
}

