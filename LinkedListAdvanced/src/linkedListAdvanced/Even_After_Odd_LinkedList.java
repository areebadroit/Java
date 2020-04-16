package linkedListAdvanced;
import java.util.Scanner;

/*
Even after Odd LinkedList

Arrange elements in a given Linked List such that, all even numbers are placed after odd numbers. Respective order of elements should remain same.
Note: Input and Output has already managed for you. You don't need to print the elements, instead return the head of updated LL.
Input format:
Linked list elements (separated by space and terminated by -1)
Output format:
Print the elements of updated Linked list. 
Sample Input 1 :
1 4 5 2 -1
Sample Output 1 :
1 5 4 2 
Sample Input 2 :
1 11 3 6 8 0 9 -1
Sample Output 2 :
1 11 3 9 6 8 0
 */

class EvenAfterOdd {
	public static LinkedListNode<Integer> sortEvenOdd(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp=head;
        LinkedListNode<Integer> oddh=null;
        LinkedListNode<Integer> evenh=null;
        LinkedListNode<Integer> oddt=null;
        LinkedListNode<Integer> event=null;
        if(head==null||head.next==null){
            return head;
        }
        while(temp!=null){
            if(temp.data.intValue()%2==0){
                if(evenh==null){
                    evenh=temp;
                    event=temp;
                }else{
                    event.next=temp;
                    event=event.next;
                }
            }
            else{
                 if(oddh==null){
                    oddh=temp;
                    oddt=temp;
                }else{
                    oddt.next=temp;
                    oddt=oddt.next;
                }
            }
            temp=temp.next;
        }
        if(event!=null)
            event.next=null;
        if(oddt!=null){
            oddt.next=null;
        }
        
        if(oddh==null)
            oddh=evenh;
        else{
            oddt.next=evenh;
        }
        return oddh;
	}
}
public class Even_After_Odd_LinkedList {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(EvenAfterOdd.sortEvenOdd(input()));
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
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
