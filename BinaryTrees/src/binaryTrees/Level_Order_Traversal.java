package binaryTrees;
import java.util.ArrayList;
/*
Level order traversal
Given a binary tree, print the level order traversal. Make sure each level start in new line.
Input format :

Elements in level order form (separated by space). If any node does not have left or right child, take -1 in its place.

Output Format :

Elements are printed level wise, each level in new line (separated by space).

Sample Input :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output :
5 
6 10 
2 3 
9
 */
import java.util.Scanner;
class Level_Order {

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

	public static void printLevelWise(BinaryTreeNode<Integer> root){
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        BinaryTreeNode<Integer> nullNode = new BinaryTreeNode<Integer>(Integer.MIN_VALUE);
		if (root == null) {
			return;
		}
		pendingNodes.enqueue(root);
        pendingNodes.enqueue(nullNode);
        while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front;
			try {
				front = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return;
			}
            if(front==nullNode) {
                if(pendingNodes.isEmpty())
                    break;
                pendingNodes.enqueue(nullNode);
                System.out.println();
                //continue;
            }
            else if(front.left!=null&&front.right!=null){
        		System.out.print(front.data+" ");
                pendingNodes.enqueue(front.left);
                pendingNodes.enqueue(front.right);
            }
            else if(front.right==null&&front.left!=null){
                System.out.print(front.data+" ");
                pendingNodes.enqueue(front.left);
            }
            else if(front.left==null&&front.right!=null){
                System.out.print(front.data+" ");
                pendingNodes.enqueue(front.right);
            }
            else
                System.out.print(front.data+" ");
        }
    }
}

public class Level_Order_Traversal {
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
		Level_Order.printLevelWise(root);
	}
}
