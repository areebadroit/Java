package priorityQueues;
import java.util.PriorityQueue;
import java.util.Scanner;
//import java.util.Comparator;
//class MinPQComparator implements Comparator<Integer>{
//	@Override
//	public int compare(Integer o1, Integer o2) {
//		// TODO Auto-generated method stub
//		if(o1 < o2){
//			return -1;
//		}else if(o1 > o2){
//			return 1;
//		}
//		return 0;
//	}
//}
public class InbuiltPriorityQueueDemo {
	public static void main(String[] args) {
//		MinPQComparator minComparator = new MinPQComparator();
//		PriorityQueue<Integer> pq = new PriorityQueue<>(minComparator);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		while(choice != -1) {
			switch(choice) {
			case 1 : // insert
				int element = s.nextInt();
				pq.add(element);
				break;
			case 2 : // getMin
				System.out.println(pq.peek());
				break;
			case 3 : // removeMin
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
