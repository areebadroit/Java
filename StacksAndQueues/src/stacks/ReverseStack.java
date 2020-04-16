package stacks;
import java.util.Stack;
import java.util.Scanner;

/*
Reverse Stack

Reverse a given Stack with the help of another empty stack. Two stacks will be given. Out of which first contains some integers and second one is empty. You need to reverse the first one using second stack. Change in the given first stack itself.
Note : You don't need to print or return the stack, just reverse the given stack and it will be printed internally.
Input format :
Line 1 : Size of Stack
Line 2 : Stack elements (separated by space)
Sample Input 1 :
4 
1 2 3 4     (4 is at top)
Sample Output 1 :
1 2 3 4    (1 is at top)
 */

class RevStack {
static int count=0;
	public static void reverseStack(Stack<Integer> s1, Stack<Integer> s2) {
        // if(s1.size()==1&&s2.isEmpty()){
        //     return;
        // }
        
        if(s1.size()==1){
            s2.push(s1.pop());
            count=count+1;
            // System.out.println(count);
            if(count<=1){
                s1.push(s2.pop());
            }
            return;
        }
		int n=s1.pop();
        count=count+1;
        //System.out.println(count);
        reverseStack(s1, s2);
           s2.push(n);
        	count=count-1;
        //System.out.println(count);
        if(count==1){
            	while(!s2.isEmpty()){
               	 s1.push(s2.pop());
          	  }
        }
    }
}
public class ReverseStack {
static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		int size = s.nextInt();
		Stack<Integer> input = new Stack<Integer>();
		for(int i = 0; i < size; i++) {
			input.push(s.nextInt());
		}
		Stack<Integer> extra = new Stack<Integer>();
		RevStack.reverseStack(input, extra);
		while(!input.isEmpty()) {
			System.out.print(input.pop() + " ");
		}
	}
}
