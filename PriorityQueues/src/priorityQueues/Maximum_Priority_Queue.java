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
4. getMax -
Return the maximum element present in the priority queue without deleting. Return -Infinity if priority queue is empty.
5. removeMax -
Delete and return the maximum element present in the priority queue. Return -Infinity if priority queue is empty.
Note : main function is given for your reference which we are using internally to test the class.

 */
class MaxPQ {
   private static ArrayList<Integer> heap = new ArrayList<>();
   public static int getSize(){
       return heap.size();
   }
	public static boolean isEmpty(){
       return heap.size()==0;
   }
   public static void insert(int value){
       heap.add(value);
       int childIndex=heap.size()-1;
       int parentIndex=(childIndex-1)/2;
       while(childIndex>0){
           if(heap.get(childIndex)>heap.get(parentIndex)){
               int temp=heap.get(childIndex);
               heap.set(childIndex,heap.get(parentIndex));
               heap.set(parentIndex, temp);
               childIndex=parentIndex;
               parentIndex=(childIndex-1)/2;
           }else{
               return;
           }
       }
   }
   public static int getMax(){
       if(isEmpty()){
           return Integer.MIN_VALUE;
       }
       return heap.get(0);
   }
   public static int removeMax(){
        if(isEmpty()){
           return Integer.MIN_VALUE;
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
			if(heap.get(leftIndex) > heap.get(parentIndex) && heap.get(leftIndex) > heap.get(rightIndex)){
				int temp = heap.get(leftIndex);
				heap.set(leftIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				parentIndex = leftIndex;
				leftIndex = 2*parentIndex+1;
				rightIndex = 2*parentIndex+2;
			}else if(heap.get(rightIndex) > heap.get(parentIndex) && heap.get(rightIndex) > heap.get(leftIndex)){
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
public class Maximum_Priority_Queue {
static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		//MaxPQ pq = new MaxPQ();
		int choice = s.nextInt();
		while(choice != -1) {
			switch(choice) {
				case 1 : // insert
					int element = s.nextInt();
					MaxPQ.insert(element);
					break;
				case 2 : // getMax
					System.out.println(MaxPQ.getMax());
					break;
				case 3 : // removeMax
					System.out.println(MaxPQ.removeMax());
					break;
				case 4 : // size
					System.out.println(MaxPQ.getSize());
					break;
				case 5 : // isEmpty
					System.out.println(MaxPQ.isEmpty());
					break;
				default :
						return;
			}
			choice = s.nextInt();
		}
	}

}
