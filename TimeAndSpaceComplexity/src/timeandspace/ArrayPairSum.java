package timeandspace;

import java.util.Scanner;

/*
Pair sum in array

Given a random integer array A and a number x. Find and print the pair of elements in the array which sum to x.
Array A can contain duplicate elements.
While printing a pair, print the smaller element first.
That is, if a valid pair is (6, 5) print "5 6". There is no constraint that out of 5 pairs which have to be printed in 1st line. You can print pairs in any order, just be careful about the order of elements in a pair.
Input format :
Line 1 : Integer N (Array size)
Line 2 : Array elements (separated by space)
Line 3 : Integer x
Output format :
Line 1 : Pair 1 elements (separated by space)
Line 2 : Pair 2 elements (separated by space)
Line 3 : and so on
Constraints :
1 <= N <= 1000
1 <= x <= 100
Sample Input:
9
1 3 6 2 5 4 3 2 4
7
Sample Output :
1 6
3 4
3 4
2 5
2 5
3 4
3 4
 */
class PairSum{	

	public static void pairSum(int[] arr, int num){
		/* Your class should be named PairSum
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Print output and don't return it.
	 	 * Taking input is handled automatically.
		 */
//         int i=0;
//         int j=arr.length-1;
//         int count=0,count1=0;
//         Arrays.sort(arr);
//         /*while(i<j){
//         if(arr[i]+arr[j]>num)
//             j--;
//         else if(arr[i]+arr[j]<num)
//             i++;
//         else{
//             while(arr[i]==arr[i+1]){
//                 count++;
//                 i++;
//             }
//             while(arr[j]==arr[j-1]){
//                 count1++;
//                 j--;
//             }
//             for(int k=0;k<(count*count1);k++){
//             System.out.println(arr[i]+" "+arr[j]);
//             }
//             count=0;
//             count1=0;
//         }*/
//         /while( i < j){
//         while((arr[i] + arr[j]) <= num && i < j)
//         {
//             if((arr[i] + arr[j]) == num)
//                 System.out.println(arr[i]+" "+arr[j]);
//             i++;
//         }
//         j--;
//         while((arr[i] + arr[j]) >= num && i < j)
//         {
//             if((arr[i] + arr[j]) == num)
//                 System.out.println(arr[i]+" "+arr[j]);
//             j--;
//         }
        
//         }
        
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(num==arr[i]+arr[j]){
                    if(arr[i]<arr[j]){
                        System.out.println(arr[i]+" "+arr[j]);
                        
                    }
                    else{
                         System.out.println(arr[j]+" "+arr[i]);
                    }
                    
                }
                
            }
            
            System.out.println();
        }
	}
}

public class ArrayPairSum {
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
		PairSum.pairSum(arr, num);
	}
}
