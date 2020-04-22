package binaryTrees;
import java.util.Scanner;
/*
is Balanced
Given a binary tree, check if its balanced i.e. depth of left and right subtrees of every node differ by at max 1. Return true if given binary tree is balanced, false otherwise.
Input format :

Elements in level order form (separated by space). If any node does not have left or right child, take -1 in its place.

Sample Input 1 :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1 :
false
Sample Input 2 :
1 2 3 -1 -1 -1 -1
Sample Output 2 :
true
 */
class pairs{
	int height;
	boolean isBalanced;
}
class isBalanced {
	public static pairs checkBalancedHelp(BinaryTreeNode<Integer> root){
		pairs ob = new pairs();
		if(root==null){
			ob.height=0;
			ob.isBalanced=true;
			return ob;
		}
		pairs tLeft=checkBalancedHelp(root.left);
		pairs tRight=checkBalancedHelp(root.right);
		if(Math.abs(tLeft.height-tRight.height)<=1&&tLeft.isBalanced&&tRight.isBalanced){
			ob.height=Math.max(tLeft.height,tRight.height)+1;
			ob.isBalanced=true;
			return ob;
		}
		ob.height=Math.max(tLeft.height,tRight.height)+1;
		ob.isBalanced=false;
		return ob;
	}
	public static boolean checkBalanced(BinaryTreeNode<Integer> root){
		pairs ans= checkBalancedHelp(root);
		return ans.isBalanced;
	}
}
public class BT_isBalanced {
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
		System.out.println(isBalanced.checkBalanced(root));
	}
}
