package stacks;
import java.util.*;
/*
Stack Using LL

You need to implement a Stack class using linked list.
The data members should be private.
Implement the following public functions :
1. Constructor -
Initializes the data member (i.e. head to null).
2. push :
This function should take one argument of type T and has return type void. This function should insert an element in the stack. Time complexity should be O(1).
3. pop :
This function takes no input arguments and has return type T. This should removes the last element which is entered and return that element as an answer. Time complexity should be O(1).
4. top :
This function takes no input arguments and has return type T. This should return the last element which is entered and return that element as an answer. Time complexity should be O(1).
5. size :
Return the size of stack i.e. count of elements which are present ins stack right now. Time complexity should be O(1).
6. isEmpty :
Checks if the stack is empty or not. Return true or false.
 */

class Stack<T> {
    Node<T> head;
    int size;
	
	public Stack() {
        head=null;
        size=0;
	}
	
	public int size() {
        return this.size;
	}
	
	public void push(T data) {
//        T value=data;
        Node<T> temp = new Node<>(data);
        
		if(head!=null){
            temp.next=head;
            head=temp;
            size+=1;
        }else{
            head=temp;
            temp.next=null;
            size+=1;
        }
	}
	
	public boolean isEmpty() {
		if(head==null){
            return true;
        }
        return false;
	}
	
	public T pop() throws StackEmptyException {
		if(head==null){
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        size-=1;
        T value=(T)head.data;
        head=head.next;
        return value;
	}
	
	public T top() throws StackEmptyException {
		if(head==null){
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        return (T)head.data;
	}
}
//Runner Class
public class StackUsingLinkedList {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		Stack<Integer> st = new Stack<Integer>();

		int choice = s.nextInt();
		int input;

		while (choice !=-1) {
			if(choice == 1) {
				input = s.nextInt();
				st.push(input);
			}
			else if(choice == 2) {
				try {
					System.out.println(st.pop());
				} catch (StackEmptyException e) {
					System.out.println(-1);
				}
			}
			else if(choice == 3) {
				try {
					System.out.println(st.top());
				} catch (StackEmptyException e) {
					System.out.println(-1);
				}
			}
			else if(choice == 4) {
				System.out.println(st.size());
			}
			else if(choice == 5) {
				System.out.println(st.isEmpty());
			}
			choice = s.nextInt();
		}
		s.close();
	}
}
