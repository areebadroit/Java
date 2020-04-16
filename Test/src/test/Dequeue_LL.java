package test;
import java.util.LinkedList;
import java.util.Scanner;

/*
Dequeue

You need to implement a class for Dequeue i.e. for double ended queue. In this queue, elements can be inserted and deleted from both the ends.
You don't need to double the capacity.
You need to implement the following functions -
1. constructor
You need to create the appropriate constructor. Size for the queue passed is 10.
2. insertFront -
This function takes an element as input and insert the element at the front of queue. Insert the element only if queue is not full. And if queue is full, print -1 and return.
3. insertRear -
This function takes an element as input and insert the element at the end of queue. Insert the element only if queue is not full. And if queue is full, print -1 and return.
4. deleteFront -
This function removes an element from the front of queue. Print -1 if queue is empty.
5. deleteRear -
This function removes an element from the end of queue. Print -1 if queue is empty.
6. getFront -
Returns the element which is at front of the queue. Return -1 if queue is empty.
7. getRear -
Returns the element which is at end of the queue. Return -1 if queue is empty.

 */

class Dequeue {
    // Complete this class
    static int front, rear, capacity; 
    static LinkedList<Integer> list=new LinkedList<>();
    public Dequeue(int n){
        this.capacity=n;
        front = rear = 0;
    }
    static void insertFront(int data) 
    { 
        // check queue is full or not 
       if(list.size()<10){
            list.addFirst(data);
        }
        else{
            System.out.println(-1);
        }
    } 
    static void insertRear(int data) 
    { 
        // check queue is full or not 
        if(list.size()<10){
            list.addLast(data);
        }else{
            System.out.println(-1);
        }
    } 
    static void deleteFront() 
    { 
        // check queue is full or not 
       if(list.size()>0){
            list.pollFirst();
        }else{
            System.out.println(-1);
        }
    } 
    static void deleteRear() 
    { 
        // check queue is full or not 
       if(list.size()>0){
            list.pollLast();
        }else{
            System.out.println(-1);
        }
    } 
    static int getFront() 
    { 
        // check queue is full or not 
       if(list.size()>0){
            return list.getFirst();
        }else{
            return -1;
        }
    } 
     static int getRear() 
    { 
        // check queue is full or not 
       if(list.size()>0){
            return list.getLast();
        }else{
            return -1;
        }
    } 
}
public class Dequeue_LL {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        Dequeue dq = new Dequeue(10);
        
	while(true){
        int choice = s.nextInt(),input;
        switch (choice) {
            case 1:
                input = s.nextInt();
                dq.insertFront(input);
                break;
            case 2:
                input = s.nextInt();
                dq.insertRear(input);
                break;
            case 3:
                dq.deleteFront();
                break;
            case 4:
                dq.deleteRear();
                break;
            case 5:
                System.out.println(dq.getFront());
                break;
            case 6:
                System.out.println(dq.getRear());
                break;
            default:
                return ;
        	}  
		}
	}
}

