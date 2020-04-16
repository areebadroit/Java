package queue;

class  Queue_Arr{
	
	private int data[];
	private int front; // index at which front element is stored
	private int rear; // index at which rear element is stored
	private int size;
	
	public Queue_Arr() {
		data = new int[10];
		front = -1;
		rear = -1;
		size = 0;
	}
	public Queue_Arr( int capacity) {
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
			throw new QueueFullException();
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
public class QueueUsingArray {

	public static void main(String[] args) throws QueueFullException {
		Queue_Arr queue = new Queue_Arr(3);
		for(int i = 1; i <= 5; i++){
//			queue.enqueue(i);
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

