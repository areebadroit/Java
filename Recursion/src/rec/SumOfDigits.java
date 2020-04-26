package rec;
import java.util.Scanner;
/*
Sum of digits (recursive)
Write a recursive function that returns the sum of the digits of a given integer.
Sample Input :
12345
Sample Output :
15
 */
class DigSum {
    static int sum=0;
	public static int sumOfDigits(int input){
		// Write your code here
        if(input==0)
            return 0;
        if(input<=9)
            return input;
        sum+=(input%10)+sumOfDigits(input/10);
        return sum;
	}
}

public class SumOfDigits {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(DigSum.sumOfDigits(n));
	}
}
