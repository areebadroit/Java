package map;
import java.util.*;
/*
Longest subset zero sum
Given an array consisting of positive and negative integers, find the length of the longest subarray whose sum is zero.
NOTE: You have to return the length of longest subarray .
Input Format :
Line 1 : Contains an integer N i.e. size of array

Line 2 : Contains N elements of the array, separated by spaces
Output Format
 Line 1 : Length of longest subarray 
Constraints:
0 <= N <= 10^8
Sample Input :
10 
 95 -97 -387 -435 -5 -70 897 127 23 284
Sample Output :
5
 */
class SubSetZeroSum 
{
    public static int lengthOfLongestSubsetWithZeroSum(ArrayList<Integer> arr) 
   	{
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        int longest=0;
        map.put(0,0);
        for(int i=0;i<arr.size();i++){
            sum=sum+arr.get(i);
            if(!map.containsKey(sum)){
            	map.put(sum,i+1);
            }else{
                int smallLong=i+1-map.get(sum);
                if(smallLong>longest)
                    longest=smallLong;
            }
        }
        return longest;
	}
}

public class LongestSubsetZeroSum {
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();

		int size = scan.nextInt();
		for(int i = 0; i < size; i++)
			arr.add(scan.nextInt());

		System.out.println(SubSetZeroSum.lengthOfLongestSubsetWithZeroSum(arr));
		scan.close();
	}
}
