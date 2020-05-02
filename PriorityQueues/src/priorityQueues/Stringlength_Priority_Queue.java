package priorityQueues;
import java.util.Comparator;
import java.util.PriorityQueue;

class StringLengthComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if(o1.length() < o2.length()){
			return -1;//change this to 1 and it becomes a max priority queue
		}else if(o1.length() > o2.length()){
			return 1;//change this to -1 and it becomes a max priority queue
		}else{
			return 0;
		}
	}
}
public class Stringlength_Priority_Queue {
	public static void main(String[] args) {

		String arr[] = {"this", "at", "a", "their", "queues"};
		StringLengthComparator stringComparator = new StringLengthComparator();
		PriorityQueue<String> pq = new PriorityQueue<>(stringComparator);
		for(int i = 0; i < arr.length; i++){
			pq.add(arr[i]);
		}

		//	System.out.println(pq.element());
		while(! pq.isEmpty()){
			System.out.print(pq.remove() + " ");
		}
	}
}
