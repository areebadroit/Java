package priorityQueues;
import java.util.ArrayList;
import java.util.Scanner;
/*
Remove Min

Implement the function RemoveMin for the min priority queue class.
For a minimum priority queue, write the function for removing the minimum element present.
Remove and return the minimum element.
Note : main function is given for your reference which we are using internally to test the code.

 */
/*****************
 * Main function - 
 *
	public static void main(String[] args) {
		PQ pq = new PQ();
		int choice = s.nextInt();
		while(choice != -1) {
			switch(choice) {
				case 1 : // insert
					int element = s.nextInt();
					pq.insert(element);
					break;
				case 2 : // getMin
				try {
					System.out.println(pq.getMin());
				} catch (PriorityQueueException e) {
					return;
				}
					break;
				case 3 : // removeMin
				try {
					System.out.println(pq.removeMin());
				} catch (PriorityQueueException e) {
					return;
				}
					break;
				case 4 : // size
					System.out.println(pq.size());
					break;
				case 5 : // isEmpty
					System.out.println(pq.isEmpty());
				default :
						return;
			}
			choice = s.nextInt();
		}
	}
 *******************/


class PQueue {

	private ArrayList<Integer> heap;

	public PQueue() {
		heap = new ArrayList<Integer>();
	}

	boolean isEmpty(){
		return heap.size() == 0;
	}

	int size(){
		return heap.size();
	}

	int getMin() throws PriorityQueueException{
		if(isEmpty()){
			// Throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}

	void insert(int element){
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while(childIndex > 0){
			if(heap.get(childIndex) < heap.get(parentIndex)){
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			}else{
				return;
			}
		}
	}

	int removeMin() throws PriorityQueueException {
		if(isEmpty()){
			throw new PriorityQueueException();
		}
		int data=heap.get(0);
		int removeIndex = heap.size() - 1;
		heap.set(0, heap.get(removeIndex));
		heap.remove(removeIndex);
		int parentIndex=0;
		int leftIndex=parentIndex+1;
		int rightIndex=parentIndex+2;
		while(leftIndex < heap.size() && rightIndex < heap.size()){
			if(heap.get(leftIndex) < heap.get(parentIndex) && heap.get(leftIndex) < heap.get(rightIndex)){
				int temp = heap.get(leftIndex);
				heap.set(leftIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				parentIndex = leftIndex;
				leftIndex = 2*parentIndex+1;
				rightIndex = 2*parentIndex+2;
			}else if(heap.get(rightIndex) < heap.get(parentIndex) && heap.get(rightIndex) < heap.get(leftIndex)){
				int temp = heap.get(rightIndex);
				heap.set(rightIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				parentIndex = rightIndex;
				leftIndex = 2*parentIndex+1;
				rightIndex = 2*parentIndex+2;
			}
		}
		return data;
	}
}
public class Remove_Min {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		PQueue pq = new PQueue();
		int choice = s.nextInt();
		while(choice != -1) {
			switch(choice) {
			case 1 : // insert
				int element = s.nextInt();
				pq.insert(element);
				break;
			case 2 : // getMax
				try {
					System.out.println(pq.getMin());
				} catch (PriorityQueueException e) {
					System.out.println(Integer.MIN_VALUE);
					return;
				}
				break;
			case 3 : // removeMax
				try {
					System.out.println(pq.removeMin());
				} catch (PriorityQueueException e) {
					System.out.println(Integer.MIN_VALUE);
					return;
				}
				break;
			case 4 : // size
				System.out.println(pq.size());
				break;
			case 5 : // isEmpty
				System.out.println(pq.isEmpty());
			default :
				return;
			}
			choice = s.nextInt();
		}
	}
}
