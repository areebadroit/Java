package linkedListAdvanced;
import java.util.Scanner;
/*
Code : Merge two sorted LL

Given two linked lists sorted in increasing order. Merge them in such a way that the result list is also sorted (in increasing order).
Try solving with O(1) auxiliary space (in-place). You just need to return the head of new linked list, don't print the elements.
Input format :
Line 1 : Linked list 1 elements of length n (separated by space and terminated by -1)
Line 2 : Linked list 2 elements of length m (separated by space and terminated by -1)
Output format :
Merged list elements (separated by space)
Constraints :
1 <= n, m <= 10^4
Sample Input :
 2 5 8 12 -1
 3 6 9 -1
Sample Output :
 2 3 5 6 8 9 12 
 */
class Merge {

	public static LinkedListNode<Integer> mergeTwoList(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
		LinkedListNode<Integer> t1=head1;
        LinkedListNode<Integer> t2=head2;
        LinkedListNode<Integer> h3;
        LinkedListNode<Integer> t3;
        if(t1.data<t2.data){
                h3=t1;
                t1=t1.next;
            }else{
                h3=t2;
                t2=t2.next;
            }
        t3=h3;
        while(t1!=null&&t2!=null){
            if(t1.data.intValue()<=t2.data.intValue()){
                t3.next=t1;
                t1=t1.next;
            }else{
                t3.next=t2;
                t2=t2.next;
            }
            t3=t3.next;
        }
        if(t1==null){
            t3.next=t2;
        }else{
            t3.next=t1;
        }
        return h3;
	}

}
public class Merge_Two_Sorted_LL {
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
	
	public static void print(LinkedListNode<Integer> head){
		while(head != null){
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LinkedListNode<Integer> head1 = takeInput();
		LinkedListNode<Integer> head2 = takeInput();
		LinkedListNode<Integer> head3 = Merge.mergeTwoList(head1, head2);
		print(head3);
	}
}
