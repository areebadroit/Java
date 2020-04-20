package trees;
import java.util.Scanner;
/*
Replace node with depth
In a given Generic Tree, replace each node with its depth value. You need to just update the data of each node, no need to return or print anything.
Input format :

Line 1 : Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 : (Level wise, each level in new line)
0 
1 1 1 
2 2
 */

class Replace_Node {

/*	TreeNode structure 
 * 
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/
	//Alternate Solution
	// public static void replaceWithDepthValue(TreeNode<Integer> root){
	// if(root == null) {
	// return;
	// }
	// QueueUsingLL<TreeNode<Integer>> q = new QueueUsingLL<TreeNode<Integer>>();
	// TreeNode<Integer> nullNode = new TreeNode<Integer>(Integer.MIN_VALUE);
	// q.enqueue(root);
	// q.enqueue(nullNode);
	// root.data=0;
	// int change=1;
	// while(q.size()!=1) {
	// TreeNode<Integer> temp= null;
	// try {
	// temp = q.dequeue();
	// } catch (QueueEmptyException e) {
	// }
	// if(temp==nullNode) {
	// change+=1;
	// q.enqueue(nullNode);
	// System.out.println();
	// continue;
	// }
	// for(int i = 0;i<temp.children.size();++i) {
	// temp.children.get(i).data=change;
	// q.enqueue(temp.children.get(i));
	// }
	// }
	// }
    public static void replaceWithDepthValue(TreeNode<Integer> root){
        if(root==null)
            return;
        replaceWithDepthValueHelp(root, 0);
    }
    public static void replaceWithDepthValueHelp(TreeNode<Integer> root, int x){
        root.data=x;
        for(int i=0;i<root.children.size();i++){
            replaceWithDepthValueHelp(root.children.get(i), x+1);
        }
        return;
    }
}
public class Replace_Node_with_depth {
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

  public static void printTreeLevelWise(TreeNode<Integer> root){
  		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();
  		pendingNodes.enqueue(root);
  		pendingNodes.enqueue(null);
  		while(!pendingNodes.isEmpty()){
  			TreeNode<Integer> currentNode;
  			try {
  				currentNode = pendingNodes.dequeue();
  				if(currentNode==null){
  					System.out.println();
  					if(!pendingNodes.isEmpty()){
  						pendingNodes.enqueue(null);
  						continue;
  					}else{
  						break;
  					}
  				}
  				System.out.print(currentNode.data+" ");
  				int numChild = currentNode.children.size();
  				for(int i = 0 ; i < numChild; i++){
  					pendingNodes.enqueue(currentNode.children.get(i));
  				}

  			} catch (QueueEmptyException e) {
  			}
  		}
  	}
// Test case will have tree printed -
	public static void main(String[] args) {
		TreeNode<Integer> root =  takeInputLevelWise();
		Replace_Node.replaceWithDepthValue(root);
		printTreeLevelWise(root);
	}
}
