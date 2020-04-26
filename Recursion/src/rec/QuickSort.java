package rec;
import java.util.Scanner;
/*
Quick Sort Code
Sort an array A using Quick Sort.
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
class QSort {
	public static void quickSort(int[] input) {
		quickSort(input, 0, input.length-1);
	}
    public static void quickSort(int[] input, int si, int ei) {
		if(si >= ei)
            return;
        int pI = partition(input,si,ei);
        quickSort(input, si, pI-1);
        quickSort(input, pI+1, ei);
	}
    public static int partition(int[] input, int si, int ei){
        int pivot = input[ei];  
        int i = (si - 1);

    for (int j = si; j <= ei - 1; j++)
    {
        if (input[j] < pivot)
        {
            i++;    
            int t = input[i];
            input[i] = input[j];
            input[j] = t;
        }
    }
     int t = input[i + 1];
    input[i + 1] = input[ei];
    input[ei] = t;   
    return (i + 1);
    }
}
public class QuickSort {
static Scanner s = new Scanner(System.in);
	
	public static int[] takeInput(){
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++){
			input[i] = s.nextInt();
		}
		return input;
	}
	public static void main(String[] args) {
		int[] input = takeInput();
		QSort.quickSort(input);
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
}
