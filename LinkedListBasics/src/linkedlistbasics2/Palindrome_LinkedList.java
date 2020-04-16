package linkedlistbasics2;
import java.util.Scanner;

/*
Palindrome LinkedList

Check if a given linked list is palindrome or not. Return true or false.
Indexing starts from 0.
Input format : Linked list elements (separated by space and terminated by -1)

Sample Input 1 :
9 2 3 3 2 9 -1
Sample Output 1 :
true
Sample Input 2 :
0 2 3 2 5 -1
Sample Output 2 :
false
 */

class Palindrome_LL {
	public static boolean isPalindrome_2(LinkedListNode<Integer> head) {
        int count=1;
        LinkedListNode<Integer> temp = head;
        if(temp==null)
            return false;
        else{
            while(temp.next!=null){
                count=count+1;
                temp=temp.next;
            }
        }
        temp=head;
        LinkedListNode<Integer> temp2;
        for(int i=0;i<(count/2)-1;i++){
            //System.out.println(temp.data);
            temp=temp.next;
            //System.out.println(temp.data);
        }
        temp2=temp.next;
        temp.next=null;
        LinkedListNode<Integer>temp3=head;
        temp2=reverse(temp2);
        while(temp3!=null){
            //System.out.println(temp2.data);
            if(!temp3.data.equals(temp2.data)){
                // System.out.println(temp3.data);
                // System.out.println(temp2.data);
                return false;
            }
            temp3=temp3.next;
            temp2=temp2.next;
        }
        return true;
    }
    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> node) 
    { 
        LinkedListNode<Integer> prev = null; 
        LinkedListNode<Integer> current = node; 
        LinkedListNode<Integer> next = null; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        node = prev; 
        return node; 
    } 
}
public class Palindrome_LinkedList {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print(Palindrome_LL.isPalindrome_2(input()));
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
