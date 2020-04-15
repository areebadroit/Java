package rec;
import java.util.*;
public class PairStar {
	 static String result = "";
		// Return the updated string
		public static String addStars(String s) {
			// Write your code here
	        if(s.length()<=1){
	            //result=s;
	            return s;
	        }
	        String s1 = addStars(s.substring(1));
	        if(s.charAt(0)==s1.charAt(0))
	        	return s.charAt(0)+ "*" + s1;
	            //result = s.charAt(0)+ "*" + result;
	        else
	        	return s.charAt(0) + s1;
	            //result = s.charAt(0) + result;
	        //return result;
		}
		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			String input = s.nextLine();
			System.out.println(addStars(input));
			s.close();
		}
	}

