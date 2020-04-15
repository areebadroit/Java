package rec;
import java.util.*;
public class RemoveX {
	static String temp="";
	// Return the changed string
	public static String removeX(String input){
		// Write your code here
        if(input.length() < 1){
            return "";
        }
        removeX(input.substring(1));
        if(input.charAt(0)!='x')
            temp=input.charAt(0)+temp;
        return temp;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(removeX(input));
		s.close();
	}
}
