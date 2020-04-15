package test;
import java.util.*;
/*Given an integer array A of size N, check if the input array can be splitted in two parts such that -
- Sum of both parts is equal
- All elements in the input, which are divisible by 5 should be in same group.
- All elements in the input, which are divisible by 3 (but not divisible by 5) should be in other group.
- Elements which are neither divisible by 5 nor by 3, can be put in any group.
Groups can be made with any set of elements, i.e. elements need not to be continuous. And you need to consider each and every element of input array in some group.
Return true, if array can be split according to the above rules, else return false.*/
class SplitArraySoln {
	public static boolean splitArray(int input[]) {
		return splitArray(input,input.length,0,0,0);	
	}
    public static boolean splitArray(int input[], int n, int s, int lsum, int rsum) {
		if(s==n)
            return lsum==rsum;
        if(input[s]%5==0)
            lsum+=input[s];
        else if(input[s]%3==0)
            rsum+=input[s];
        else
            return splitArray(input, n, s+1, lsum+input[s], rsum)||splitArray(input, n, s+1, lsum, rsum+input[s]);
		return splitArray(input, n, s+1, lsum, rsum);
	}
}

public class SplitArray {
static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		System.out.println(SplitArraySoln.splitArray(input));
	}
}
