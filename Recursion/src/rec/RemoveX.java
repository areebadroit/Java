package rec;
import java.util.Scanner;
/*
Remove X
Given a string, compute recursively a new string where all 'x' chars have been removed.
Sample Input 1 :
xaxb
Sample Output 1:
ab
Sample Input 2 :
abc
Sample Output 2:
abc
Sample Input 3 :
xx
Sample Output 3:
 */
class Remove {
    static String temp="";
	// Return the changed string
	public static String removeX(String input){
		// Write your code here
        if(input.length() < 1){
            return "";
        }
        removeX(input.substring(1));
        if(input.charAt(0)=='x')
            temp=temp;
        else
            temp=input.charAt(0)+temp;
        return temp;
	}
}

public class RemoveX {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(Remove.removeX(input));
	}
}
