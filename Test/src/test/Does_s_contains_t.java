package test;
import java.util.*;
/*Given two string s and t, write a function to check if s contains all characters of t (in the same order as they are in string t).
Return true or false.
Do it recursively.
E.g. : s = “abchjsgsuohhdhyrikkknddg” contains all characters of t=”coding” in the same order. So function will return true.*/
class Solution {
	public static boolean checkSequence(String a, String b) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
        return checkSequence( b, a, b.length(), a.length());
	}
    public static boolean checkSequence(String a, String b, int al, int bl) {
		if(al==0)
            return true;
        if(bl==0)
            return false;
        if(a.charAt(al-1)==b.charAt(bl-1))
            return checkSequence( a, b, al-1, bl-1);
        return checkSequence( a, b, al, bl-1);
	}
    
}
public class Does_s_contains_t {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String large = s.nextLine();
		String small = s.nextLine();
		s.close();
		System.out.println(Solution.checkSequence(large, small));
	}
}
