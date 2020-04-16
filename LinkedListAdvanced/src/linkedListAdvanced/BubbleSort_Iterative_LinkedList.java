package linkedListAdvanced;
import java.util.Scanner;

/*
Bubble Sort (Iterative) LinkedList

Sort a given linked list using Bubble Sort (iteratively). While sorting, you need to swap the entire nodes, not just the data.
You don't need to print the elements, just sort the elements and return the head of updated LL.
Input format : Linked list elements (separated by space and terminated by -1)`

Sample Input 1 :
1 4 5 2 -1
Sample Output 1 :
1 2 4 5
 */

class BubbleSort {
    private static int length(LinkedListNode<Integer> head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
    public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
        int n = length(head);
        for (int i = 0; i < n - 1; i++) {
            LinkedListNode<Integer> prev = null;
            LinkedListNode<Integer> curr = head;
            for (int j = 0; j < n - i - 1; j++) {
                if (curr.data <= curr.next.data) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    if (prev == null) {
                        LinkedListNode<Integer> fwd = curr.next;
                        head = head.next;
                        curr.next = fwd.next;
                        fwd.next = curr;
                        prev = fwd;
                    } else {
                        LinkedListNode<Integer> fwd = curr.next;
                        prev.next = fwd;
                        curr.next = fwd.next;
                        fwd.next = curr;
                        prev = fwd;
                    }
                }
            }
        }
        return head;
    }
}

public class BubbleSort_Iterative_LinkedList {
	private static Scanner s= new Scanner(System.in);
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
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		print(BubbleSort.bubbleSort(input()));
	}
}
