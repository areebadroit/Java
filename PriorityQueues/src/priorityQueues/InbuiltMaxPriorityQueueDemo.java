package priorityQueues;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Collections;
//import java.util.Comparator;
//class MaxPQComparator implements Comparator<Integer>{
//
//	@Override
//	public int compare(Integer o1, Integer o2) {
//		// TODO Auto-generated method stub
//		if(o1 < o2){
//			return 1;
//		}else if(o1 > o2){
//			return -1;
//		}
//		return 0;
//	}
//
//}
public class InbuiltMaxPriorityQueueDemo {
	public static void main(String[] args) {
//		MaxPQComparator maxPQComparator = new MaxPQComparator();
//		PriorityQueue<Integer> pq = new PriorityQueue<>(maxPQComparator);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		while(choice != -1) {
			switch(choice) {
			case 1 : // insert
				int element = s.nextInt();
				pq.add(element);
				break;
			case 2 : // getMax
				System.out.println(pq.peek());
				break;
			case 3 : // removeMax
				System.out.println(pq.remove());
				break;
			case 4 : // size
				System.out.println(pq.size());
				break;
			case 5 : // isEmpty
				System.out.println(pq.isEmpty());
				break;
			default :
				s.close();
				return;
			}
			choice = s.nextInt();
		}
		s.close();
	}
}
