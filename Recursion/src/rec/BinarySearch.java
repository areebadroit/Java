package rec;
import java.util.Scanner;
/*
Binary Search (Recursive)
Given an integer sorted array (sorted in increasing order) and an element x, 
find the x in given array using binary search. Return the index of x.
Return -1 if x is not present in the given array.
Note : If given array size is even, take first mid.
Input format :

Line 1 : Array size

Line 2 : Array elements (separated by space)

Line 3 : x (element to be searched)

Sample Input :
6
2 3 4 5 6 8 
5 
Sample Output:
3 
 */
class Search {
	// element - number to be searched
	public static int binarySearch(int input[], int element) {
		return binarySearch(input, 0, input.length-1, element);
	}
	public static int binarySearch(int input[], int l, int u, int element) {
		if (u >= l) { 
			int mid = l + (u - l) / 2; 
			if (input[mid] == element) 
				return mid; 
			if (input[mid] > element) 
				return binarySearch(input, l, mid - 1, element); 
			return binarySearch(input, mid + 1, u, element); 
		}
		return -1;
	}
}
public class BinarySearch {
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
		int[] input = takeInput();
		int element = s.nextInt();
		System.out.println(Search.binarySearch(input, element));
	}
}
