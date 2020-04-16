package stacks;
import java.util.Stack;
import java.util.Scanner;

/*
Balanced Parenthesis

Given a string expression, check if brackets present in the expression are balanced or not. Brackets are balanced if the bracket which opens last, closes first.
You need to return true if it is balanced, false otherwise.
Note: This problem was asked in initial rounds in Facebook
Sample Input 1 :
{ a + [ b+ (c + d)] + (e + f) }
Sample Output 1 :
true
Sample Input 2 :
{ a + [ b - c } ]
Sample Output 2 :
false
 */

class BalParenthesis {

	public static boolean checkBalanced(String exp) {
		// Write your code here
		Stack<Character> st = new Stack<>();
        if(exp.length()==0)
            return false;
        for(int i=0;i<exp.length();i++){
            if(exp.charAt(i)=='('||exp.charAt(i)=='{'||exp.charAt(i)=='['){
                st.push(exp.charAt(i));
            }
            else if(exp.charAt(i)==')'){
                if(!st.isEmpty()&&st.peek()=='('){
                    st.pop();
                }else{
                    return false;
                }
            }
            else if(exp.charAt(i)=='}'){
                if(!st.isEmpty()&&st.peek()=='{'){
                    st.pop();
                }else{
                    return false;
                }
            }
            else if(exp.charAt(i)==']'){
                if(!st.isEmpty()&&st.peek()=='['){
                    st.pop();
                }else{
                    return false;
                }
            }
        }//end of for
        if(!st.isEmpty())
            return false;
        return true;
	}
}
public class BalancedParanthesis {
static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		String input = s.nextLine();
		System.out.println(BalParenthesis.checkBalanced(input));
	}
}
