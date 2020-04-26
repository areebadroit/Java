package binarySearchTree;
import java.util.Scanner;
/*
BST to Sorted LL
Given a BST, convert it into a sorted linked list. Return the head of LL.
Input format :
Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Output Format :
Linked list elements (separated by space)
Sample Input :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output :
2 5 6 7 8 10
 */
class ConstructBST_from_LinkedList{
	public static LinkedListNode<Integer> BSTToSortedLL(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return null;
		}
		LinkedListNode<Integer> head=BSTToSortedLL(root.left);
		LinkedListNode<Integer> mid=BSTToSortedLL(root.right);
		if(head==null)
		{
			head=new LinkedListNode<Integer>(root.data);
			head.next=mid;
			return head;
		}
		LinkedListNode<Integer> temp=head;
		while(temp.next!=null)
		{
			temp=temp.next;
		}

		LinkedListNode<Integer> rt=new LinkedListNode<Integer>(root.data);
		temp.next=rt;
		rt.next=mid;
		return head;


	}
}	
public class Construct_BST_From_LinkedList {
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
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
		LinkedListNode<Integer> ans = ConstructBST_from_LinkedList.BSTToSortedLL(root);
		while(ans != null) {
			System.out.print(ans.data + " ");
			ans = ans.next;
		}
	}
}
