package trees;
import java.util.Scanner;
/*
Code : Pre-order and Post-order Traversal
Send Feedback
Given a generic tree, print the post-order traversal of given tree.
Post-order traversal is : Children and then Root
Input format :
Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Pre-order andPost-order traversal, elements separated by space
Sample Input :
10 3 20 30 40 2 400 50 0 0 0 0 
Sample Output :
Pre-Order Traversal
10 20 400 50 30 40 
Post-Order Traversal
400 50 20 30 40 10 
 */
class Pre_and_Post {
	public static void postOrder(TreeNode<Integer> root){
        if(root==null)
            return;
        for(int i=0;i<root.children.size();i++){
            postOrder(root.children.get(i));
        }
        System.out.print(root.data+" ");
        return;
	}
	public static void preOrder(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		for (int i = 0; i < root.children.size(); i++) {
			preOrder(root.children.get(i));
		}
	}
}

public class Pre_and_Post_Order_Traversal {
	static Scanner s = new Scanner(System.in);

	public static TreeNode<Integer> takeInputLevelWise(){
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
				int numChild = s.nextInt();
				for(int i = 0 ; i < numChild; i++){
					int currentChild = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
					pendingNodes.enqueue(childNode);
					currentNode.children.add(childNode);
				}
			} catch (QueueEmptyException e) {
			}
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode<Integer> root =  takeInputLevelWise();
		System.out.println("Pre-Order Traversal");
		Pre_and_Post.preOrder(root);
		System.out.println();
		System.out.println("Post-Order Traversal");
		Pre_and_Post.postOrder(root);
	}
}
