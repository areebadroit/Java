package binaryTrees;
import java.util.*;
/*
ZigZag tree
Given a binary tree, print the zig zag order i.e print level 1 from left to right, level 2 from right to left and so on. This means odd levels should get printed from left to right and even level right to left.
Input format :

Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Output Format :

Elements are printed level wise, each level in new line (separated by space).

Sample Input :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output :
5
10 6
2 3
9
 */
class ZigZag {

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

	public static void printZigZag(BinaryTreeNode<Integer> root) {
        if(root==null)
            return;
        Stack<BinaryTreeNode<Integer>> st1 = new Stack<>();
        Stack<BinaryTreeNode<Integer>> st2 = new Stack<>();
        st1.push(root);
        int flag=0;
        while(!st1.isEmpty()||!st2.isEmpty()){
        if(flag==0){
        while(!st1.isEmpty()){
            BinaryTreeNode<Integer> temp = st1.pop();
            System.out.print(temp.data+" ");
            if(temp.left!=null)
            	st2.push(temp.left);
            if(temp.right!=null)
            	st2.push(temp.right);
        }
        flag=1;
        System.out.println();
        }
        else{
        while(!st2.isEmpty()){
            BinaryTreeNode<Integer> temp = st2.pop();
            System.out.print(temp.data+" ");
            if(temp.right!=null)
            	st1.push(temp.right);
            if(temp.left!=null)
            	st1.push(temp.left);
        }
        flag=0;
        System.out.println();   
        }
	}
    }
}
public class ZigZag_BT {
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
		ZigZag.printZigZag(root);
	}
}
