package test;
import java.util.*;

/*
Next Number

Given a large number represented in the form of a linked list. Write code to increment the number by 1 in-place(i.e. without using extra space).
Note: You don't need to print the elements, just update the elements and return the head of updated LL.
Input Constraints:
1 <= Length of Linked List <=10^6.
Input format :
Line 1 : Linked list elements (separated by space and terminated by -1)
Output Format :
Line 1: Updated linked list elements 
Sample Input 1 :
3 9 2 5 -1
Sample Output 1 :
3 9 2 6
Sample Input 2 :
9 9 9 -1
Sample Output 1 :
1 0 0 0 
 */

class NextNum {
	public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
        return addOne(head);
        
	}
   
    static LinkedListNode<Integer> newNode(int data)  
    {  
	    LinkedListNode<Integer> new_node = new LinkedListNode<Integer>(0);  
	    new_node.data = data;  
	    new_node.next = null;  
	    return new_node;  
    }  
  
/* Function to reverse the linked list */
static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head)  
{  
    LinkedListNode<Integer> prev = null;  
    LinkedListNode<Integer> current = head;  
    LinkedListNode<Integer> next = null;  
    while (current != null)  
    {  
        next = current.next;  
        current.next = prev;  
        prev = current;  
        current = next;  
    }  
    return prev;  
}  
  
/* Adds one to a linked lists and return the head  
node of resultant list */
static LinkedListNode<Integer> addOneUtil(LinkedListNode<Integer> head)  
{  
    // res is head node of the resultant list  
    LinkedListNode<Integer> res = head;  
    LinkedListNode<Integer> temp = null, prev = null;  
  
    int carry = 1, sum;  
  
    while (head != null) //while both lists exist  
    {  
        // Calculate value of next digit in resultant list.  
        // The next digit is sum of following things  
        // (i) Carry  
        // (ii) Next digit of head list (if there is a  
        // next digit)  
        sum = carry + head.data;  
  
        // update carry for next calulation  
        carry = (sum >= 10)? 1 : 0;  
  
        // update sum if it is greater than 10  
        sum = sum % 10;  
  
        // Create a new node with sum as data  
        head.data = sum;  
  
        // Move head and second pointers to next nodes  
        temp = head;  
        head = head.next;  
    }  
  
    // if some carry is still there, add a new node to  
    // result list.  
    if (carry > 0)  
        temp.next = newNode(carry);  
  
    // return head of the resultant list  
    return res;  
}  
  
// This function mainly uses addOneUtil().  
static LinkedListNode<Integer> addOne(LinkedListNode<Integer> head)  
{  
    // Reverse linked list  
    head = reverse(head);  
  
    // Add one from left to right of reversed  
    // list  
    head = addOneUtil(head);  
  
    // Reverse the modified list  
    return reverse(head);  
}  
}
public class NextNumber {
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
		
		LinkedListNode<Integer> head = takeInput();
		head = NextNum.nextLargeNumber(head);
		print(head);
		
	}

}
