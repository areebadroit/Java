package linkedListAdvanced;
import java.util.Scanner;

/*
Find a node in LL (recursive)

Given a linked list and an integer n you need to find and return index where n is present in the LL. Do this recursively.
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

class FindNode {
	public static int indexOfNRec(LinkedListNode<Integer> head, int n) {
        LinkedListNode<Integer> temp=head;
        int count=0;
        if(head==null)
            return -1;
		while(temp!=null){
            if(temp.data.equals(n)){
                return count;
            }
            count++;
            temp=temp.next;
        }
        return -1;
        
	}
}
public class Find_a_Node_in_LL_Rec {
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
		System.out.println(FindNode.indexOfNRec(head, n));
	}
}
