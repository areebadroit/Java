package map;
import java.util.HashMap;
import java.util.Scanner;
/*
Extract Unique characters
Given a string, you need to remove all the duplicates. That means, the output string should contain each character only once. The respective order of characters should remain same.
Input format :
String S
Output format :
Output String
Constraints :
0 <= Length of S <= 10^8
Sample Input 1 :
ababacd
Sample Output 1 :
abcd
Sample Input 2 :
abcde
Sample Output 2 :
abcde
 */
class Unique {

    public static String uniqueChar(String str){
        HashMap<Character,Integer> map=new HashMap<>();
         String s="";
        for(int i=0;i<str.length();i++){
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),1);
                s=s+str.charAt(i);
            } else {
                int oldValue = map.get(str.charAt(i));
                map.put(str.charAt(i), oldValue + 1);
            }
        }
        return s;
    }
}

public class ExtractUniqueCharacters {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String uniChars = Unique.uniqueChar(s.next());
		s.close();
		System.out.println(uniChars);
	}
}
