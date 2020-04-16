package linkedListBasics;
/*
Given a linked list and an integer n you need to find and return index where n is present in the LL. Do this iteratively.
Return -1 if n is not present in the LL.
Indexing of nodes starts from 0.
Input format :
Line 1 : Linked list elements (separated by space and terminated by -1)
Line 2 : Integer n 
Output format :
Index
Sample Input 1 :
3 4 5 2 6 1 9 -1
5
Sample Output 1 :
2
Sample Input 2 :
3 4 5 2 6 1 9 -1
6
Sample Output 2 :
4
*/
import java.util.Scanner;
class FindNode {
	public static int indexOfNIter(LinkedListNode<Integer> head, int n) {
        int i=0;
        int p=-1;
        LinkedListNode<Integer> temp=head;
        while(temp.next!=null){
            if(temp.data==n){
                p=i;
                return p;
            }
            temp=temp.next;
            i++;
        }
        if(temp.next==null&&temp.data==n){
            p=i++;
        }
        return p;
	}
}
public class Find_a_Node_in_LL {
static Scanner s = new Scanner(System.in);
	
	public static LinkedListNode<Integer> takeInput() {
		LinkedListNode<Integer> head = null, tail = null;
		int data = s.nextInt();
		while(data != -1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}
	

	
	public static void main(String[] args) {
		LinkedListNode<Integer> head = takeInput();
		int n = s.nextInt();
		System.out.println(FindNode.indexOfNIter(head, n));
	}
}
