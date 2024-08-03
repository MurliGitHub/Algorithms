package m2j.ds.hr.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author m2j
 * @see https://www.hackerrank.com/challenges/simple-text-editor/problem
 * 
 *
 */
public class SimpleTextEditor {

	static Stack<String> stack = new Stack<String>();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        StringBuilder s = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        
        for(int i=0;i<n;i++){
        	int type = sc.nextInt();
            switch(type){
                case 1:
                    String w = sc.next();
                    s.append(w);
                    stack.push(1+" "+w.length());
                    break;
                case 2:
                    int k = sc.nextInt();
                    stack.push(2+" "+s.substring(s.length() - k));
                    s.setLength(s.length() - k);
                    break;
                case 3:
                    k = sc.nextInt();
                    System.out.println(s.charAt(k-1));
                    break;
                case 4:
                    String undo = stack.pop();
                    String undoItems[] = undo.split(" ");
                    if(undoItems[0].equals("1")){
                        s.setLength(s.length() - Integer.valueOf(undoItems[1]));
                    } else {
                        s.append(undoItems[1]);
                    }
                    break;
            }
        }
	}

}
