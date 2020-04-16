package linkedListAdvanced;
import java.util.Scanner;
/*
Reverse LL (Recursive)

Given a linked list, reverse it using recursion.
You don't need to print the elements, just reverse the LL duplicates and return the head of updated LL.
Input format : Linked list elements (separated by space and terminated by -1)`

Sample Input 1 :
1 2 3 4 5 -1
Sample Output 1 :
5 4 3 2 1
 */

class Reverse_Rec {
    static LinkedListNode<Integer> head;
	public static LinkedListNode<Integer> reverse_R(LinkedListNode<Integer> curr,LinkedListNode<Integer> prev) {
        if(curr.next==null){
            head=curr;
            curr.next=prev;
            return head;
        }
        LinkedListNode<Integer> val=curr.next;
        curr.next=prev;
        reverse_R(val,curr);
        return head;
	}
	public static LinkedListNode<Integer> reverse_R(LinkedListNode<Integer> head) {
		return reverse_R(head,null);
	}
}
public class Reverse_LL_Recursive {
	private static Scanner s= new Scanner(System.in);
	public static void main(String[] args) {
		print(Reverse_Rec.reverse_R(input()));
	}
	public static void print(LinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.getData() + " ");
			head = head.next;
		}
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
}
