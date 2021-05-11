package com.project.stack;

class Stack {
	static final int MAX = 1000;
	int top;
	int arr[] = new int[MAX]; // Maximum size of Stack

	Stack()
	{
		top = -1;
	}
	boolean isEmpty()
	{
		return (top < 0);
	}
	
   boolean push(int x)
	{
		if (top >= (MAX - 1)) {
			System.out.println("Stack Overflow");
			return false;
		}
		else {
			arr[++top] = x;
			System.out.println(x + " pushed into stack");
			return true;
		}
	}

	int pop()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x = arr[top--];
			return x;
		}
	}

	int peek()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x = arr[top];
			return x;
		}
	}
	
	void display ()  
    {  
        System.out.println("Printing stack elements .....");  
        for(int i = top; i>=0;i--)  
        {  
            System.out.println(arr[i]);  
        }  
    }  
}

//Pros: Easy to implement. Memory is saved as pointers are not involved. 
//Cons: It is not dynamic. It doesn’t grow and shrink depending on needs at runtime.
public class Implement_Stack_Using_Array {
	public static void main(String args[])
	{
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		System.out.println(stack.pop() + " Popped from stack");
		System.out.println("The Peek element is : "+stack.peek());
		stack.display();
	}
}

