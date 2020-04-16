package timeandspace;
import java.util.*;

/*
Duplicate in array

Given an array of integers of size n which contains numbers from 0 to n - 2. Each number is present at least once. That is, if n = 5, numbers from 0 to 3 is present in the given array at least once and one number is present twice. You need to find and return that duplicate number present in the array.
Assume, duplicate number is always present in the array.
Input format :
Line 1 : Size of input array
Line 2 : Array elements (separated by space)
Output Format :
Duplicate element
Constraints :
1 <= n <= 10^6
Sample Input:
9
0 7 2 5 4 7 1 3 6
Sample Output:
7
 */

class DuplicateInArraySoln{	

	public static int duplicate(int[] arr){  
        Arrays.sort(arr);
        int count=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                count=arr[i];
            }
        }
        return count;
	}
}
public class DuplicateInArray {
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		s.close();
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = takeInput();
		System.out.print(DuplicateInArraySoln.duplicate(arr));
	}
}
