package stacks;
import java.util.Stack;
import java.util.Scanner;

/*
Minimum bracket Reversal

Given a string expression which consists only ‘}’ and ‘{‘. The expression may not be balanced. You need to find the minimum number of bracket reversals which are required to make the expression balanced.
Return -1 if the given expression can't be balanced.
Input Format :
String S
Output Format :
Required count
Sample Input 1 :
{{{
Sample Output 1 :
-1
Sample Input 2 :
{{{{}}
Sample Output 2 :
1
 */

class Reversal {
	// Function returns -1 if brackets can't be balanced
	public static int countBracketReversals(String input){
        Stack<Character> st = new Stack<>();
        if(input.length()%2!=0)
            return -1;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='{'){
                st.push(input.charAt(i));
            }
            else if(input.charAt(i)=='}'){
                if(st.isEmpty()){
                    st.push(input.charAt(i));
                }
                else if(!st.isEmpty()&&st.peek()=='{'){
                    st.pop();
                }
                else if(!st.isEmpty()&&st.peek()!='{'){
                    st.push(input.charAt(i));
                }
            }
        }
        int c=0;
        while(!st.isEmpty()){
            char ch1=st.pop();
            char ch2=st.pop();
            if(ch1==ch2){
                c+=1;
            }
            else{
                c+=2;
            }
        }
        return c;
	}
}

public class Minimum_Bracket_Reversal {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {

		String str = s.nextLine();
		System.out.println(Reversal.countBracketReversals(str));

	}

}
