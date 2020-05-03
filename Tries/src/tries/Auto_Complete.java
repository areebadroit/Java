package tries;
import java.util.ArrayList;
import java.util.Scanner;
/*
Auto complete
Givan n number of words and an incomplete word w. You need to auto-complete that word w.
That means, find and print all the possible words which can be formed using the incomplete word w.
Input Format :
Line 1 : Integer n
Line 2 : n words (separated by space)
Line 3 : Word w
Output Format :
All possible words (in different lines)
Note : Order of words doesn't matter.
Sample Input 1 :
7
do dont no not note notes den
no
Sample Output 2 :
no
not
note
notes
Sample Input 2 :
7
do dont no not note notes den
de
Sample Output 2 :
den
Sample Input 3 :
7
do dont no not note notes den
nom
Sample Output 3 :
(Empty) There is no word which starts with "nom"
 */
class Trie_Auto_Complete {
    private TrieNode root;

    public Trie_Auto_Complete() {
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

    private TrieNode findWord(TrieNode root, String word){
		if(word.length() == 0){
			return root;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return null;
		}
		return findWord(child, word.substring(1));
	}


	public void allPossibleWords(TrieNode root,String word, String output){
		if(root.isTerminating) {
			System.out.println(word+output);
		}
		for(int i=0;i<26;i++) {
			if(root.children[i]!=null) 
				allPossibleWords(root.children[i],word, output+root.children[i].data);
		}

	}

	public void autoComplete(ArrayList<String> input, String word) {
		for(int i=0;i<input.size();i++){
			add(input.get(i));
		}
		TrieNode node=findWord(root,word);
		if(node!=null){
			allPossibleWords(node,word,"");
		}
	}
}
public class Auto_Complete {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Trie_Auto_Complete t = new Trie_Auto_Complete();
		int n = s.nextInt();
		ArrayList<String> input = new ArrayList<String>();
		for(int i = 0; i < n; i++) {
			String word = s.next();
			input.add(word);
		}
		String pattern = s.next();
		s.close();
		t.autoComplete(input, pattern);
	}
}
