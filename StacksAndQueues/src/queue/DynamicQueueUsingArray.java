package queue;
//import java.util.*;
class DynamicQueue {
	private int data[];
	private int front; // index at which front element is stored
	private int rear; // index at which rear element is stored
	private int size;
	
	public DynamicQueue() {
		data = new int[10];
		front = -1;
		rear = -1;
		size = 0;
	}
	public DynamicQueue( int capacity) {
		data = new int[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}

	int size(){
		return size;
	}
	
	boolean isEmpty(){
		return size == 0;
	}

	int front() throws QueueEmptyException{
		if(size == 0){
			throw new QueueEmptyException();
		}
		return data[front];
	}
	
	void enqueue(int element) throws QueueFullException{
		
		if(size == data.length){
//			throw new QueueFullException();
			doubleCapacity();
		}
		
		if(size == 0){
			front = 0;
		}
		size++;
		rear = (rear + 1) % data.length;
//		rear++;
//		if(rear == data.length){
//			rear = 0;
//		}
		data[rear] = element; 
	}
	
	private void doubleCapacity() {
		int temp[] = data;
		data = new int[ 2* temp.length];
		int index = 0;
		for(int i = front ; i < temp.length; i++){
			data[index] = temp[i];
			index++;
		}
		for(int i = 0; i <= front - 1;i++){
			data[index] = temp[i];
			index++;
		}
		front = 0;
		rear = temp.length - 1;
	}
	
	
	int dequeue() throws QueueEmptyException{
		if(size == 0){
			throw new QueueEmptyException();
		}
		int temp = data[front];
		front = (front + 1) % data.length;
//		front++;
//		if(front == data.length){
//			front = 0;
//		}
		size--;
		if(size == 0){
			front = -1;
			rear = -1;
		}
		return temp;
	}	
}
public class DynamicQueueUsingArray {
	//This is a queue of dynamic capacity
			/*Initially a queue is created using an array of 3, but as soon as the stack becomes full a new queue using array 
			of double size is automatically created, hence this will never throw queueFullException*/
	public static void main(String[] args) {
		DynamicQueue queue = new DynamicQueue(3);
		for(int i = 1; i <= 5; i++){
			//queue.enqueue(i);
			try {
				queue.enqueue(i);
			} catch (QueueFullException e) {
				
			}
		}
		
		
		while(! queue.isEmpty()){
			try {
				System.out.println(queue.dequeue());
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
