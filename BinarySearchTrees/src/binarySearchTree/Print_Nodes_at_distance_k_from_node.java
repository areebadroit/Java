package binarySearchTree;
import java.util.ArrayList;
import java.util.Scanner;
class Nodes_at_k{
	public static int print(BinaryTreeNode<Integer> root,int elem,int k) {
		if(root==null)
			return -1;
		if(root.data==elem) {
			printNodesAtDepthK(root,k);
			return 0;
		}
		int lD=-1,rD=-1;
		lD=print(root.left,k,elem);
		if(lD==-1)
			rD=print(root.right,elem,k-lD-2);
		else {
			if(lD+1==k)
				System.out.println(root.data);
		}
		if(rD==-1)
			return -1;
		else {
			if(rD+1==k)
				System.out.println(root.data);
		}
		lD=print(root.left,elem,k-rD-2);
		return -1;
	}
	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
		// Write your code here
		print(root, node, k);
        
	}
	public static void printNodesAtDepthK(BinaryTreeNode<Integer> root,int k) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		if(k==0)
			System.out.println(root.data);
		printNodesAtDepthK(root.left,k-1);
		printNodesAtDepthK(root.right,k-1);
	}
}
public class Print_Nodes_at_distance_k_from_node {
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

		Nodes_at_k.nodesAtDistanceK(root, target, k);
//		Nodes_at_k.printNodesAtDepthK(root,k);
	}
}
