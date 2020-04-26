package rec;
import java.util.Scanner;
/*
All Indices of Number
Given an array of length N and an integer x, you need to find all the indexes where x is present in the input array. Save all the indexes in an array (in increasing order).
Do this recursively. Indexing in the array starts from 0.
Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Line 3 : Integer x
Output Format :
indexes where x is present in the array (separated by space)
Constraints :
1 <= N <= 10^3
Sample Input :
5
9 8 10 8 8
8
Sample Output :
1 3 4
 */
class All_Index {
    static int i=1;
    static int smallArray[]=new int[0];
	public static int[] allIndexes(int input[],int startIndex,   int x) {
        
		if(startIndex > input.length-1){
            
            return new int[0];
        }
        if(startIndex<input.length){
        smallArray = allIndexes(input,startIndex+1,x);
        if(input[startIndex]==x){
            int temp[]=new int[smallArray.length];
                for(int j=0;j<smallArray.length;j++){
                    temp[j]=smallArray[j];
                }
            smallArray=new int[temp.length+1];
             for(int j=1;j<smallArray.length;j++){
                    smallArray[j]=temp[j-1];
                }
            smallArray[0]=startIndex;
        }
        }
       return smallArray;
	}
    public static int[] allIndexes(int input[], int x) {
		
		return allIndexes(input, 0, x);
		
	}
	
}
public class All_IndicesOfNumber {
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
		int x = s.nextInt();
		int output[] = All_Index.allIndexes(input, x);
		for(int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
	}
}
