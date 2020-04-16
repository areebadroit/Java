package timeandspace;
/*
Rotate array

Given a random integer array of size n, write a function that rotates the given array by d elements (towards left)
Change in the input array itself. You don't need to return or print elements.
Input format :
Line 1 : Integer n (Array Size)
Line 2 : Array elements (separated by space)
Line 3 : Integer d
Output Format :
Updated array elements in a single line (separated by space)
Constraints :
0 <= N <= 10^7
0 <= d <= N
Sample Input 1:
7
1 2 3 4 5 6 7
2
Sample Output 1:
3 4 5 6 7 1 2
Sample Input 2:
7
1 2 3 4 5 6 7
0
Sample Output 2:
1 2 3 4 5 6 7
 */
import java.util.*;
class ArrayRotate {	

	public static void rotate(int[] arr, int d) {
		/* Your class should be named ArrayRotate
		 * Don't write main().
	         * Don't read input, it is passed as function argument.
     		 * No need to print or return the output.
      		 * Taking input and printing the output is handled automatically.
     		 */
        if(d>arr.length){
            d=d-arr.length;
        }
        int l=arr.length;
        int[] temp=new int[d];
        for(int i=0;i<d;i++){
            temp[i]=arr[i];
        }
        int n=0;
        for(int i=d;i<l;i++){
            arr[n]=arr[i];
            n++;
        }
        for(int i=0;i<temp.length;i++){
            arr[n]=temp[i];
            n++;
        }
        
	}
}
public class RotateArray {
	static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		int[] arr = takeInput();
		int index = s.nextInt();
		ArrayRotate.rotate(arr, index);
		print(arr);
	}
}
