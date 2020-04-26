package rec;
import java.util.Scanner;
/*
Count Zeros
Given an integer n, count and return the number of zeros that are present in the given integer using recursion.
Input Format :
Integer n
Output Format :
No. of 0s
Sample Input :
10204
Sample Output
2
 */
class CountZero {
    static int count=0;
	public static int countZerosRec(int input){
		// Write your code here
        if(input==0)
            return 1;
        int d=input%10;
        if(d==0)
            count=count+1;
        countZerosRec(input/10);
        return count;
        
	}
}

public class CountZeroRec {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(CountZero.countZerosRec(n));
	}
}
