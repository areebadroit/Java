package binaryTrees;
import java.util.Scanner;
/*
Height Of Binary Tree
Send Feedback
Given a binary tree, find and return the height of given tree.
Input format :
Nodes in the level order form (separated by space). If any node does not have left or right child, take -1 in its place
Output format :
Height
Constraints :
1 <= N <= 10^5
Sample Input :
10
 9 
4 
-1 
-1 
 5 
 8 
-1 
6 
-1 
-1 
3 
-1 
-1
-1
Sample Output :
5 
 */
class Height_BT {
	public static int height(BinaryTreeNode<Integer> root) {
        if(root==null)
            return 0;
        int h=1;
        int temph1=height(root.left);
        int temph2=height(root.right);
        if(temph1>temph2)
            return temph1+h;
        return temph2+h;
	}
	
}

public class Height_of_BT {
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
		System.out.println(Height_BT.height(root));
	}
}
