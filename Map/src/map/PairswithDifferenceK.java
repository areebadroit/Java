package map;
import java.util.HashMap;
import java.util.Scanner;
/*
Pairs with difference K
You are given with an array of integers and an integer K. Write a program to find and print all pairs which have difference K.
Take difference as absolute.
Input Format :
Line 1 : Integer n, Size of array
Line 2 : Array elements (separated by space)
Line 3 : K
Output format :
Print pairs in different lines (pair elements separated by space). In a pair, smaller element should be printed first.
(Order of different pairs is not important)
Constraints :
0 <= n <= 10^4
Sample Input 1 :
4 
5 1 2 4
3
Sample Output 1 :
2 5
1 4
Sample Input 2 :
4
4 4 4 4 
0
Sample Output 2 :
4 4
4 4
4 4
4 4
4 4
4 4
 */
class DifferenceKPairs {

	public static void findPairsDifferenceK(int[] input, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : input) {
            int p1 = i + k;
            boolean flag = false;
            if (i == p1) {
                flag = true;
            }
            if (map.containsKey(p1)) {
                int f2 = map.get(p1);
                for (int j = 0; j < f2; j++) {
                    if (p1 < i) {
                        System.out.println(p1 + " " + i);
                    } else {
                        System.out.println(i + " " + p1);
                    }
                }
            }
            int p2 = i - k;
            if (map.containsKey(p2) && !flag) {
                int f2 = map.get(p2);
                for (int j = 0; j < f2; j++) {
                    if (p2 < i) {
                        System.out.println(p2 + " " + i);
                    } else {
                        System.out.println(i + " " + p2);
                    }
                }
            }
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
    }
}

public class PairswithDifferenceK {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		int k = s.nextInt();
		s.close();
		DifferenceKPairs.findPairsDifferenceK(input, k);
	}
}
