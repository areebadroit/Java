package rec;

import java.util.Scanner;

public class RemoveDuplicates_Rec {
	
	public static String removeConsecutiveDuplicates(String s) {
		// Write your code here
        if(s.length()==1)
            return s;
        String result = removeConsecutiveDuplicates(s.substring(1));
        if(s.charAt(0)!=result.charAt(0))
            result=s.charAt(0)+result;
        return result;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
    	String input = s.next();
    	System.out.println(removeConsecutiveDuplicates(input));
    	s.close();
    }
}