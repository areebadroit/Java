package rec;
import java.util.Scanner;
/*
Number of Digits
Given the code to find out and return the number of digits present in a number recursively. But it contains few bugs, that you need to rectify such that all the test cases should pass.
Input Format :
Integer n
Output Format :
Count of digits
Constraints :
1 <= n <= 10^6
Sample Input :
 156
Sample Output :
3
 */
class Num_Dig_Rec {
	public static int count(int n){
		if(n<=9){
			return 1;
		}
		int smallAns=count(n / 10);
		return smallAns+1;
	}
}
public class NumberOfDigitsRec {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(Num_Dig_Rec.count(n));
	}
}
