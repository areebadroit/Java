package trees;
import java.util.Scanner;
/*Code : Number of nodes greater than x
Given a tree and an integer x, find and return number of Nodes which are greater than x.
Input format :
Single Line : First Integer denotes x and rest of the elements in level order form separated by space. Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Count of nodes greater than x
Sample Input 1 :
35 10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
3
Sample Input 2 :
10 10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 2:
5
*/
//class containing logic
class Node_x {
	public static int numNodeGreater(TreeNode<Integer> root,int x){
        if(root==null)
            return 0;
        int count=0;
        if(root.data>x)
                count+=1;
        for(int i=0;i<root.children.size();i++){
            int smallAns=numNodeGreater(root.children.get(i),x);
            count+=smallAns;
        }
        return count;
	}
}
//Runner class and functions
 
public class Number_of_Nodes_greater_than_x {
	static Scanner s = new Scanner(System.in);
	public static TreeNode<Integer> takeInputLevelWise(){
	QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
//	System.out.println("Enter root Data");
	int rootData = s.nextInt();
	TreeNode<Integer> root = new TreeNode<Integer>(rootData);
	pendingNodes.enqueue(root);
	while(!pendingNodes.isEmpty()){
		TreeNode<Integer> currentNode;
		try {
		currentNode = pendingNodes.dequeue();
//					System.out.println("Enter number of children of "+currentNode.data);
		int numChild = s.nextInt();
		for(int i = 0 ; i < numChild; i++){
//						System.out.println("Enter "+ i + "th child of " + currentNode.data);
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
	    int x = s.nextInt();
	  	TreeNode<Integer> root =  takeInputLevelWise();
			System.out.println(Node_x.numNodeGreater(root, x));
		}
}
