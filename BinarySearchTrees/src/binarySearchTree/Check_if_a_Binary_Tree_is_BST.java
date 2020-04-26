package binarySearchTree;
import java.util.Scanner;
/*
Check if a Binary Tree is BST
Given a binary tree with N number of nodes, check if that input tree is BST (Binary Search Tree) or not. If yes, return true, return false otherwise.
Duplicate elements should be in right subtree.
Input format :
Line 1 : Nodes in level order form (separated by space). If any node does not have left or right child, take -1 in its place
Output format :
true or false
Constraints :
1 <= N <= 10^5
Sample Input 1 :
3 1 5 -1 2 -1 -1 -1 -1
Sample Output 1 :
true
Sample Input 2 :
5 2 10 0 1 -1 15 -1 -1 -1 -1 -1 -1
Sample Output 2 :
false
 */
class triplet<T,U,V>{
    T isBalanced;
    U minimum;
    V maximum;
}
class CheckBT_for_BST {
    public static triplet isBSTHelp(BinaryTreeNode<Integer> root) {
        if(root==null){
            triplet<Boolean, Integer, Integer> ob = new triplet<>();
            ob.isBalanced = true;
            ob.minimum=Integer.MAX_VALUE;
            ob.maximum=Integer.MIN_VALUE;
            return ob;
        }
        triplet<Boolean, Integer, Integer> leftOutput = isBSTHelp(root.left);
        triplet<Boolean, Integer, Integer> rightOutput = isBSTHelp(root.right);
        int min = Math.min(root.data, Math.min(leftOutput.minimum, rightOutput.minimum));
		int max = Math.max(root.data, Math.max(leftOutput.maximum, rightOutput.maximum));
        boolean ifBST = (root.data > leftOutput.maximum) 
				&& (root.data <= rightOutput.minimum)
				&& leftOutput.isBalanced && rightOutput.isBalanced;
        triplet<Boolean, Integer, Integer> ob = new triplet<>();
        ob.isBalanced = ifBST;
        ob.minimum=min;
        ob.maximum=max;
        return ob;
	}
	public static boolean isBST(BinaryTreeNode<Integer> root) {
        triplet<Boolean, Integer, Integer> result = isBSTHelp(root);
        return result.isBalanced;
	}
}
public class Check_if_a_Binary_Tree_is_BST {
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

	public static void printLevelWiseAtDiffLevel(BinaryTreeNode<Integer> root){
		QueueUsingLL<BinaryTreeNode<Integer>>  primary = new QueueUsingLL<BinaryTreeNode<Integer>>();
		QueueUsingLL<BinaryTreeNode<Integer>>  secondary = new QueueUsingLL<BinaryTreeNode<Integer>>();

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
		System.out.println(CheckBT_for_BST.isBST(root));
	}

}
