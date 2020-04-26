package rec;
import java.util.Scanner;
/*
Replace Character Recursively
Given an input string S and two characters c1 and c2, you need to replace every occurrence of character c1 with character c2 in the given string.
Do this recursively.
Input Format :
Line 1 : Input String S
Line 2 : Character c1 and c2 (separated by space)
Output Format :
Updated string
Constraints :
1 <= Length of String S <= 10^6
Sample Input :
abacd
a x
Sample Output :
xbxcd
 */
class ReplaceChar {
    static String result="";
	public static String replaceCharacter(String input, char c1, char c2) {
        if(input.length()<1)
            return "";
        replaceCharacter(input.substring(1),c1,c2);
        if(input.charAt(0)==c1)
            result=c2+result;
        else
            result=input.charAt(0)+result;
        return result;
	}
}

public class ReplaceChar_Rec {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		char c1 = s.next().charAt(0);
		char c2 = s.next().charAt(0);
		System.out.println(ReplaceChar.replaceCharacter(input, c1, c2));
	}
}
