package test;
import java.util.Scanner;
import java.util.Arrays;
class MaxProfit {
	public static int maximumProfit(int budget[]) {
		// Write your code here
        Arrays.sort(budget);
        /*for(int i=0;i<budget.length;i++){
            if(budget[i]==0){
                count++;
            }
        }
        int l= (budget.length+count)/2;
        return budget[l]*(budget.length-l);*/
        int max=0;
        for(int i=0;i<budget.length;i++){
        if((budget[i]*(budget.length-i))>max)
            max=(budget[i]*(budget.length-i));
        }
        return max;
            
    }
}

public class MaximumProfitOnApp {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i=0;i<n;i++)
			input[i] = s.nextInt();
		s.close();
		System.out.println(MaxProfit.maximumProfit(input));
	}
}
