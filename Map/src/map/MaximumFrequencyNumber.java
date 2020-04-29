package map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
/*
Maximum Frequency Number
You are given an array of integers that contain numbers in random order. Write a program to find and return the number which occurs the maximum times in the given input.
If two or more elements contend for the maximum frequency, return the element which occurs in the array first.
Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Output Format :
Most frequent element
Constraints :
0 <= N <= 10^8
Sample Input 1 :
13
2 12 2 11 12 2 1 2 2 11 12 2 6 
Sample Output 1 :
2
Sample Input 2 :
3
1 4 5
Sample Output 2 :
1
 */
class MaxFreq {
	public static int maxFrequencyNumber(int[] arr){
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer,Integer> numMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(numMap.containsKey(arr[i])){
                numMap.put(arr[i],numMap.get(arr[i])+1);
                continue;
            }
            numMap.put(arr[i],1);
            output.add(arr[i]);
        }
        //Set<Integer> keys = numMap.keySet();
       
        int maxk=output.get(0);
        //System.out.println(maxk);
         int maxv=numMap.get(maxk);
         //System.out.println(maxv);
		for (Integer i : output) {
            if(numMap.get(i)>maxv){
                maxv=numMap.get(i);
                maxk=i;
            }
            //System.out.println(i);
		}
        return maxk;
	}
}
public class MaximumFrequencyNumber {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int sze = s.nextInt();
		int[] arr = new int[sze];
		for(int index = 0;index<sze;index++){
			arr[index]=s.nextInt();
		}
		s.close();
		System.out.println(MaxFreq.maxFrequencyNumber(arr));
	}
}
