package binarySearchTree;
import java.util.Scanner;
/*
Create & Insert Duplicate Node
Given a Binary Tree with N number of nodes, for each node create a new duplicate node, and insert that duplicate as left child 
of the original node.
Note : Root will remain same. So you just need to insert nodes in the given Binary Tree and no need to print or return anything.
Input format :
Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Output Format :
Level order traversal of updated tree. (Every level in new line)
Constraints :
1 <= N <= 1000
Sample Input :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output :
8 
8 10 
5 10 
5 6 
2 6 7 
2 7
 */
class Create_and_Insert {
	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        if(root==null)
            return;
        BinaryTreeNode<Integer> newNode=null;
        if(root.left!=null){
            BinaryTreeNode<Integer> temp = root.left;
            newNode = new BinaryTreeNode<>(root.data);
            root.left=newNode;
            newNode.left=temp;
            insertDuplicateNode(newNode.left);
        }else{
        	root.left=new BinaryTreeNode<>(root.data);
        	// insertDuplicateNode(newNode.left);
        }
        insertDuplicateNode(root.right);
	}
}
public class Create_and_Insert_Duplicate_Node {
	static Scanner s = new Scanner(System.in);

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
		return root;
	}
	public static void printLevelWiseAtDiffLevel(BinaryTreeNode<Integer> root){
		Queue<BinaryTreeNode<Integer>> primary = new Queue<BinaryTreeNode<Integer>>();
		Queue<BinaryTreeNode<Integer>> secondary = new Queue<BinaryTreeNode<Integer>>();

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
				Queue<BinaryTreeNode<Integer>>  temp = secondary;
				secondary = primary;
				primary = temp;
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		Create_and_Insert.insertDuplicateNode(root);
		printLevelWiseAtDiffLevel(root);
	}
}
