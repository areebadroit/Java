package binarySearchTree;
import java.util.Scanner;
/*
LCA of BST
Given a binary search tree and two nodes, find LCA(Lowest Common Ancestor) of the given two nodes in the BST. Read about LCA if you are having doubts about the definition.
If out of 2 nodes only one node is present, return that node.
If both are not present, return -1.
Input format :
Line 1 :  Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Two integers, Node 1 and Node 2 (separated by space)
Output Format :
LCA
Constraints :
1 <= N <= 1000
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 10
Sample Output 1:
8
Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 6
Sample Output 2:
5
Sample Input 3:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12 78
Sample Output 3:
-1
 */
class LCA_BST {

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

	public static int lcaInBST(BinaryTreeNode<Integer> root , int a , int b){
        if(root==null)
            return -1;
        if(a==root.data||b==root.data)
            return root.data;
        int l=-1,r=-1;
        if(a<root.data&&b<root.data)
            l=lcaInBST(root.left, a, b);
        else if(a>root.data&&b>root.data)
            r=lcaInBST(root.right, a, b);
        else{
            l=lcaInBST(root.left, a, b);
            r=lcaInBST(root.right, a, b);
        }
        if(l!=-1&&r==-1)
            return l;
        else if(l==-1&&r!=-1)
            return r;
        else if(l!=-1&&r!=-1)
            return root.data;
    return -1;
    }
}
public class LCA_of_BST {
	static Scanner s = new Scanner(System.in);
	  static int a;
	  static int b;
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
	     a = s.nextInt();
	     b = s.nextInt();
			return root;
		}

		public static void main(String[] args) {
			BinaryTreeNode<Integer> root = takeInput();

			System.out.println(LCA_BST.lcaInBST(root, a, b));
		}
}
