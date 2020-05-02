package priorityQueues;
import java.util.ArrayList;
import java.util.Scanner;
/*
Max Priority Queue
Implement the class for Max Priority Queue which includes following functions -
1. getSize -
Return the size of priority queue i.e. number of elements present in the priority queue.
2. isEmpty -
Check if priority queue is empty or not. Return true or false accordingly.
3. insert -
Given an element, insert that element in the priority queue at the correct position.
4. getMin -
Return the minimum element present in the priority queue without deleting. Return PriorityQueueException if priority queue is empty.
5. removeMax -
Delete and return the maximum element present in the priority queue. Return PriorityQueueException if priority queue is empty.
Note : main function is given for your reference which we are using internally to test the class.

 */
class PQ {

	private ArrayList<Integer> heap;

	public PQ() {
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
		//Upward Heapify
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
		//Downward Heapify
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


public class Minimum_Priority_Queue {
	static Scanner s = new Scanner(System.in);

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
					System.out.println(Integer.MIN_VALUE);
					return;
				}
				break;
			case 3 : // removeMin
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
				break;
			default :
				return;
			}
			choice = s.nextInt();
		}
	}
}








