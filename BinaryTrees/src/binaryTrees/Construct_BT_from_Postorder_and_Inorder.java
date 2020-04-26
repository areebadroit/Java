package binaryTrees;
import java.util.Scanner;
/*
Construct Tree from Postorder and Inorder
Send Feedback
Given Postorder and Inorder traversal of a binary tree, create the binary tree associated with the traversals.You just need to construct the tree and return the root.
Note: Assume binary tree contains only unique elements.
Input format :

Line 1 : n (Total number of nodes in binary tree)

Line 2 : Post order traversal

Line 3 : Inorder Traversal

Output Format :

Elements are printed level wise, each level in new line (separated by space).

Sample Input :
8
8 4 5 2 6 7 3 1
4 8 2 5 1 6 3 7
Sample Output :
1 
2 3 
4 5 6 7 
8
 */
class Index { 
	int index; 
} 
class Cnstrct_BT_Post_In {
	public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post, int[] in,  Index pIndex, int iStart, int iEnd){
		if(iEnd<iStart){
			return null;
		}

		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(post[pIndex.index]);
		int pos=0;
		(pIndex.index)--;
		if(iEnd==iStart){
			return root;
		}
		for(int i=iStart;i<=iEnd;i++){
			if(in[i]==root.data){
				pos=i;
				break;
			}
		}
		//int k=iEnd-pos;

		root.right=getTreeFromPostorderAndInorder(post, in, pIndex, pos+1, iEnd);
		root.left=getTreeFromPostorderAndInorder(post, in, pIndex, iStart, pos-1);
		return root;
	}
	public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post, int[] in){
		Index pIndex = new Index(); 
		pIndex.index =  post.length- 1; 
		return getTreeFromPostorderAndInorder(post, in, pIndex, 0, in.length-1);
	}
}

public class Construct_BT_from_Postorder_and_Inorder {
	static Scanner s = new Scanner(System.in);

	public static void printLevelWiseAtDiffLine(BinaryTreeNode<Integer> root){
		QueueUsingLL<BinaryTreeNode<Integer>>  primary = new QueueUsingLL<>();
		QueueUsingLL<BinaryTreeNode<Integer>>  secondary = new QueueUsingLL<>();

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
				QueueUsingLL<BinaryTreeNode<Integer>>  temp = secondary;
				secondary = primary;
				primary = temp;
				System.out.println();
			}
		}
	}


	public static void main(String[] args) {

		int size = s.nextInt();
		int[] pre = new int[size];
		for(int i = 0; i < size; i++){
			pre[i] = s.nextInt();
		}
		int in[] = new int[size];
		for(int i = 0; i < size; i++){
			in[i] = s.nextInt();
		}
		BinaryTreeNode<Integer> root = Cnstrct_BT_Post_In.getTreeFromPostorderAndInorder(pre, in);
		printLevelWiseAtDiffLine(root);

	}
}
