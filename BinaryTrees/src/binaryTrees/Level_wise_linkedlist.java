package binaryTrees;
import java.util.ArrayList;
import java.util.Scanner;
/*
Level wise linkedlist
Given a binary tree, write code to create a separate linked list for each level. You need to return the array which contains head of each level linked list.
Input format :

Elements in level order form (separated by space). If any node does not have left or right child, take -1 in its place.

Output format : Each level linked list is printed in new line (elements separated by space).

Sample Input :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output :
5 
6 10 
2 3 
9
 */
class Level_wise {

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

	/* class Node<T> {
		T data;
		Node<T> next;
		Node(T data){
			this.data = data;
		}
	}
*/
	public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) {
        ArrayList<Node<BinaryTreeNode<Integer>>> result= new ArrayList<Node<BinaryTreeNode<Integer>>>();
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        BinaryTreeNode<Integer> front=null;
        Node<BinaryTreeNode<Integer>> head=null;
        Node<BinaryTreeNode<Integer>> rear=null;
        Node<BinaryTreeNode<Integer>> temp=null;
        BinaryTreeNode<Integer> nullNode = new BinaryTreeNode<Integer>(Integer.MIN_VALUE);
		if (root == null) {
			return result;
		}
		//pendingNodes.enqueue(root);
        temp=new Node<BinaryTreeNode<Integer>>(root);
        head=temp;
        rear=temp;
        result.add(head);
        pendingNodes.enqueue(nullNode);
        if(root.left!=null)
            pendingNodes.enqueue(root.left);
        if(root.right!=null)
            pendingNodes.enqueue(root.right);
         
        while (!pendingNodes.isEmpty()) {
			
			try {
				front = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				
			}
            if(front==nullNode) {
                if(pendingNodes.isEmpty())
                    break;
                else{
                    pendingNodes.enqueue(nullNode);
                    try {
                        front = pendingNodes.dequeue();
                    } catch (QueueEmptyException e) {

                    }
                    temp=new Node<BinaryTreeNode<Integer>>(front);
                    head=temp;
                    rear=temp;
                    result.add(head);
                    if(front.left!=null)
                        pendingNodes.enqueue(front.left);
                    if(front.right!=null)
                        pendingNodes.enqueue(front.right);
                }
            }
            else if(front.left!=null&&front.right!=null){
        		temp=new Node<BinaryTreeNode<Integer>>(front);
                rear.next=temp;
                rear=temp;
                pendingNodes.enqueue(front.left);
                pendingNodes.enqueue(front.right);
            }
            else if(front.right==null&&front.left!=null){
                temp=new Node<BinaryTreeNode<Integer>>(front);
                rear.next=temp;
                rear=temp;
                pendingNodes.enqueue(front.left);
            }
            else if(front.left==null&&front.right!=null){
                temp=new Node<BinaryTreeNode<Integer>>(front);
                rear.next=temp;
                rear=temp;
                pendingNodes.enqueue(front.right);
            }
            else{
                temp=new Node<BinaryTreeNode<Integer>>(front);
                rear.next=temp;
                rear=temp;
            }
        }
    return result;
	}
}

public class Level_wise_linkedlist {
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
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
		ArrayList<Node<BinaryTreeNode<Integer>>> output = Level_wise.LLForEachLevel(root);
		for(Node<BinaryTreeNode<Integer>> head : output){
			Node<BinaryTreeNode<Integer>> temp = head;
			while(temp != null){
				System.out.print(temp.data.data + " ") ;
				temp = temp.next;
			}
			System.out.println();
		}
	}
}
