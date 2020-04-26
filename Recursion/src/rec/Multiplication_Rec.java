package rec;
import java.util.Scanner;
/*
Multiplication (Recursive)
Send Feedback
Given two integers m & n, calculate and return their multiplication using recursion. You can only use subtraction and addition for your calculation. No other operators are allowed.
Input format : m and n (in different lines)
Sample Input :
3 
5
Sample Output -
15
 */
class Multiplication {
	public static int multiplyTwoIntegers(int m, int n){
		// Write your code here
		if(n==0){
			return 1;
		}else if(n==1){
			return m;
		}
		return m+multiplyTwoIntegers(m,n-1);
	}
}

public class Multiplication_Rec {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		System.out.println(Multiplication.multiplyTwoIntegers(m, n));
	}
}
