package binarySearchTree;
import java.util.Scanner;
/*
Largest BST
Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height in the given binary tree.
Return the height of largest BST.
Input format :

Line 1 : Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Sample Input 1:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
2
 */
class result{
	boolean isBST;
	int max;
	int min;
	int height;
}
class Largest {

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
	public static result largestBSTSubtreeHelp(BinaryTreeNode<Integer> root) {
		result ob=new result();
		if(root==null){
			ob.isBST = true;
			ob.min=Integer.MAX_VALUE;
			ob.max=Integer.MIN_VALUE;
			ob.height=0;
			return ob;
		}
		result leftOutput = largestBSTSubtreeHelp(root.left);
		result rightOutput = largestBSTSubtreeHelp(root.right);
		ob.min = Math.min(root.data, Math.min(leftOutput.min, rightOutput.min));
		ob.max = Math.max(root.data, Math.max(leftOutput.max, rightOutput.max));
		ob.isBST = (root.data > leftOutput.max) 
				&& (root.data <= rightOutput.min)
				&& leftOutput.isBST && rightOutput.isBST;
		if(ob.isBST)
			ob.height=Math.max(leftOutput.height,rightOutput.height)+1;
		else
			ob.height=Math.max(leftOutput.height,rightOutput.height);
		return ob;

	}

	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		result res = largestBSTSubtreeHelp(root);
		return res.height;
	}
}
public class Largest_BST {
	static Scanner s = new Scanner(System.in);
	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); // we can skip writing again inside <> after java version 1.7 
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
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		System.out.println(Largest.largestBSTSubtree(root));
	}

}
