package rec;
import java.util.Scanner;
/*
Remove Duplicates Recursively
Given a string S, remove consecutive duplicates from it recursively.
Input Format :
String S
Output Format :
Output string
Constraints :
1 <= Length of String S <= 10^3
Sample Input :
aabccba
Sample Output :
abcba
 */
class Remove_Duplicates {
	public static String removeConsecutiveDuplicates(String s) {
		// Write your code here
         if(s.length()==1)
            return s;
        String result = removeConsecutiveDuplicates(s.substring(1));
        if(s.charAt(0)!=result.charAt(0))
            result=s.charAt(0)+result;
        return result;
	}

}
public class RemoveDuplicates_Rec {
static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
    	String input = s.next();
    	System.out.println(Remove_Duplicates.removeConsecutiveDuplicates(input));
    }
}