package rec;
import java.util.Scanner;
/*
Staircase
A child is running up a staircase with N steps, and can hop either 1 step, 2 steps or 3 steps at a time. 
Implement a method to count how many possible ways the child can run up to the stairs. You need to return number of possible ways W.
Input format :
Line 1 : Integer N (No. of steps) 
Output Format :
Line 1 : Integer W i.e. Number of possible ways
Constraint :
(1 <= N <= 30)
Sample Input 1:
4
Sample Output :
7
 */
class Stair {
	public static int staircase(int n){
		if (n == 1 || n == 0)  
			return 1; 
		else if (n == 2)  
			return 2;
		else
			return staircase(n - 3) +  
					staircase(n - 2) + 
					staircase(n - 1);     
	}
}
public class Staircase {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(Stair.staircase(n));
	}
}
