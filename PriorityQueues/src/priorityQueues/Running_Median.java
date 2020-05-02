package priorityQueues;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
Running median
You are given a stream of n integers. For every ith integer, add it to the running list of integers and print the 
resulting median (of the list till now).
Print the only integer part of median.
Input Format :
Line 1 : An integer N denoting the number of integers in the stream
Line 2 : N integers which are separated by spaces
Output Format :
After each new integer is added to the list print the updated median on a new line
Input Constraints
1 <= n <= 10^5
1 <= Ai <= 10^5
Sample Input 1 :
6
6 2 1 3 7 5
Sample Output 1 :
6
4
2
2
3
4
Sample Output explanation :
S = {6}, median = 6
S = {6, 2} -> {2, 6}, median = 4
S = {6, 2, 1} -> {1, 2, 6}, median = 2
S = {6, 2, 1, 3} -> {1, 2, 3, 6}, median = 2
S = {6, 2, 1, 3, 7} -> {1, 2, 3, 6, 7}, median = 3
S = {6, 2, 1, 3, 7, 5} -> {1, 2, 3, 5, 6, 7}, median = 4
 */
class MaxComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1<o2)
			return 1;
		else if(o1>o2)
			return -1;
		return 0;
	}

}
class Median {
	public static void runningMedian(int arr[]) {
		MaxComparator maxComparator = new MaxComparator();
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(maxComparator);
		//int pqSize=(arr.length/2)+1;
		maxPQ.add(arr[0]);
		System.out.println(maxPQ.peek());
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<maxPQ.peek())
				maxPQ.add(arr[i]);	
			else
				minPQ.add(arr[i]);
			if(maxPQ.size()-minPQ.size()>1) {
				minPQ.add(maxPQ.remove());
				//System.out.println("Here");
				}
			else if(minPQ.size()-maxPQ.size()>1) {
				maxPQ.add(minPQ.remove());
				//System.out.println("There");
			}
			if(maxPQ.size()>minPQ.size())
				System.out.println(maxPQ.peek());
			else if(minPQ.size()>maxPQ.size())
				System.out.println(minPQ.peek());
			else
				System.out.println((minPQ.peek()+maxPQ.peek())/2);
		}

	}
}

public class Running_Median {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = s.nextInt();
		}

		Median.runningMedian(arr);
		s.close();
	}
}
