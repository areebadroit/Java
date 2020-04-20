package binaryTrees;
import java.util.Scanner;
/*
Print Tree Level Wise
Given a binary tree, print the tree in level wise order.
For printing a node with data N, you need to follow the exact format -
N:L:x,R:y
where, N is data of any node present in the binary tree. x and y are the values of left and right child of node N. Print -1. if any child is null.
There is no space in between.
You need to print all nodes in the level order form in different lines.
Input format :
Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Sample Input :
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output :
8:L:3,R:10
3:L:1,R:6
10:L:-1,R:14
1:L:-1,R:-1
6:L:4,R:7
14:L:13,R:-1
4:L:-1,R:-1
7:L:-1,R:-1
13:L:-1,R:-1
 */
class Print_BT_Level_Wise {

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
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		if (root == null) {
			return;
		}
		pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front;
			try {
				front = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return;
			}
            if(front.left!=null&&front.right!=null){
        		System.out.println(front.data+":L:"+front.left.data+",R:"+front.right.data);
                pendingNodes.enqueue(front.left);
                pendingNodes.enqueue(front.right);
            }
            else if(front.right==null&&front.left!=null){
                System.out.println(front.data+":L:"+front.left.data+",R:-1");
            	pendingNodes.enqueue(front.left);
            }
            else if(front.left==null&&front.right!=null){
                System.out.println(front.data+":L:-1,R:"+front.right.data);
                pendingNodes.enqueue(front.right);
            }
            else
            	System.out.println(front.data+":L:-1,R:-1");
        }
    }
}

public class Print_Tree_Level_Wise {
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
		Print_BT_Level_Wise.printLevelWise(root);
	}
}
