package rec;
import java.util.*;
/*
Pair star
Given a string, compute recursively a new string where identical chars that are adjacent in 
the original string are separated from each other by a "*".
Sample Input 1 :
hello
Sample Output 1:
hel*lo
Sample Input 2 :
xxyy
Sample Output 2:
x*xy*y
Sample Input 3 :
aaaa
Sample Output 3:
a*a*a*a
 */
class PairS {
    static String result = "";
	// Return the updated string
	public static String addStars(String s) {
		// Write your code here
        if(s.length()<=1){
            result=s;
            return s;
        }
        String s1 = addStars(s.substring(1));
        if(s.charAt(0)==s1.charAt(0))
            result = s.charAt(0)+ "*" + result;
        else
            result = s.charAt(0) + result;
        return result;
	}
}

public class PairStar {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(PairS.addStars(input));
	}
}

