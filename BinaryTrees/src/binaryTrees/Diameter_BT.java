package binaryTrees;
import java.util.Scanner;
/*
Calculate Diameter
A diameter is the farthest distance  between two points.
In a binary tree diameter is the distance between two farthest nodes.
sample Input
1 2 3 4 5 -1 -1 8 -1 -1 6 9 -1 -1 7 -1 -1 -1 -1
Sample Output
1:L:2,R:3
2:L:4,R:5
3:L:-1,R:-1
4:L:8,R:-1
5:L:-1,R:6
8:L:9,R:-1
6:L:-1,R:7
9:L:-1,R:-1
7:L:-1,R:-1
diameter:6
Height:5
 */
class Pair<T,V> {
	public T first;
	public V second;
}
public class Diameter_BT {	
	public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root) {
		if (root == null) {
			Pair<Integer,Integer> output = new Pair<>();
			output.first = 0;
			output.second = 0;
			return output;
		}
		Pair<Integer, Integer> lo = heightDiameter(root.left);
		Pair<Integer, Integer> ro = heightDiameter(root.right);
		int height = 1 + Math.max(lo.first, ro.first);
		int option1 = lo.first + ro.first;
		int option2 = lo.second;
		int option3 = ro.second;
		int diameter = Math.max(option1, Math.max(option2, option3));		
		Pair<Integer,Integer> output = new Pair<>();
		output.first = height;
		output.second = diameter;
		return output;
	}
	
	public static int diameter(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		
		int option1 = height(root.left) + height(root.right);
		int option2 = diameter(root.left);
		int option3 = diameter(root.right);
		return Math.max(option1, Math.max(option2, option3));
	}
	
	public static int height(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int lh = height(root.left);
		int rh = height(root.right);
		return 1 + Math.max(lh, rh);
	}


	public static BinaryTreeNode<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = s.nextInt();
			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = s.nextInt();
			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
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
		BinaryTreeNode<Integer> root = takeInput();
		printLevelWise(root);
		System.out.println("diameter:" + heightDiameter(root).second);

		System.out.println("Height:" + heightDiameter(root).first);
	}
}
