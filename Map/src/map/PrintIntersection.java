package map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
/*
Print Intersection
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
	public static void intersection(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr1.length; i++){
			if(!map.containsKey(arr1[i])){
				map.put(arr1[i],1);
			} else {
				int oldValue = map.get(arr1[i]);
				map.put(arr1[i], oldValue + 1);
			}
		}
		for(int i = 0; i < arr2.length; i++){
			if(map.containsKey(arr2[i])){
				int value = map.get(arr2[i]);
				if(value > 0){
					System.out.println(arr2[i]);
					map.put(arr2[i], value - 1);
				}
			}
		}
	}
}
/*class Intersection{


   public static void intersection(int[] arr1, int[] arr2){
        HashMap<Integer,Integer> intersec1 = new HashMap<>();
        HashMap<Integer,Integer> intersec2 = new HashMap<>();
        HashMap<Integer,Integer> intersec3 = new HashMap<>();
        for(int i=0;i<arr1.length;i++){
            if(intersec1.containsKey(arr1[i])){
                intersec1.put(arr1[i],intersec1.get(arr1[i])+1);
                continue;
            }
            intersec1.put(arr1[i],1);
        }
        for(int i=0;i<arr2.length;i++){
            if(intersec2.containsKey(arr2[i])){
                intersec2.put(arr2[i],intersec2.get(arr2[i])+1);
                continue;
            }
            intersec2.put(arr2[i],1);
        }
        for(int i=0;i<arr2.length;i++){
            if(intersec1.containsKey(arr2[i])&&intersec2.containsKey(arr2[i])){
                intersec3.put(arr2[i],Math.min(intersec1.get(arr2[i]),intersec2.get(arr2[i])));
                continue;
            }
            intersec2.put(arr2[i],1);
        }
       Set<Integer> keys = intersec3.keySet();
       for (Integer str : keys) {
           // if(intersec3.get(str) > 0){
           //     System.out.println(str);
           //     intersec3.put(str, intersec3.get(str) - 1);
           // }
           for(int j=0;j<intersec3.get(str);j++)
               System.out.println(str);
       }
   	}
    }
    */
public class PrintIntersection {
	static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
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
