package binarySearchTree;
import java.util.Scanner;
/*
Search Node in BST
Given a BST and an integer k. Find if the integer k is present in given BST or not. Return the node with data k if it is present, return null otherwise.
Assume that BST contains all unique elements.
Input Format :
Line 1 : Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Integer k
Output Format :
Node with data k
Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
Sample Output 1 :
2
Sample Input 2 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 2 :
(empty)
 */
class SearchBST {
	public static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root , int k){
        if(root==null)
            return  null;
        if(root.data==k)
            return root;
        else if(k<root.data)
            root=searchInBST(root.left, k);
        else
             root=searchInBST(root.right, k);
        return root;
	}
}
public class Search_Node_in_BST {
	static Scanner s = new Scanner(System.in);
	public static BinaryTreeNode<Integer> takeInput(){
		Queue<BinaryTreeNode<Integer>>  pendingNodes = new Queue<BinaryTreeNode<Integer>>(); // we can skip writing again inside <> after java version 1.7 
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
		int k = s.nextInt();
		BinaryTreeNode<Integer> ans = SearchBST.searchInBST(root, k);
		if(ans != null) {
			System.out.println(ans.data);
		}
	}
}
