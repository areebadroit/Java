package test;
import java.util.Scanner;

/*
Delete alternate nodes

Given a linked list, delete all alternate nodes in the list. That means given Linked List is -
10 20 30 40 50 60 
you need to delete nodes - 20, 40 and 60
Note : Head of the list will remain same. Don't need to print or return anything.
Input Constraints:
1 <= Length of Linked List <=10^6.
Input format :
Linked list elements (separated by space and terminated by -1)
Output Format :
Updated linked list elements 
Sample Input :
1 2 3 4 5 -1
Sample Output :
1 3 5
 */

class Del_Alt {
	public static void deleteAlternateNodes(LinkedListNode<Integer> head) {
        if (head == null)  
          return; 
  
       LinkedListNode<Integer> prev = head; 
       LinkedListNode<Integer> now = head.next; 
  
       while (prev != null && now != null)  
       {            
           prev.next = now.next; 
           now = null; 

           prev = prev.next; 
           if (prev != null)  
              now = prev.next; 
       } 
	}
}
public class Delete_Alternate_Nodes_LL {
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		LinkedListNode<Integer> list = input();
		Del_Alt.deleteAlternateNodes(list);
		print(list);
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
