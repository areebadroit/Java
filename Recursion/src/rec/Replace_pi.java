package rec;
import java.util.Scanner;
/*
Replace pi (recursive)
Given a string, compute recursively a new string where all appearances of "pi" have been replaced by "3.14".
Sample Input 1 :
xpix
Sample Output :
x3.14x
Sample Input 2 :
pipi
Sample Output :
3.143.14
Sample Input 3 :
pip
Sample Output :
3.14p
 */
class Replace {
	static String result;
	// Return the changed string
	public static String replace(String input){
		// Write your code here
		if(input.length()<=1)
			return input;
		String temp=input.substring(1);
		String t = replace(temp);
		if(input.charAt(0)=='p'&&t.charAt(0)=='i'){
			input="3.14"+t.substring(1);
			return input;
		}
		return input.charAt(0)+t;

	}
}

public class Replace_pi {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(Replace.replace(input));
	}
}
