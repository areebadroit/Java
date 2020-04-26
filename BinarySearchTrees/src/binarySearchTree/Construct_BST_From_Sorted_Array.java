package binarySearchTree;
import java.util.Scanner;
/*
Construct BST From Sorted Array
Given a sorted integer array A of size n which contains all unique elements. You need to construct a balanced BST from this input array. Return the root of constructed BST.
Note : If array size is even, take first mid as root.
Input format :
Line 1 : Integer n (Size of array)
Line 2 : Array elements (separated by space)
Output Format :
BST elements (in pre order traversal, separated by space)
Sample Input :
7
1 2 3 4 5 6 7
Sample Output :
4 2 1 3 6 5 7 
 */
class ConstructBST_from_Array {
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int sI, int eI){
        BinaryTreeNode<Integer> root=null;
        if(eI<sI)
            return root;
        if(eI==sI){
            root = new BinaryTreeNode<>(arr[sI]);
        }
        if(eI>sI){
            int mid = sI+(eI-sI)/2;
            root = new BinaryTreeNode<>(arr[mid]);
            root.left=SortedArrayToBST(arr, sI, mid-1);
            root.right=SortedArrayToBST(arr, mid+1, eI);
        }
        return root;
	}
	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr){
        return SortedArrayToBST(arr, 0, arr.length-1);
	}
}	
public class Construct_BST_From_Sorted_Array {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int len = sc.nextInt();
		int[] arr = new int[len];
		for(int i = 0; i < len; ++i) {
			arr[i] = sc.nextInt();
		}
		BinaryTreeNode<Integer> ans = ConstructBST_from_Array.SortedArrayToBST(arr);
		
		preOrder(ans);
	}
	
	private static void preOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
}
