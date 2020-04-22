package binaryTrees;
import java.util.Scanner;
/*
Construct Tree from Preorder and Inorder
Given Preorder and Inorder traversal of a binary tree, create the binary tree associated with the traversals.You just need to construct the tree and return the root.
Note: Assume binary tree contains only unique elements.
Input format :

Line 1 : n (Total number of nodes in binary tree)

Line 2 : Pre order traversal

Line 3 : Inorder Traversal

Output Format :

Elements are printed level wise, each level in new line (separated by space).

Sample Input :
12
1 2 3 4 15 5 6 7 8 10 9 12
4 15 3 2 5 1 6 10 8 7 9 12
Sample Output :
1 
2 6 
3 5 7 
4 8 9 
15 10 12
 */
class Cnstrct_BT_Pre_In {
    public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd){
         if(iEnd<iStart){
            return null;
        }
        
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(pre[pStart]);
        int pos=0;
       if(iEnd==iStart){
            return root;
        }
        for(int i=iStart;i<=iEnd;i++){
            if(in[i]==pre[pStart]){
                pos=i;
                break;
            }
        }
        int k=pos-iStart;
        	root.left=getTreeFromPreorderAndInorder(pre, in, pStart+1, pStart+k, iStart, pos-1);
        	root.right=getTreeFromPreorderAndInorder(pre, in, pStart+k+1, pEnd, pos+1, iEnd);
        return root;
	}
	public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre, int[] in){
        return getTreeFromPreorderAndInorder(pre, in, 0, pre.length-1, 0, in.length-1);
	}

}
public class Construct_BT_from_Preorder_and_Inorder {
	static Scanner s = new Scanner(System.in);

	public static void printLevelWiseAtDiffLine(BinaryTreeNode<Integer> root){
		if(root == null) {
			return;
		}
		QueueUsingLL<BinaryTreeNode<Integer>>  primary = new QueueUsingLL<BinaryTreeNode<Integer>>();
		QueueUsingLL<BinaryTreeNode<Integer>>  secondary = new QueueUsingLL<BinaryTreeNode<Integer>>();

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
		BinaryTreeNode<Integer> root = Cnstrct_BT_Pre_In.getTreeFromPreorderAndInorder(pre, in);
		printLevelWiseAtDiffLine(root);
		
	}
}
