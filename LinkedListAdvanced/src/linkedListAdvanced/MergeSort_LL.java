package linkedListAdvanced;
import java.util.Scanner;

/*
Merge Sort

Sort a given linked list using Merge Sort.
You don't need to print the elements, just sort the elements and return the head of updated LL.
Input format :
Linked list elements (separated by space and terminated by -1)
Output format :
Updated LL elements (separated by space)
Constraints :
1 <= Length of LL <= 1000
Sample Input 1 :
1 4 5 2 -1
Sample Output 1 :
1 2 4 5
 */

class MergeSort {

    public static LinkedListNode<Integer> printMiddle(LinkedListNode<Integer> head) {
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
        LinkedListNode<Integer> mid=slow.next;
        slow.next=null;
        return mid;
    }
    public static LinkedListNode<Integer> mergeTwoList(LinkedListNode<Integer> head1,
                                                       LinkedListNode<Integer> head2) {
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
    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
        // write your code here
        LinkedListNode<Integer> temp=head;
        if(head==null||head.next==null){
            return head;
        }
        LinkedListNode<Integer> mid=printMiddle(temp);
        LinkedListNode<Integer> front=temp;
        LinkedListNode<Integer> back=mid;
        front=mergeSort(front);
        back=mergeSort(back);
        return mergeTwoList(front, back);
    }
}

public class MergeSort_LL {
	private static Scanner s = new Scanner(System.in);

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

	public static void print(LinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {

		print(MergeSort.mergeSort(input()));

	}
}
