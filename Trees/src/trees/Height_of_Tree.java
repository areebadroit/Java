package trees;
import java.util.Scanner;
/*
Code : Find Height
Given a generic tree, find and return the height of given tree.
Input format :
Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Height
Sample Input :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output :
3
 */
class Find_Height {
	public static int height(TreeNode<Integer> root){
        if(root==null)
            return 0;
        int height=1;
        int max=0;
        for(int i=0;i<root.children.size();i++){
            int smallAns=height(root.children.get(i));
            if(smallAns>max)
                max=smallAns;
        }
        return height+max;
	}

}
public class Height_of_Tree {
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
		System.out.println(Find_Height.height(root));

	}
}
