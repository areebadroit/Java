package trees;
import java.util.Scanner;
/*
Node having sum of children and node is max
Given a tree, find and return the node for which sum of data of all children and the node itself is maximum. In the sum, data of node itself and data of immediate children is to be taken.
Input format :

Line 1 : Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Output format : Node with maximum sum.

Sample Input 1 :
5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0
Sample Output 1 :
1
 */
class pair{
    int sum;
    TreeNode<Integer> mnode;
}
class Node_and_Children {
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		pair smallAns=maxSumNodehelp(root);
	    return smallAns.mnode;
	}
	public static pair maxSumNodehelp(TreeNode<Integer> root){
	    pair ob=new pair();
		ob.mnode=root;
	    ob.sum=root.data;
	     for(int i=0;i<root.children.size();i++){
	         ob.sum+=root.children.get(i).data;
	     }
	    for(int i=0;i<root.children.size();i++){
	         pair small=maxSumNodehelp(root.children.get(i));
	         if(small.sum>ob.sum){
	             ob.sum=small.sum;
	             ob.mnode=small.mnode;
	             }
	     }
	    return ob;
	}
}
public class sum_of_children_and_node_is_max {
	static Scanner s = new Scanner(System.in);
	public static TreeNode<Integer> takeInputLevelWise(){
	QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
//	System.out.println("Enter root Data");
	int rootData = s.nextInt();
	TreeNode<Integer> root = new TreeNode<Integer>(rootData);
	pendingNodes.enqueue(root);
	while(!pendingNodes.isEmpty()){
		TreeNode<Integer> currentNode;
		try {
			currentNode = pendingNodes.dequeue();
//			System.out.println("Enter number of children of "+currentNode.data);
			int numChild = s.nextInt();
			for(int i = 0 ; i < numChild; i++){
//				System.out.println("Enter "+ i + "th child of " + currentNode.data);
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
		TreeNode<Integer> root =  takeInputLevelWise();
		TreeNode<Integer> ans = Node_and_Children.maxSumNode(root);
		if(ans == null){
			System.out.println(Integer.MIN_VALUE);
		}else{
			System.out.println(ans.data);
		}
	}
}
