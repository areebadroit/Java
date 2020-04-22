package binaryTrees;
import java.util.Scanner;
/*
Nodes without sibling
Given a binary tree, print all nodes that don’t have a sibling.
Edit : Print the elements in different lines. And order of elements doesn't matter.
Input format :
Elements in level order form (separated by space). If any node does not have left or right child, take -1 in its place.
Output format :
Print nodes separated by new line.
Sample Input :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output :
9    
 */
class Sibling {

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

	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        if(root==null)
            return;
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
        if(root.left!=null&&root.right==null){
            System.out.println(root.left.data);
        }
        if(root.right!=null&&root.left==null){
            System.out.println(root.right.data);
        }
	}
}

public class Nodes_without_sibling {
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
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
		Sibling.printNodesWithoutSibling(root);
	}
}
