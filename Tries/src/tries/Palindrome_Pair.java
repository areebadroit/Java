package tries;
import java.util.ArrayList;
import java.util.Scanner;
/*
Palindrome Pair
Givan n number of words, you need to find if there exist any two words which can be joined to make a palindrome or any word itself is a palindrome.
Return true or false.
Input Format :
Line 1 : Integer n
Line 2 : n words (separated by space)
Output Format :
true ot false
Sample Input 1 :
4
abc def ghi cba
Sample Output 2 :
true
Sample Output 1 Expalanation :
"abc" and "cba" forms a palindrome
Sample Input 2 :
4
abc def ghi hg
Sample Output 2 :
true
Sample Output 2 Expalanation :
"ghi" and "hg" forms a palindrome
 */

class Trie_Palindrome {

    
    private TrieNode root;
	public int count;
	public Trie_Palindrome() {
	root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			if (!root.isTerminating) {
				root.isTerminating = true;
			
			}
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

    
    
    
    public boolean search(TrieNode root,String word){
        if(word.length()==0){
            return root.isTerminating;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null)
            return false;
        
        return search(child,word.substring(1));
       
        
    }

	public boolean search(String word){
		return search(root,word);
	}
    

	public boolean findPalindromePair(ArrayList<String> vect) {
        for (int i = 0; i < vect.size(); i++) {  
            String s = vect.get(i); 
            add(s);
        }
        
        for(int i=0;i<vect.size(); i++){
            String s=vect.get(i);
            
            String rev="";
            for(int j=s.length()-1;j>=0;j--){
                rev+=s.charAt(j);
            }
            boolean ans=search(rev)||search(rev.substring(1));
            if(ans)
                return true;
        }
        return false;
        
    }
    
   
}
public class Palindrome_Pair {
static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = s.nextInt();
		ArrayList<String> input = new ArrayList<String>();
		for(int i = 0; i < n; i++) {
			String word = s.next();
			input.add(word);
		}
		Trie_Palindrome t = new Trie_Palindrome();
		System.out.println(t.findPalindromePair(input));
	}
}
