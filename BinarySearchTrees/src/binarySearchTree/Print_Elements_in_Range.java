package binarySearchTree;
import java.util.Scanner;
/*
Print Elements in Range
Given a Binary Search Tree and two integers k1 and k2, find and print the elements which are in range k1 and k2 (both inclusive).
Print the elements in increasing order.
Input format :
Line 1 : Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Two Integers k1 and k2
Output Format :
Required elements (separated by space)
Sample Input :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
6 10
Sample Output :
6 7 8 10
 */
class Print_in_Range {	
	public static void printNodeFromK1ToK2(BinaryTreeNode<Integer> root,int k1,int k2){
        if(root==null)
            return;
        if(root.data>k2){
            printNodeFromK1ToK2(root.left, k1, k2);
            if(root.data>=k1&&root.data<=k2)
            System.out.print(root.data+" ");
        }
        else if(root.data<k1){
            printNodeFromK1ToK2(root.right, k1, k2);
            if(root.data>=k1&&root.data<=k2)
            System.out.print(root.data+" ");
        }
        else{
            printNodeFromK1ToK2(root.left, k1, root.data);
            if(root.data>=k1&&root.data<=k2)
            System.out.print(root.data+" ");
            printNodeFromK1ToK2(root.right, root.data, k2);
        }   
	}	
}

public class Print_Elements_in_Range {
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
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
		int k1 = s.nextInt();
		int k2 = s.nextInt();
		Print_in_Range.printNodeFromK1ToK2(root, k1, k2);
	}

}
