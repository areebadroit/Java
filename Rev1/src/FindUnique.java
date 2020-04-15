
public class FindUnique{	

	public static int findUnique(int[] arr){
		/* Your class should be named FindUnique
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		 */
        /*int p=0;
        Arrays.sort(arr);
        int count=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                arr[i]=-1;
                arr[i+1]=-1;
                i=i+2;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=-1){
                p=arr[i];
                break;
            }
                
        }
        return p;*/
		int res = 0; 
	    for (int i = 0; i < arr.length; i++) 
	        res = res ^ arr[i]; 
	    return res; 
	}
}