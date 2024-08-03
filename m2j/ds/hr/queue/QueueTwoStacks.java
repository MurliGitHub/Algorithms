package m2j.ds.hr.queue;

import java.util.Scanner;
import java.util.Stack;

public class QueueTwoStacks {
	static Stack<Integer> inStack = new Stack<Integer>();
	static Stack<Integer> outStack = new Stack<Integer>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		System.out.println("Enter the no of operations: ");
		int n= sc.nextInt();
		
		while(n>0) {
			System.out.println("Type of operation: ");
			int type=sc.nextInt();
			switch (type) {
			case 1:
				System.out.println("Enter the no to enqueue.");
				int x = sc.nextInt();
				enqueue(x);
				break;
			case 2:
				dequeue();
				break;
				
			case 3:
				display();
				break;
			default:
				break;
			}
			
			n--;
		}
		sc.close();
	}

	private static void dequeue() {
		
        if (inStack.isEmpty())  
        {  
            System.err.println("Queue is Empty");  
            System.exit(0);  
        }  
  
        inStack.pop();  
	}

	private static void display() {
		Integer peek = inStack.peek();
		System.out.println(peek);
	}

	private static void enqueue(int x) {
		while(!inStack.isEmpty()) {
			outStack.push(inStack.pop());
		}
		
		inStack.push(x);
		
		while(!outStack.isEmpty()) {
			inStack.push(outStack.pop());
		}
	}

}
