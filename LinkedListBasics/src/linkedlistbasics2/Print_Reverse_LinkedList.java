package linkedlistbasics2;
import java.util.Scanner;

/*Print reverse LinkedList

Print a given linked list in reverse order. You need to print the tail first and head last. You can’t change any pointer in the linked list, just print it in reverse order.
Input format : Linked List elements (separated by space and terminated by -1)

Output format : Linked List elements in reverse order (separated by space)

Sample Input 1 :
1 2 3 4 5 -1
Sample Output 1 :
5 4 3 2 1
Sample Input 2 :
1 2 3 -1
Sample Output 2 :
3 2 1
*/

class Reverse {
	public static void printReverseRecursive(LinkedListNode<Integer> root) {
        if(root.next==null){
            System.out.print(root.data+" ");
            return;
        }
            
        printReverseRecursive(root.next);
        System.out.print(root.data+" ");
        return;
    }
}
public class Print_Reverse_LinkedList {
	private static Scanner s= new Scanner(System.in);
	public static void main(String[] args) {
		Reverse.printReverseRecursive(input());
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
