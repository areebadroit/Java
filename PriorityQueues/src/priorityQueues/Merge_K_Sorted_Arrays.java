package priorityQueues;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
/*
Merge K sorted arrays
Given k different arrays, which are sorted individually (in ascending order).
You need to merge all the given arrays such that output array should be sorted (in ascending order).
Hint : Use Heaps.
Input Format :
Line 1 : Integer K
Line 2 : Arrays 1 size (n1)
Line 3 : Array 1 elements (separated by space)
Line 4 : Array 2 size (n2)
and so on for next arrays
Sample Input 1 :
4
3
1 5 9
2
45 90
5
2 6 78 100 234
1
0
Sample Output 1 :
0 1 2 5 6 9 45 78 90 100 234
 */
class Triplet{
	int element;
	int elementIndex;
	int arrayIndex;

}
class TripletComparator implements Comparator<Triplet>{

	@Override
	public int compare(Triplet o1, Triplet o2) {
		if(o1.element<o2.element)
			return -1;
		else if(o1.element>o2.element)
			return 1;
		return 0;
	}
	
}
class Sorted {
	
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
		int k=input.size();
		TripletComparator tripletComp = new TripletComparator();
		PriorityQueue<Triplet> pq = new PriorityQueue<>(tripletComp);
		ArrayList<Integer> result = new ArrayList<>();
		int i=0;
		for(;i<k;i++) {
			if(input.get(i).size()!=0) {
				Triplet ob=new Triplet();
				ob.element=input.get(i).get(0);
				ob.elementIndex=0;
				ob.arrayIndex=i;
				pq.add(ob);
			}
		}
		int maxsize=0;
		for(int j=0;j<k;j++){
//			if(input.get(j).size()>maxsize)
				maxsize+=input.get(j).size();
		}
		//System.out.println(maxsize);
		for(int p=0;p<maxsize;p++) {
			Triplet del=pq.remove();
			result.add(del.element);
			if(del.elementIndex+1<input.get(del.arrayIndex).size()) {
				Triplet ob=new Triplet();
				ob.element=input.get(del.arrayIndex).get(del.elementIndex+1);
				ob.elementIndex=del.elementIndex+1;
				ob.arrayIndex=del.arrayIndex;
				pq.add(ob);
			}
		}
		return result;
	}
}
public class Merge_K_Sorted_Arrays {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		while(k > 0) {
			int n = s.nextInt();
			ArrayList<Integer> current = new ArrayList<Integer>();
			for(int i = 0; i < n; i++) {
				current.add(s.nextInt());
			}
			input.add(current);
			k--;
		}
		ArrayList<Integer> output = Sorted.mergeKSortedArrays(input);
		for(int i : output) {
			System.out.print(i + " ");
		}
		s.close();
	}
}
