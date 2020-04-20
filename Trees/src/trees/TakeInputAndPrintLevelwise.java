package trees;
import java.util.*;
public class TakeInputAndPrintLevelwise {
	public static TreeNode<Integer> takeInputLevelWise() {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while (!pendingNodes.isEmpty()) {
			try {
				TreeNode<Integer> frontNode = pendingNodes.dequeue();
				System.out.println("Enter num of children of " + frontNode.data);
				int numChildren = s.nextInt();
				for (int i = 0; i < numChildren; i++) {
					System.out.println("Enter " + (i + 1) + "th child of " + frontNode.data);
					int child = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(child);
					frontNode.children.add(childNode);
					pendingNodes.enqueue(childNode);
				}
			} catch (QueueEmptyException e) {
				// Shouldn't come here
				s.close();
				return null;
			}
		}
		s.close();
		return root;
	}
	/*
	Print Level Wise

	Given a generic tree, print the input tree in level wise order. 
	That is, print the elements at same level in one line (separated by space). Print different levels in differnet lines.
	Input format :
	Elements in level order form separated by space (as per done in class). Order is - 
	Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
	Output Format :
	Level wise print
	Sample Input :
	10 3 20 30 40 2 40 50 0 0 0 0 
	Sample Output :
	10
	20 30 40 
	40 50
	*/
	public static void printLevelWise(TreeNode<Integer> root){
		if(root == null) {
            return;
        }
        QueueUsingLL<TreeNode<Integer>> q = new QueueUsingLL<TreeNode<Integer>>();
        TreeNode<Integer> nullNode = new TreeNode<Integer>(Integer.MIN_VALUE);
        q.enqueue(root);
        q.enqueue(nullNode);
        System.out.println(root.data);
        while(q.size()!=1) {
            TreeNode<Integer> temp= null;
            try {
                temp = q.dequeue();
            } catch (QueueEmptyException e) {
            }
            if(temp==nullNode) {
                q.enqueue(nullNode);
                System.out.println();
                continue;
            }
            for(int i = 0;i<temp.children.size();++i) {
                System.out.print(temp.children.get(i).data+" ");
                q.enqueue(temp.children.get(i));
            }
        }
    }
	public static void main(String[] args) {
		TreeNode<Integer> root = takeInputLevelWise();
		printLevelWise(root);
	}
}
