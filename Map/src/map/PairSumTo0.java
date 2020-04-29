package map;
import java.util.*;
/*
Pair Sum to 0
Given a random integer array A of size N. Find and print the pair of elements in the array which sum to 0.
Array A can contain duplicate elements.
While printing a pair, print the smaller element first.
That is, if a valid pair is (6, -6) print "-6 6". There is no constraint that out of 5 pairs which have to be printed in 1st line. You can print pairs in any order, just be careful about the order of elements in a pair.
Input format :
Line 1 : Integer N (Array size)
Line 2 : Array elements (separated by space)
Output format :
Line 1 : Pair 1 elements (separated by space)
Line 2 : Pair 2 elements (separated by space)
Line 3 : and so on
Constraints :
0 <= N <= 10^4
Sample Input:
5
2 1 -2 2 3
Sample Output :
-2 2
-2 2
 */
class Sum0 {
	public static void PairSum(int[] input, int size) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < size; i++){
			if(!map.containsKey(input[i])){
				map.put(input[i],1);
                if(map.containsKey(-input[i])){
                    for(int j=0;j<map.get(-input[i]);j++)
                    System.out.println(Math.min(-input[i],input[i])+" "+Math.max(-input[i],input[i]));
                }
			} else {
                 if(map.containsKey(-input[i])){
                    for(int j=0;j<map.get(-input[i]);j++)
                    System.out.println(Math.min(-input[i],input[i])+" "+Math.max(-input[i],input[i]));
                 }
				int oldValue = map.get(input[i]);
				map.put(input[i], oldValue + 1);
			}
		}
}
}
public class PairSumTo0 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n = s.nextInt();
		int arr[]=new int[n];
		for(int i=0; i<n; i++)
		{
			arr[i]=s.nextInt();
		}		
		s.close();
	Sum0.PairSum(arr, n);
	}
}
