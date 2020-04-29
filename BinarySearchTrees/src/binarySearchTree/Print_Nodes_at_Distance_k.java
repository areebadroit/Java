package binarySearchTree;
import java.util.Scanner;
/*
Print nodes at distance k from node
Given a binary tree, a node and an integer K, print nodes which are at K distance from the the given node.
Input format :

Line 1 : Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Line 2 : Node

Line 3 : K

Output format : Answer nodes in different line

Sample Input :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
3
1
Sample Output :
9
6
 */
class Nodes_at_Distance_K {
    public static int print(BinaryTreeNode<Integer> root,int elem,int k) {
		if(root==null)
			return -1;
		if(root.data==elem) {
			printNodesAtDepthK(root,k);
			return 0;
		}
		int lD=-1,rD=-1;
		lD=print(root.left,elem,k);
        if(lD!=-1){
			if(lD+1==k){
				System.out.println(root.data);
                }else{
                printNodesAtDepthK(root.right,k-lD-2);
                }
                return 1+lD;
		}
        rD=print(root.right,elem,k);
        
        if(rD!=-1){
			if(rD+1==k){
				System.out.println(root.data);
                }else{
                printNodesAtDepthK(root.left,k-rD-2);
                }
                return 1+rD;
		}
		return -1;
	}
	
	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        print(root, node, k);
        
	}
    public static void printNodesAtDepthK(BinaryTreeNode<Integer> root,int k) {
		// TODO Auto-generated method stub
		if(root==null||k<0)
			return;
		if(k==0){
			System.out.println(root.data);
            return;
        }
        	
		printNodesAtDepthK(root.left,k-1);
		printNodesAtDepthK(root.right,k-1);
	}
}

public class Print_Nodes_at_Distance_k {
	static Scanner s = new Scanner(System.in);
	static int target;
	static int k;
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
		target = s.nextInt();
		k = s.nextInt();
		return root;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();

		Nodes_at_Distance_K.nodesAtDistanceK(root, target, k);
	}
}
