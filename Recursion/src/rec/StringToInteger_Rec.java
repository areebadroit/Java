package rec;
import java.util.*;
/*
String to Integer
Write a recursive function to convert a given string into the number it represents. That is input will be a numeric string that contains only numbers, you need to convert the string into corresponding integer and return the answer.
Input format :
Numeric string (string, Eg. "1234")
Output format :
Corresponding integer (int, Eg. 1234)
Sample Input 1 :
1231
Sample Output 1:
1231
Sample Input 2 :
12567
Sample Output 2 :
12567
 */
class Convert {
    static int num=0;
	public static int convertStringToInt(String input){
		// Write your code here
    if(input.length()<1)
        return 0;
    int b = input.charAt(0) - '0';
    int p = input.length()-1;
    num = (b * (int)Math.pow(10,p)) + num;
    convertStringToInt(input.substring(1));
    return num;
	}
}

public class StringToInteger_Rec {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(Convert.convertStringToInt(input));
	}
}