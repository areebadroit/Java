package rec;
import java.util.Scanner;
/*
Check AB
Suppose you have a string made up of only 'a' and 'b'. Write a recursive function that checks if the string was generated using the following rules:
a. The string begins with an 'a'
b. Each 'a' is followed by nothing or an 'a' or "bb"
c. Each "bb" is followed by nothing or an 'a'
If all the rules are followed by the given string, return true otherwise return false.
Sample Input:
abb
Sample Output:
true
 */
class Check {
	public static boolean checkAB(String s) {
		// Write your code here
        if (s.length()==0) 
        return true;
    if (s.charAt(0) != 'a')
        return false;
    if (s.length() >= 3 && "abb".equals(s.substring(0,3)))
        return checkAB(s.substring(3));
    else
        return checkAB(s.substring(1));
	}
}

public class CheckAB {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		System.out.println(Check.checkAB(input));
	}
}
