package linkedListAdvanced;
import java.util.Scanner;

/*
Delete every N nodes

Given a linked list and two integers M and N. Traverse the linked list such that you retain M nodes then delete next N nodes, continue the same until end of the linked list. That is, in the given linked list you need to delete N nodes after every M nodes.
Input format :

Line 1 : Linked list elements (separated by space and terminated by -1)

Line 2 : M

Line 3 : N

Sample Input 1 :
1 2 3 4 5 6 7 8 -1
2
2
Sample Output 1 :
1 2 5 6
Sample Input 2 :
1 2 3 4 5 6 7 8 -1
2
3
Sample Output 2 :
1 2 6 7
 */

class Delete_N_Nodes {
	public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
        LinkedListNode<Integer> temp=head;
        LinkedListNode<Integer> tempM=head;
        LinkedListNode<Integer> tempN=null;
        int c1=1,c2=1;
        if(head==null){
            return head;
        }
        if(M==0){
            return null;
        }
        while(temp!=null){
        while(c1!=M&&tempM!=null){
            c1+=1;
            tempM=tempM.next;
                //temp=temp.next;
        }
        if(tempM==null){
            break;
        }
        if(tempM.next!=null){
            tempN=tempM.next;
        }
        while(c2!=N&&tempN!=null){
            c2+=1;
            tempN=tempN.next;
                //temp=temp.next;
        }
            if(tempN==null||tempN.next==null)
                tempM.next=null;
            else{
                tempM.next=tempN.next;
                tempM=tempN.next;
                c1=1;
                c2=1;
            }
            if(tempM.next!=null)
                temp=tempM;
            else
                break;
        }
        return head;
	}
}

public class Delete_Every_N_Nodes {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(Delete_N_Nodes.skipMdeleteN(input(), s.nextInt(), s.nextInt()));
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
