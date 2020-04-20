package trees;
import java.util.Scanner;
/*
Second Largest Element In Tree
Given a generic tree, find and return the node with second largest value in given tree. Return NULL if no node with required value is present.
Input format :
Elements in level order form separated by space (as per done in class). Order is - 

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output format:
Second Largest node data
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
40
 */
class res{
    int largest;
    int seclargest;
}
class Sec_Largest {

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
    
    static TreeNode<Integer> addr=null;
    public static TreeNode<Integer> checkIfContainsX(TreeNode<Integer> root, int x){
        if(root==null)
            return null;
        if(root.data==x){
            addr=root;
            return addr;
        }
        for(int i=0;i<root.children.size();i++){
            addr=checkIfContainsX(root.children.get(i),x);
        }
        return addr;
    }
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        res answer=findSecondLargestHelp(root);
        TreeNode<Integer> address=checkIfContainsX(root, answer.seclargest);
        //System.out.println(answer.seclargest);
        
        return address;
	}
	public static res findSecondLargestHelp(TreeNode<Integer> root){
        res ans=new res();
        if(root==null){
            ans.largest=0;
        	ans.seclargest=0;
            return ans;
        }
        ans.largest=root.data;
        ans.seclargest=0;
        for(int i=0;i<root.children.size();i++){
            	res ob=findSecondLargestHelp(root.children.get(i));
            if(ans.seclargest==0&&ob.seclargest==0){
                if(ans.largest<ob.largest){
                    int x=ans.largest;
                    ans.largest=ob.largest;
                    ans.seclargest=x;
                }else if(ans.largest==ob.largest){
                    ans.seclargest=0;
                }else{
                    ans.seclargest=ob.largest;
                }
            }else if(ans.seclargest==0||ob.seclargest==0){
                if(ans.largest<ob.largest){
                    int x=ans.largest;
                    ans.largest=ob.largest;
                    ans.seclargest=x;
                    if(ans.seclargest<ob.seclargest)
                    	ans.seclargest=ob.seclargest;
                }else if(ans.largest==ob.largest){
                    if(ans.seclargest<ob.seclargest)
                    	ans.seclargest=ob.seclargest;
                }
                else{
                    if(ans.seclargest==0||ans.seclargest<ob.largest)
                        ans.seclargest=ob.largest;
                }
            }else{
                 if(ans.largest<=ob.largest){
                    int x=ans.largest;
                    ans.largest=ob.largest;
                    ans.seclargest=x;
                     if(ans.seclargest<ob.seclargest)
                    	ans.seclargest=ob.seclargest;
                }else if(ans.largest==ob.largest){
                    if(ans.seclargest<ob.seclargest)
                    	ans.seclargest=ob.seclargest;
                }
                else{
                    if(ans.seclargest<ob.largest)
                        ans.seclargest=ob.largest;
                }
            }
        }//end of for loop
        return ans;
	}
	
}

public class Second_Largest_Element_In_Tree {
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
		TreeNode<Integer> ans = Sec_Largest.findSecondLargest(root);
		if(ans == null){
			System.out.println(Integer.MIN_VALUE);
		}else{
			System.out.println(ans.data);
		} 
	}
}
