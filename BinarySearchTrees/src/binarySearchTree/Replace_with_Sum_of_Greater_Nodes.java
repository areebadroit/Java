package binarySearchTree;
import java.util.Scanner;
/*
Replace with Sum of greater nodes
Given a binary search tree, replace each nodes' data with the sum of all nodes' which are greater or equal than it. You need to include the current node's data also.
That is, if in given BST there is a node with data 5, you need to replace it with sum of its data (i.e. 5) and all nodes whose data is greater than or equal to 5.
You don't need to return or print, just change the data of each node.
Input format :

Line 1 : Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Output format : Elements are printed in level order wise, every level in new line

Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 1 :
18 
36 10 
38 31 
25 
 */
class Replace_SumGreater {

/*	Binary Tree Node class
 * 
 * class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
	*/
    public static int replace(BinaryTreeNode<Integer> root,int sum) {
        if(root==null)
            return 0;
        int Rsum=replace(root.right,sum);
        int temp=root.data;
        root.data=sum+root.data+Rsum;
        int Lsum=replace(root.left,root.data);
        if(root.left==null&&root.right!=null)
            return temp+Rsum;
        else if(root.left!=null&&root.right==null)
        	return temp+Lsum;
        else if(root.left!=null&&root.right!=null)
            return temp+Rsum+Lsum;
        return temp;
	}
	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
        replace(root, 0);
	}
}
public class Replace_with_Sum_of_Greater_Nodes {
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		Queue<BinaryTreeNode<Integer>>  pendingNodes = new Queue<BinaryTreeNode<Integer>>(); // we can skip writing again inside <> after java version 1.7 
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = s.nextInt();
			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = s.nextInt();
			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}
	public static void printLevelWiseAtDiffLevel(BinaryTreeNode<Integer> root){
		Queue<BinaryTreeNode<Integer>> primary = new Queue<BinaryTreeNode<Integer>>();
		Queue<BinaryTreeNode<Integer>> secondary = new Queue<BinaryTreeNode<Integer>>();

		primary.enqueue(root);

		while(!primary.isEmpty()){
			BinaryTreeNode<Integer> current=null;
			try {
				current = primary.dequeue();
			} catch (QueueEmptyException e) {
				System.out.println("Not possible");
			}
			System.out.print(current.data + " ");
			if(current.left != null){
				secondary.enqueue(current.left);
			}
			if(current.right != null){
				secondary.enqueue(current.right);
			}
			if(primary.isEmpty()){
				Queue<BinaryTreeNode<Integer>>  temp = secondary;
				secondary = primary;
				primary = temp;
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		Replace_SumGreater.replaceWithLargerNodesSum(root);
		printLevelWiseAtDiffLevel(root);
	}
}
