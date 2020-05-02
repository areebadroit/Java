package priorityQueues;
import java.util.Scanner;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.LinkedList;
/*
Buy the ticket
You want to buy a ticket for a well-known concert which is happening in your city. But the number of tickets available is limited.
Hence the sponsors of the concert decided to sell tickets to customers based on some priority.
A queue is maintained for buying the tickets and every person has attached with a priority (an integer, 1 being the lowest priority).
The tickets are sold in the following manner -
1. The first person (pi) in the queue asked to comes out.
2. If there is another person present in the queue who has higher priority than pi, then ask pi to move at end of the queue without 
giving him the ticket.
3. Otherwise, give him the ticket (and don't make him stand in queue again).
Giving a ticket to a person takes exactly 1 minutes and it takes no time for removing and adding a person to the queue.
And you can assume that no new person joins the queue.
Given a list of priorities of N persons standing in the queue and the index of your priority (indexing starts from 0).
Find and return the time it will take until you get the ticket.
Input Format :
Line 1 : Integer N (Total number of people standing in queue)
Line 2 : Priorities of every person (n space separated integers)
Line 3 : Integer k (index of your priority)
Output Format :
Time required
Sample Input 1 :
3
3 9 4
2
Sample Output 1 :
2
Sample Output 1 Explanation :
Person with priority 3 comes out. But there is a person with higher priority than him. So he goes and then stands in the queue at the end. Queue's status : {9, 4, 3}. Time : 0 secs.
Next, the person with priority 9 comes out. And there is no person with higher priority than him. So he'll get the ticket. Queue's status : {4, 3}. Time : 1 secs.
Next, the person with priority 4 comes out (which is you). And there is no person with higher priority than you. So you'll get the ticket. Time : 2 secs.
Sample Input 2 :
5
2 3 2 2 4
3
Sample Output 2 :
4
 */
class MaxCompr implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1<o2)
			return 1;
		else if(o1>o2)
			return -1;
		return 0;
	}
}
class Solution {
	public static int buyTicket(int input[], int k) {
		Queue<Integer> queue = new LinkedList<>();
		MaxCompr maxComparator = new MaxCompr();
		PriorityQueue<Integer> pq = new PriorityQueue<>(maxComparator);
		int time=0;
		for(int i=0;i<input.length;i++) {
			pq.add(input[i]);
			queue.add(i);
		}
		boolean flag=true;
		while(flag) {
			int pi=queue.remove();
			if(input[pi]==pq.peek()) {
				if(pi==k) {
					pq.remove();
					flag=false;
					time+=1;
				}else {
				pq.remove();
				time+=1;
				}
			}
			queue.add(pi);
		}
		return time;
	}
}
public class Buy_The_Ticket {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		int k = s.nextInt();
		System.out.println(Solution.buyTicket(input, k));
	}
}
