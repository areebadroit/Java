package timeandspace;
import java.util.*;
//Given two random integer arrays, print their intersection. That is, print all the elements that are present in both the given arrays.
//Input arrays can contain duplicate elements.
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
