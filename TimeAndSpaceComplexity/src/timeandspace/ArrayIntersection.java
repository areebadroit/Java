package timeandspace;
import java.util.*;
/*
Print Array intersection

Given two random integer arrays, print their intersection. That is, print all the elements that are present in both the given arrays.
Input arrays can contain duplicate elements.
Note : Order of elements are not important
Input format :
Line 1 : Integer N, Array 1 Size
Line 2 : Array 1 elements (separated by space)
Line 3 : Integer M, Array 2 Size
Line 4 : Array 2 elements (separated by space)
Output format :
Print intersection elements in different lines
Constraints :
0 <= M, N <= 5 * 10^7
Sample Input 1 :
6
2 6 8 5 4 3
4
2 3 4 7 
Sample Output 1 :
2 
4 
3
Sample Input 2 :
4
2 6 1 2
5
1 2 3 4 2
Sample Output 2 :
2 
2
1
 */
class Intersection{
	
	public static void intersection(int[] arr1, int[] arr2){
         int i = 0, j = 0; 
         Arrays.sort(arr1);
         Arrays.sort(arr2);
        while (i < arr1.length && j < arr2.length)  
        { 
                  
            if (arr1[i] > arr2[j])  
            { 
                j++; 
            }  
                  
            else
                if (arr2[j] > arr1[i])  
                { 
                    i++; 
                }  
                else
                { 
                // when both are equal 
                    System.out.println(arr1[i]); 
                    i++; 
                    j++; 
                } 
        } 
	}
}
public class ArrayIntersection {	
		static Scanner s = new Scanner(System.in);
		public static int[] takeInput() {
			int size = s.nextInt();
			int arr[] = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = s.nextInt();
			}
			s.close();
			return arr;
		}

		public static void print(ArrayList<Integer> list) {
			for (int i : list) {
				System.out.print(i+" ");
			}
		}
		
		public static void main(String[] args) {
			int[] arr1 = takeInput();
			int[] arr2 = takeInput();
			Intersection.intersection(arr1, arr2);
		}
	}
