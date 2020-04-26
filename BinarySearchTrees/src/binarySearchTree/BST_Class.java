package binarySearchTree;
import java.util.Scanner;
/*
BST Class
Implement the BST class which includes following functions -
1. search
Given an element, find if that is present in BSt or not. Return true or false.
2. insert -
Given an element, insert that element in the BST at the correct position. Assume unique elements will be given.
3. delete -
Given an element, remove that element from the BST. If the element which is to be deleted has both children, replace that with the minimum element from right sub-tree.
4. printTree (recursive) -
Print the BST in ithe following format -
For printing a node with data N, you need to follow the exact format -
N:L:x,R:y
where, N is data of any node present in the binary tree. x and y are the values of left and right child of node N. Print the children only if it is not null.
There is no space in between.
You need to print all nodes in the recursive format in different lines.
Note : main function is given for your reference which we are using internally to test the class.
Input:
1 20 1 40 1 30 1 70 1 15 1 65 1 35 1 25 3 40 2 40 3 40 3 65 -1
Output:
true
false
true
20:L:15,R:65
15:
65:L:30,R:70
30:L:25,R:35
25:
35:
70:

 */
/***************
 * BinaryTreeNode class already given - 
 * 
class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}
 ***************/

/**************
 * Main function that we are using internally 
 * 
public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int choice, input;
		while(true) {
			choice = s.nextInt();
			switch(choice) {
				case 1 : 
					input = s.nextInt();
					bst.insertData(input);
					break;
				case 2 : 
					input = s.nextInt();
					bst.deleteData(input);
					break;
				case 3 : 
					input = s.nextInt();
					System.out.println(bst.search(input));
					break;
				default :
					bst.printTree();
					return;
			}

		}
 *******************/

class BinarySearchTree {
	// Complete this class
	static BinaryTreeNode<Integer> root;

	public static BinaryTreeNode<Integer> insertData(BinaryTreeNode<Integer> root, int data){
		if (root == null) {
			BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(data);
			return newNode;
		}
		if (root.data > data) {
			root.left = insertData(root.left, data);
		} else {
			root.right = insertData(root.right, data);
		}
		return root;
	}

	public static void insertData(int data){
		root=insertData(root, data);
	}

	public static BinaryTreeNode<Integer> deleteData(BinaryTreeNode<Integer> root, int data){
		if (root == null) {
			return null;
		}
		if (data < root.data) {
			root.left = deleteData(root.left, data);
			return root;
		} else if (data > root.data) {
			root.right = deleteData(root.right, data);
			return root;
		} else {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				BinaryTreeNode<Integer> minNode = root.right;
				while (minNode.left != null) {
					minNode = minNode.left;
				}
				root.data = minNode.data;
				root.right = deleteData(root.right, minNode.data);
				return root;
			}
		}
	}

	public static void deleteData(int data){
		root=deleteData(root, data);
	}

	public static BinaryTreeNode<Integer> searchHelp(BinaryTreeNode<Integer> root, int q) {
		if (root == null) {
			return null;
		}
		if (root.data == q) {
			return root;
		} else if (root.data > q) {
			return searchHelp(root.left, q);
		} else {
			return searchHelp(root.right, q);
		}
	}

	public static boolean search(int data){
		BinaryTreeNode<Integer> result = searchHelp(root, data);
		if(result!=null)
			return true;
		return false;
	}

	public static void printHelp(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		String toBePrinted = root.data + ":";
		if (root.left != null) {
			toBePrinted += "L:" + root.left.data + ",";
		}

		if (root.right != null) {
			toBePrinted += "R:" + root.right.data;
		}
		System.out.println(toBePrinted);
		printHelp(root.left);
		printHelp(root.right);
	}

	public static void printTree(){
		printHelp(root);
	}
}

public class BST_Class {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int choice, input;
		while(true) {
			choice = s.nextInt();
			switch(choice) {
			case 1 : 
				input = s.nextInt();
				bst.insertData(input);
				break;
			case 2 : 
				input = s.nextInt();
				bst.deleteData(input);
				break;
			case 3 : 
				input = s.nextInt();
				System.out.println(bst.search(input));
				break;
			default :
				bst.printTree();
				return;
			}

		}
	}
}
