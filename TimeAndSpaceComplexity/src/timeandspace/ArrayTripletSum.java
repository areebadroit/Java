package timeandspace;
/*Given a random integer array and a number x. Find and print the triplets of elements in the array which sum to x.
While printing a triplet, print the smallest element first.
That is, if a valid triplet is (6, 5, 10) print "5 6 10". There is no constraint that out of 5 triplets which have to be printed on 1st line. You can print triplets in any order, just be careful about the order of elements in a triplet.*/
import java.util.*;
class TripletSum {	

	public static void FindTriplet(int[] arr, int x){
		/* Your class should be named TripletSum.
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Print output and don't return it.
		 * Taking input is handled automatically.
		 */
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-2; i++) { 
  
            for (int j = i + 1; j < arr.length - 1; j++) { 
  
                for (int k = j + 1; k < arr.length; k++) { 
                    if (arr[i] + arr[j] + arr[k] == x) { 
                        System.out.println(arr[i]+" "+arr[j]+" "+arr[k]); 
                    } 
                } 
            } 
        } 
	}
}

public class ArrayTripletSum {
	static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = takeInput();
		int num = s.nextInt();
		TripletSum.FindTriplet(arr, num);
	}
}
