//package rec;
//
//public class ReplaceChar_Rec {
//	static String result="";
//	public static String replaceCharacter(String input, char c1, char c2) {
//		/* Your class should be named Solution
//		 * Don't write main().
//		 * Don't read input, it is passed as function argument.
//		 * Return output and don't print it.
//		 * Taking input and printing output is handled automatically.
//		 */
//        if(input.length()<1)
//            return "";
//        replaceCharacter(input.substring(1),c1,c2);
//        if(input.charAt(0)==c1)
//            result=c2+result;
//        else
//            result=input.charAt(0)+result;
//        return result;
//	}
//	public static void main(String args[]) {
//		System.out.println(replaceCharacter("asdcd",'d','e'));
//	}
//}
package rec;

public class ReplaceChar_Rec {
	//static String result="";
	public static String replaceCharacter(String input, char c1, char c2) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
        if(input.length()<1)
            return "";
        String result=replaceCharacter(input.substring(1),c1,c2);
        if(input.charAt(0)==c1)
            return c2+result;
        else
            return input.charAt(0)+result;
        //return result;
	}
	public static void main(String args[]) {
		System.out.println(replaceCharacter("asdcd",'d','e'));
	}
}
