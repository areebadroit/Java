package linkedListAdvanced;
import java.util.Scanner;

/*
Midpoint of Linked list

Given a linked list, find and return the midpoint.
If the length of linked list is even, return the first mid point.
Input format : Linked list elements (separated by space and terminated by -1)`

Sample Input 1 :
1 2 3 4 5 -1
Sample Output 1 :
3
Sample Input 2 :
1 2 3 4 -1
Sample Output 2 :
2
 */

class Midpoint {
	public static int printMiddel(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow=head;
        LinkedListNode<Integer> fast=head;
        LinkedListNode<Integer> temp=head;
        int count=1;
        while(temp.next!=null){
            count+=1;
           temp=temp.next;
            }
        if(count%2==0){
            fast=fast.next;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }
}
public class Midpoint_of_LinkedList {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(Midpoint.printMiddel(input()) + "");
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
