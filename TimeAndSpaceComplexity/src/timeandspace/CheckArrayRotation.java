package timeandspace;
import java.util.*;
/*
Check array rotation

Given an integer array, which is sorted (in increasing order) and has been rotated by some number k in clockwise direction. 
Find and return the k.
Input format :
Line 1 : Integer n (Array Size)
Line 2 : Array elements (separated by space)
Output Format :
Integer k
Constraints :
0 <= n <= 1000
Sample Input 1:
6
5 6 1 2 3 4
Sample Output 1:
2
Sample Input 2:
5
3 6 8 9 10
Sample Output 2:
0
*/
class CheckRotation {	

	public static int arrayRotateCheck(int[] arr){
		/* Your class should be named CheckRotation
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
        int count=0;
        int l=arr.length;
        for(int i=0;i<l;i++){
            if(arr[i]>arr[i+1])
            {
                count++;
                break;
            }
            else
                count++;
        }
        return count;
	}
}
public class CheckArrayRotation {
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
		System.out.print(CheckRotation.arrayRotateCheck(arr));
	}
}
