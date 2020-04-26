package binarySearchTree;
import java.util.*;
/*
Pair sum in a BST
Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S. You can use extra space only O(log n).
Assume BST contains all unique elements.
Note: In a pair, print the smaller element first.
Input format:

Line 1: Elements in the level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Line 2: S

Output format: Each pair in a different line (pair elements separated by space)

Sample Input :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output
2 10
5 7
 */
class PairSumBST {
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
    static ArrayList<Integer> arr = new ArrayList<Integer>();
    public static void insertToArray(BinaryTreeNode<Integer> root){
        if(root==null)
            return;
        // arr.add(root.data);
        insertToArray(root.left);
        arr.add(root.data);
        insertToArray(root.right);
    }
	public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
		insertToArray(root);
		// Collections.sort(arr);
        int i=0,j=arr.size()-1;
        while(i<j){
            if(arr.get(i)+arr.get(j)==s){
                System.out.println(arr.get(i)+" "+arr.get(j));
                i+=1;
                j-=1;
            }else if((arr.get(i)+arr.get(j)<s)){
                i+=1;
            }else if((arr.get(i)+arr.get(j)>s)){
                j-=1;
            }
        }
	}
}
public class Pair_sum_BST {
	static Scanner s = new Scanner(System.in);
	  static int sum ;

		public static BinaryTreeNode<Integer> takeInput(){
			Queue<BinaryTreeNode<Integer>>  pendingNodes = new Queue<BinaryTreeNode<Integer>>(); // we can skip writing again inside <> after java version 1.7
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
	    sum = s.nextInt();
			return root;
		}
		public static void main(String[] args) {
			BinaryTreeNode<Integer> root = takeInput();
			PairSumBST.printNodesSumToS(root, sum);
		}
}
