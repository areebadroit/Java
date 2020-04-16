package linkedlistbasics2;
import java.util.*;
/*
Eliminate duplicates from LL

Given a sorted linked list (elements are sorted in ascending order). Eliminate duplicates from the given LL, such that output LL contains only unique elements.
You don't need to print the elements, just remove duplicates and return the head of updated LL.
Input format : Linked list elements (separated by space and terminated by -1)

Sample Input 1 :
1 2 3 3 3 4 4 5 5 5 7 -1
Sample Output 1 :
1 2 3 4 5 7
 */
class EliminateDuplicate {
	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp=head;
        if(temp==null)
            return temp;
        while(temp.next!=null){
            if(temp.data.equals(temp.next.data)){
                temp.next=temp.next.next;
            }else{
            temp=temp.next;
            }
        }
        return head;
    }
}
public class Eliminate_Duplicates_From_LL {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(EliminateDuplicate.removeDuplicates(input()));
	}

	public static void print(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.next;
		}
	}

	public static LinkedListNode<Integer> input() {
		int data = s.nextInt();

		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		while (data != -1) {
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
