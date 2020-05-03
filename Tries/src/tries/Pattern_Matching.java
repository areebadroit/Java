package tries;
import java.util.ArrayList;
import java.util.Scanner;
/*
Pattern Matching
Given a list of n words and a pattern p that we want to search. Check if the pattern p is present the given words or not.
Return true or false.
Input Format :
Line 1 : Integer n
Line 2 : n words (separated by space)
Line 3 : Pattern p (a string)
Output Format :
true ot false
Sample Input 1 :
4
abc def ghi cba
de
Sample Output 2 :
true
Sample Input 2 :
4
abc def ghi hg
hi
Sample Output 2 :
true
Sample Input 3 :
4
abc def ghi hg
hif
Sample Output 3 :
false
 */
class Pattern {
	private TrieNode root;
	
	public Pattern() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}
    
    private boolean patternSearch(TrieNode root, String word){
		if(word.length() == 0){
			// if (root.isTerminating) {
			// 	return true;
			// } else {
			// 	return false;
			// }
            return true;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		return patternSearch(child, word.substring(1));
	}

	public boolean patternSearch(String word){
		return patternSearch(root, word);
	}
	public boolean patternMatching(ArrayList<String> input, String pattern) {
        for(int i=0;i<input.size();i++){
            String str=input.get(i);
            //String str=input.get(i).substring(1);
            while(str.length()!=0){
                add(str);
                str=str.substring(1);
            }
        }
        if(patternSearch(pattern))
            return true;
        return false;
	}
}
public class Pattern_Matching {
static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		Pattern t = new Pattern();
		int n = s.nextInt();
		ArrayList<String> input = new ArrayList<String>();
		for(int i = 0; i < n; i++) {
			String word = s.next();
			input.add(word);
		}
		String pattern = s.next();
		System.out.println(t.patternMatching(input, pattern));
	}
}
