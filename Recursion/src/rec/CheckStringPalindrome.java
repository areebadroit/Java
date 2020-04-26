package rec;
import java.util.Scanner;
/*
Check Palindrome (recursive)
Check if a given String S is palindrome or not (using recursion). Return true or false.
Input Format :
String S
Output Format :
true or false
Sample Input 1 :
racecar
Sample Output 1:
true
Sample Input 2 :
ninja
Sample Output 2:
false
 */
class Palindrome {
	public static boolean isStringPalindrome(String input) {
		// Write your code here
        if(input.length()==0||input.length()==1)
            return true;
        if(input.charAt(0) == input.charAt(input.length()-1))
            return isStringPalindrome(input.substring(1,input.length()-1));
        return false;
	}
}

public class CheckStringPalindrome {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(Palindrome.isStringPalindrome(input));
	}
}
