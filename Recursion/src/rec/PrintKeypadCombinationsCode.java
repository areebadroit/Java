package rec;
import java.util.Scanner;
/*
Print Keypad Combinations Code
Given an integer n, using phone keypad find out and print all the possible strings that can be made using digits of input n.
Note : The order of strings are not important. Just print different strings in new lines.
Input Format :
Integer n
Output Format :
All possible strings in different lines
Constraints :
1 <= n <= 10^6
Sample Input:
23
Sample Output:
ad
ae
af
bd
be
bf
cd
ce
cf
 */
class PrintKeyCombinationsCode {
    public static void printKeypad(int input) {
        helper(input," ");
    }
    public static void helper(int input,String output) {
        if(input==0) {
            System.out.println(output);
        }
        int mod=input%10;
        String a=get(mod);
        for(int i=0;i<a.length();i++) {
            helper(input/10,a.substring(i,i+1) + output);
        }
    }
    public static String get(int n) {
        if(n==2) {
            return "abc";
        }
        if(n==3) {
            return "def";
        }
        if(n==4) {
            return "ghi";
        }
        if(n==5) {
            return "jkl";
        }
        if(n==6) {
            return "mno";
        }
        if(n==7) {
            return "pqrs";
        }
        if(n==8) {
            return "tuv";
        }
        if(n==9) {
            return "wxyz";
        }
        return "";
    }
}
public class PrintKeypadCombinationsCode {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		PrintKeyCombinationsCode.printKeypad(input);
	}
}
