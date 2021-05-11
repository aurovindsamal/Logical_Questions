package com.project.stack;

//Java Code for Linked List Implementation

public class Implement_Stack_Using_LinkedList {

	StackNode head;

	static class StackNode {
		int data;
		StackNode next;

		StackNode(int data) { this.data = data; }
	}

	public boolean isEmpty()
	{
		if (head == null) {
			return true;
		}
		else
			return false;
	}

	public void push(int data)
	{
		StackNode newNode = new StackNode(data);

		if (head == null) {
			head = newNode;
		}
		else {
			StackNode temp = head;
			head = newNode;
			newNode.next = temp;
		}
		System.out.println(data + " pushed to stack");
	}

	public int pop()
	{
		int popped = Integer.MIN_VALUE;
		if (head == null) {
			System.out.println("Stack is Empty");
		}
		else {
			popped = head.data;
			head = head.next;
		}
		return popped;
	}

	public int peek()
	{
		if (head == null) {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		else {
			return head.data;
		}
	}
	
	public void displayList() {
		StackNode sn = head;
		if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
		System.out.println("\nThe elements are");
		while (sn != null) {
			System.out.print(sn.data + " ");
			sn = sn.next;
		}
	}

	// Driver code
	public static void main(String[] args)
	{

		Implement_Stack_Using_LinkedList sll = new Implement_Stack_Using_LinkedList();

		sll.push(10);
		sll.push(20);
		sll.push(30);
		sll.push(40);
		sll.push(50);
		System.out.println(sll.pop() + " popped from stack");
        System.out.println("Top element is " + sll.peek());
        sll.displayList();
        
	}
}
