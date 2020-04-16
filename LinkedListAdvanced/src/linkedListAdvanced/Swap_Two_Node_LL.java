package linkedListAdvanced;
import java.util.Scanner;

/*
Swap two Node of LL

Given a linked list, i & j, swap the nodes that are present at i & j position in the LL. You need to swap the entire nodes, not just the data.
Indexing starts from 0. You don't need to print the elements, just swap and return the head of updated LL.
Assume i & j given will be within limits. And i can be greater than j also.
Input format :

Line 1 : Linked list elements (separated by space and terminated by -1)

Line 2 : i and j (separated by space)

Sample Input 1 :
3 4 5 2 6 1 9 -1
3 4
Sample Output 1 :
3 4 5 6 2 1 9
Sample Input 2 :
3 4 5 2 6 1 9 -1
2 4
Sample Output 2 :
3 4 6 2 5 1 9
 */

class Swap {
	public static  LinkedListNode<Integer> swap_nodes(LinkedListNode<Integer> head,int i,int j){
		int count1=0;
        int count2=0;
        LinkedListNode<Integer> p1=null;
        LinkedListNode<Integer> c1=head;
        if(i==j){
            return head;
        }
        if(head==null||head.next==null){
            return head;
        }
        if(i>j){
            int a=i;
            i=j;
            j=a;
        }
        while(c1!=null&&count1!=i){
            count1+=1;
            p1=c1;
            c1=c1.next;
        }
        LinkedListNode<Integer> p2=null;
        LinkedListNode<Integer> c2=head;
        while(c2!=null&&count2!=j){
            count2+=1;
            p2=c2;
            c2=c2.next;
        }
        if(c1==null||c2==null){
            return head;
        }
        if (p1 != null) 
            p1.next = c2; 
        else //make y the new head 
            head = c2; 
  
        // If y is not head of linked list 
        if (p2 != null) 
            p2.next = c1; 
        else // make x the new head 
            head = c1; 
  
        // Swap next pointers 
        LinkedListNode<Integer> temp = c1.next; 
        c1.next = c2.next; 
        c2.next = temp; 
        return head;
	}
}
public class Swap_Two_Node_LL {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(Swap.swap_nodes(input(), s.nextInt(), s.nextInt()));
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
