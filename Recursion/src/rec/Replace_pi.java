package rec;
import java.util.*;

public class Replace_pi {
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
            return input;}
        return input.charAt(0)+t;
        
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(replace(input));
		s.close();
	}
}
