package map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
/*
Longest consecutive Sequence
You are given with an array of integers that contain numbers in random order. Write a program to find the longest possible sequence of consecutive numbers using the numbers from given array.
You need to return the output array which contains consecutive elements. Order of elements in the output is not important.
Best solution takes O(n) time.
If two sequences are of equal length then return the sequence starting with the number whose occurrence is earlier in the array.
Input Format :
Line 1 : Integer n, Size of array
Line 2 : Array elements (separated by space)
Constraints :
0 <= n <= 10^8
Sample Input 1 :
13
2 12 9 16 10 5 3 20 25 11 1 8 6 
Sample Output 1 :
8 
9 
10 
11 
12
Sample Input 2 :
7
3 7 2 1 9 8 1
Sample Output 2 :
7
8
9
Explanation: Sequence should be of consecutive numbers. Here we have 2 sequences with same length i.e. [1, 2, 3] and [7, 8, 9], but output should be [7, 8, 9] because the starting point of [7, 8, 9] comes first in input array.
Sample Input 3 :
7
15 24 23 12 19 11 16
Sample Output 3 :
15 
16
 */
class Longest {
    public static int find(int[] a, int target)
    {
        for (int i = 0; i < a.length; i++)
            if (a[i] == target)
                return i;

        return -1;
    }
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],true);
            }
        }
        int maxLength=0;
        int Start=arr[0];
        for(int i=0;i<arr.length;i++){  
            int count=0;
            int startI=arr[i];
            if(map.get(arr[i])==true){
                count+=1;
                int j=arr[i];
                map.put(j,false);
                while(map.containsKey(j+1)){
                    map.put(j+1,false);
                    count+=1;
                    j+=1;
                }
                j=arr[i];
                while(map.containsKey(j-1)){
                    startI=j-1;
                    map.put(j-1,false);
                    count+=1;
                    j-=1;
                }
            }
            if(count==maxLength){
                Start=arr[Math.min(find(arr,Start),find(arr,startI))];
            }
            if(count>maxLength){
                maxLength=count;
                Start=startI;

            }
        }
        //System.out.println(maxLength+" "+Start);
        ArrayList<Integer> result=new ArrayList<>();
        for(int k=Start;k<Start+maxLength;k++){
            result.add(k);
        }
        return result;
    }
}
public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int arr[] = new int[n];

		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		s.close();
		ArrayList<Integer> ans = Longest.longestConsecutiveIncreasingSequence(arr);
		for(int num: ans) {
			System.out.println(num);
		}
	}
}
