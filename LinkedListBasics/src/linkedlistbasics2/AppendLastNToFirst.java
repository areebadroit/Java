package linkedlistbasics2;
import java.util.*;
/*AppendLastNToFirst

Given a linked list and an integer n, append the last n elements of the LL to front.
Indexing starts from 0. You don't need to print the elements, just update the elements and return the head of updated LL.
Assume given n will be smaller than length of LL.
Input format :

Line 1 : Linked list elements (separated by space and terminated by -1)`

Sample Input 1 :
1 2 3 4 5 -1
3
Sample Output 1 :
3 4 5 1 2
*/
class Append {
	public static LinkedListNode<Integer> append(LinkedListNode<Integer> root, int n) {
        int len=1;
        LinkedListNode<Integer> temp=root;//temporaray reference for traversing and modifying the linked list
        LinkedListNode<Integer> start=root;
        while(temp.next!=null){//calculating the length of linklist
            len++;
            temp=temp.next;
        }
        temp=root;
        for(int i=0;i<len-n-1;i++){
            temp=temp.next;
        }
        root=temp.next;//head of updated list
        temp.next=null;//linklist extracted from the beginning last node set to null
        temp=root;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=start;//appending the first extracted list to the last of new list
        return root;
    }
}

public class AppendLastNToFirst {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(Append.append(input(), s.nextInt()));
	}

	public static LinkedListNode<Integer> input() {
		int data = s.nextInt();
		
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		while (data!=-1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}

	public static void print(LinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.getData() + " ");
			head = head.next;
		}
}
}
