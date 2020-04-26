package rec;
import java.util.Scanner;
/*
Merge Sort Code
Sort an array A using Merge Sort.
Change in the input array itself. So no need to return or print anything.
Input format :
Line 1 : Integer n i.e. Array size
Line 2 : Array elements (separated by space)
Output format :
Array elements in increasing order (separated by space)
Constraints :
1 <= n <= 1000
Sample Input:
6 
2 6 8 5 4 3
Sample Output:
2 3 4 5 6 8
 */
class MSort {

	public static void mergeSort(int[] input){
		// Write your code here
		mergeSort(input,0,input.length-1);
	}
    public static void mergeSort(int[] input,int si, int ei){
		// Write your code here
		if(si<ei)
        {
        int mid = (si + ei)/2;
        mergeSort(input,si,mid);
        mergeSort(input,mid+1,ei);
        merge(input,si,mid,ei); 
        }
	}
    public static void merge(int[] input, int si, int mid, int ei) 
    { 
        int n1 = mid - si + 1; 
        int n2 = ei - mid; 
        int Left[] = new int [n1]; 
        int Right[] = new int [n2]; 
        for (int i=0; i<n1; ++i) 
            Left[i] = input[si + i]; 
        for (int j=0; j<n2; ++j) 
            Right[j] = input[mid + 1+ j]; 
        int i = 0, j = 0; 
        int k = si; 
        while (i < n1 && j < n2) 
        { 
            if (Left[i] <= Right[j]) 
            { 
                input[k] = Left[i]; 
                i++; 
            } 
            else
            { 
                input[k] = Right[j]; 
                j++; 
            } 
            k++; 
        } 
        while (i < n1) 
        { 
            input[k] = Left[i]; 
            i++; 
            k++; 
        } 
        while (j < n2) 
        { 
            input[k] = Right[j]; 
            j++; 
            k++; 
        } 
    } 
}
public class MergeSort {
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void printArray(int input[]) {
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		MSort.mergeSort(input);
		printArray(input);
	}
}
