package binaryTrees;
import java.util.Scanner;
public class Count_Nodes_BT {

	public static int countNodes(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int ans = 1;
		ans += countNodes(root.left);
		ans += countNodes(root.right);
		return ans;
	}
	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		Scanner s = new Scanner(System.in);
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		
		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front;
			try {
				front = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			System.out.println("Enter left child of " + front.data);
			int leftChild = s.nextInt();
			if (leftChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
				pendingNodes.enqueue(child);
				front.left = child;
			}
			
			System.out.println("Enter right child of " + front.data);
			int rightChild = s.nextInt();
			if (rightChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
				pendingNodes.enqueue(child);
				front.right = child;
			}
		}
		return root;
	}
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
	
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		printLevelWise(root);
		System.out.println("Total No of Nodes:"+countNodes(root));
	}
}
