package m2j.ds.hr.queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author m2j
 * @see https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
 * 
 *
 */
public class QueueTwoStacks2 {
	static Stack<Integer> inStack = new Stack<Integer>();
	static Stack<Integer> outStack = new Stack<Integer>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int n= sc.nextInt();
		
		while(n>0) {
			int type=sc.nextInt();
			switch (type) {
			case 1:
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
		exchange();
        outStack.pop();  
	}
	
	static void exchange() {
		if (outStack.empty()) {
			while (!inStack.empty()) {
				outStack.push(inStack.pop());
			}
		}
	}

	private static void display() {
		exchange();
		System.out.println(outStack.peek());
	}

	private static void enqueue(int x) {
		inStack.push(x);
	}

}
