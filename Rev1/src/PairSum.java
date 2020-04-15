import java.util.Arrays;
public class PairSum{	

	public static void pairSum(int[] arr, int num){
		/* Your class should be named PairSum
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Print output and don't return it.
	 	 * Taking input is handled automatically.
		 */
        int i=0;
        int j=arr.length-1;
        Arrays.sort(arr);
        while(i!=j){
        if((arr[i]+arr[j])>num)
            j--;
        else if((arr[i]+arr[j])<num)
            i++;
        else
            System.out.print(arr[i]+" "+arr[j]);
        System.out.println();
        }
	}
}