package binaryTrees;
import java.util.*;
/*
Pair sum Binary Tree
Given a binary tree and an integer S, print all the pair of nodes whose sum equals S.
Assume binary tree contains all unique elements.
Note : In a pair, print the smaller element first. Order of different pair doesn't matter.
Input format :
Line 1 : Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Integer S
Output Format :
Each pair in different line (pair elements separated by space)
Constraints :
1 <= N <= 1000
Sample Input 1:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
15
Sample Output 1:
5 10
6 9
 */
class PairSum {

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
        arr.add(root.data);
        insertToArray(root.left);
        insertToArray(root.right);
    }
	public static void nodesSumToS(BinaryTreeNode<Integer> root, int sum) {
		// Write your code here
        insertToArray(root);
		Collections.sort(arr);
        int i=0,j=arr.size()-1;
        while(i<j){
            if(arr.get(i)+arr.get(j)==sum){
                System.out.println(arr.get(i)+" "+arr.get(j));
                i+=1;
                j-=1;
            }else if((arr.get(i)+arr.get(j)<sum)){
                i+=1;
            }else if((arr.get(i)+arr.get(j)>sum)){
                j-=1;
            }
        }
	}
}
public class Pair_sum_BinaryTree {
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
			PairSum.nodesSumToS(root, sum);
		}
}
