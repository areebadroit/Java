package trees;
import java.util.Scanner;
/*
Check if generic tree contain element x
Given a generic tree and an integer x, check if x is present in the given tree or not. Return true if x is present, return false otherwise.
Input format :

Line 1 : Integer x

Line 2 : Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Output format : true or false

Sample Input 1 :
40
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
true
Sample Input 2 :
4
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 2:
false
 */
class Contain_x {
	static boolean flag=false;
	public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
        if(root==null)
            return false;
        if(root.data==x){
            flag=true;
            return flag;
        }
        for(int i=0;i<root.children.size();i++){
            flag=checkIfContainsX(root.children.get(i),x);
        }
        return flag;
    }
}

public class Contain_element_x {
	static Scanner s = new Scanner(System.in);
	public static TreeNode<Integer> takeInputLevelWise(){
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of nodes that are entered themselves but their children aren't added yet
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
				int numChild = s.nextInt();
				for(int i = 0 ; i < numChild; i++){
					int currentChild = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
					pendingNodes.enqueue(childNode);
					currentNode.children.add(childNode);
				}
			} catch (QueueEmptyException e) {
			}
		}
		return root;
	}
	public static void main(String[] args) {
		int x = s.nextInt();
    TreeNode<Integer> root =  takeInputLevelWise();
		System.out.println(Contain_x.checkIfContainsX(root, x));
	}
}
