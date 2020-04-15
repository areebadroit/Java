//package rec;
//import java.util.*;
//public class StringToInteger_Rec {
//	static int num=0;
//	public static int convertStringToInt(String input){
//		// Write your code here
//    if(input.length()<1)
//        return 0;
//    int b = input.charAt(0) - '0';
//    int p = input.length()-1;
//    num = (b * (int)Math.pow(10,p)) + num;
//    convertStringToInt(input.substring(1));
//    return num;
//	}
//	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		String input = s.nextLine();
//		System.out.println(convertStringToInt(input));
//		s.close();
//	}
//}

package rec;
import java.util.*;
public class StringToInteger_Rec {
	//static int num=0;
	public static int convertStringToInt(String input){
		// Write your code here
    if(input.length()<1)
        return 0;
    int num=convertStringToInt(input.substring(1));
    int b = input.charAt(0) - '0';
    int p = input.length()-1;
    num = (b * (int)Math.pow(10,p)) + num;
    
    return num;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(convertStringToInt(input));
		s.close();
	}
}