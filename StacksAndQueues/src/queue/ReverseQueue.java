package queue;
import java.util.*;

/*
Reverse Queue

Given a queue of integers, reverse it without help of any explicit stack or queue. You need to change in the given queue itself.
Note : No need to return or print the queue.
Input format :
Line 1 : First Element - Size of Queue, Rest Elements - Elements Of Queue
Output format :
Queue elements
Sample Input :
4 1 2 3 4     (1 is at front)
Sample Output :
4 3 2 1    (4 is at front)
 */

class RevQueue {

	public static void reverseQueue(Queue1<Integer> q) {
		// Write your code here
		if(q.size()<1)
            return;
        int front=q.dequeue();
        reverseQueue(q);
        q.enqueue(front);
	}
}
class Queue1<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public T front() {
		if(size == 0){
			return null;
		}
		return head.data;
	}


	public void enqueue(T element){
		Node<T> newNode = new Node<T>(element);

		if(head == null){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = newNode;
			tail = newNode;
		}

		size++;
	}

	public T dequeue(){
		if(head == null){
			return null;
		}
		if(head == tail){
			tail = null;
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
}
public class ReverseQueue {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int size = s.nextInt();
		Queue1<Integer> input = new Queue1<Integer>();
		for(int i = 0; i < size; i++) {
			input.enqueue(s.nextInt());
		}
		RevQueue.reverseQueue(input);
		while(!input.isEmpty()) {
			System.out.print(input.dequeue() + " ");
		}
	}
}
