package binaryTrees;
import java.util.Scanner;
/*
Binary Tree Traversal
Given a binary tree, print the InOrder, PreOrder, PostOrder traversal of given tree.
In-order traversal is: LeftChild Root RightChild 
Pre-order traversal is: Root LeftChild RightChild
Post-order traversal is: LeftChild RightChild Root
Input format :
Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Output Format :
In-order traversal, elements separated by space
Pre-order traversal, elements separated by space
Post-order traversal, elements separated by space
Sample Input :
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output :
In-order Traversal
1 3 4 6 7 8 10 13 14 
Pre-order Traversal
8 3 1 6 4 7 10 14 13 
Post-order Traversal
1 4 7 6 3 13 14 10 8 
 */
class In_Pre_Post_order_Taversal {
	public static void inOrder(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	public static void preOrder(BinaryTreeNode<Integer> root) {
		if(root==null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
	}
	public static void postOrder(BinaryTreeNode<Integer> root) {
		if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");  		
	}
}

public class InOrder_PreOrder_PostOrder_Traversal {
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
		System.out.println("In-order Traversal");
		In_Pre_Post_order_Taversal.inOrder(root);
		System.out.println();
		System.out.println("Pre-order Traversal");
		In_Pre_Post_order_Taversal.preOrder(root);
		System.out.println();
		System.out.println("Post-order Traversal");
		In_Pre_Post_order_Taversal.postOrder(root);
	}
}
