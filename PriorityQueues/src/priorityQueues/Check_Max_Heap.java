package priorityQueues;
import java.util.Scanner;
/*
Check Max-Heap
Given an array of integers, check whether it represents max-heap or not.
Return true or false.
Input Format :
Line 1 : An integer N i.e. size of the array
Line 2 : N integers which are elements of the array, separated by spaces
Output Format :
true if it represents max-heap and false if it is not a max-heap
Constraints :
1 <= N <= 10^5
1 <= Ai <= 10^5
 */
class Max_Heap {
	public static boolean checkMaxHeap(int arr[]) {
        int parentIndex = 0;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        while(leftChildIndex < arr.length){
            if(arr[leftChildIndex] > arr[parentIndex]){
				return false;
			}
            if(rightChildIndex < arr.length-1&&arr[rightChildIndex] > arr[parentIndex]){
				return false;
			}
            parentIndex++;
            leftChildIndex = 2 * parentIndex + 1;
        	rightChildIndex = 2 * parentIndex + 2;
        }
        return true;
	}
}

public class Check_Max_Heap {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = s.nextInt();
		}
		System.out.println(Max_Heap.checkMaxHeap(arr));
		s.close();
	}
}
