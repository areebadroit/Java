package stacks;
import java.util.Stack;
import java.util.Scanner;

/*
Check redundant brackets

Given a string mathematical expression, return true if redundant brackets are present in the expression. Brackets are redundant if there is nothing inside the bracket or more than one pair of brackets are present.
Assume the given string expression is balanced and contains only one type of bracket i.e. ().
Note: You will not get partial score for this problem. You will get marks only if all test cases are passed.
Input Format :
String s (Expression)
Output Format :
true or false
Sample Input 1:
((a + b)) 
Sample Output 1:
true
Sample Input 2:
(a+b) 
Sample Output 2:
false
 */

class RedundantBrackets{
	
	public static boolean checkRedundantBrackets(String input) {
		// Write your code here
        Stack<Character> st=new Stack<>();
        int count=0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)!=')'){
                st.push(input.charAt(i));
            }else{
                while(st.pop()!='('){
                    count++;
                }
            	if(count<1){
                    return true;
                }
                count=0;
            }
        }
        return false;
	}
}
public class Check_Redundant_Brackets {
static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		String input = s.nextLine();
		System.out.println(RedundantBrackets.checkRedundantBrackets(input));
	}
}
