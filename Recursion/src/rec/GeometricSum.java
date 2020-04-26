package rec;
import java.text.DecimalFormat;
import java.util.Scanner;
/*
Geometric Sum
Given k, find the geometric sum i.e.
1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k) 
using recursion. Return the answer.
Sample Input :
3
Sample Output :
1.875
 */
class Geometric {
    static double sum=1;
	public static double findGeometricSum(int k){
		// Write your code here
    if(k==0)
        return 1;
    findGeometricSum(k-1);
    sum+=(1/Math.pow(2,k));
    return sum;
	}
}

public class GeometricSum {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		double ans = Geometric.findGeometricSum(k);
		DecimalFormat dec = new DecimalFormat("#0.00000");
		System.out.println(dec.format(ans));
	}
}
