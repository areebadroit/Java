package binaryTrees;
import java.util.Scanner;
/*
Remove Leaf nodes
Remove all leaf nodes from a given Binary Tree. Leaf nodes are those nodes, which don't have any children.
Note : Root will also be a leaf node if it doesn't have left and right child. You don't need to print the tree, just remove all leaf nodes and return the updated root.
Input format :

Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Output Format :

Elements are printed level wise, each level in new line (separated by space).

Sample Input :
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output :
8
3 10
6 14                    
 */
class Remove_Leaf {

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

	public static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root){
        if(root==null)
            return null;
        if(root.left==null&&root.right==null)
            return null;
        root.left=removeAllLeaves(root.left);
        root.right=removeAllLeaves(root.right);
        return root;
	}
}
public class Remove_Leaf_Nodes {
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

	public static void printLevelWiseAtDiffLevel(BinaryTreeNode<Integer> root){
		QueueUsingLL<BinaryTreeNode<Integer>>  primary = new QueueUsingLL<>();
		QueueUsingLL<BinaryTreeNode<Integer>>  secondary = new QueueUsingLL<>();

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
				QueueUsingLL<BinaryTreeNode<Integer>>  temp = secondary;
				secondary = primary;
				primary = temp;
				System.out.println();
			}
		}
	}


	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		root = Remove_Leaf.removeAllLeaves(root);
		printLevelWiseAtDiffLevel(root);
	}
}
