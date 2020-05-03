package tries;
import java.util.Scanner;

class _Trie {
	private TrieNode root;
	public int count;
	public _Trie() {
		root = new TrieNode('\0');
		count = 0;
	}	

	private boolean add(TrieNode root, String word){
		if(word.length() == 0){
			if (!root.isTerminating) {
				root.isTerminating = true;
				return true;
			} else {
				return false;
			}
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		return add(child, word.substring(1));

	}

	public void add(String word){
		if (add(root, word)) {
			this.count++;
		}
	}
	private boolean search(TrieNode root, String word){
		if(word.length() == 0){
			if (root.isTerminating) {
				return true;
			} else {
				return false;
			}
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		return search(child, word.substring(1));
	}

	public boolean search(String word){
		return search(root, word);
	}
	public void remove(String word) {
		remove(root,word);
	}

	private void remove(TrieNode root, String word) {
		if(word.length()==0) {
			root.isTerminating=false;
			return;
		}
		int childIndex = word.charAt(0)-'a';
		TrieNode child = root.children[childIndex];
		if(child==null) {
			return;
		}
		remove(child, word.substring(1));
		//We can remove child node only if it is non terminating and its number of children are 0
		if(!child.isTerminating && child.childCount==0) {
			root.children[childIndex]=null;
			child=null;
			root.childCount--;
		}
	}
	public int countWords() {
		return countWords(root);
	}

	private int countWords(TrieNode root) {
		int result=0;
		if(root.isTerminating)
			result+=1;


		for(int i=0;i<26;i++) {
			if(root.children[i]!=null) 
				result+=countWords(root.children[i]);
		}
		return result;
	}

}
public class Trie {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		_Trie t = new _Trie();
		int choice = s.nextInt();

		while(choice != -1) {
			String word;
			switch(choice) {
			case 1 : // insert
				word = s.next();
				t.add(word);
				break;
			case 2 : // search
				word = s.next();
				System.out.println(t.search(word));
				break;
			case 3 : // remove
				word = s.next();
				t.remove(word);
				break;
			case 4 : //count words
				System.out.println(t.countWords());
				break;
			default :
				return;
			}
			choice = s.nextInt();
		}
	}

}