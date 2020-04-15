package rec;
/*Given an array and a number, you have to find all occurrence of that number in the array and store the indexes in a new array
and return it to the function caller */
public class All_IndicesOfNumber {
	static int i=1;
    static int smallArray[]=new int[0];
	public static int[] allIndexes(int input[],int startIndex,   int x) {
        
		if(startIndex > input.length-1){
            
            return new int[0];
        }
        if(startIndex<input.length){
        smallArray = allIndexes(input,startIndex+1,x);
        if(input[startIndex]==x){
        	int temp[]=smallArray;
//            int temp[]=new int[smallArray.length];
//                for(int j=0;j<smallArray.length;j++){
//                    temp[j]=smallArray[j];
//                }
            smallArray=new int[temp.length+1];
             for(int j=1;j<smallArray.length;j++){
                    smallArray[j]=temp[j-1];
                }
            smallArray[0]=startIndex;
        }
        }
       return smallArray;
	}
    public static int[] allIndexes(int input[], int x) {
		
		return allIndexes(input, 0, x);
		
	}
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p[]= {2,3,4,6,3};
		int result[]=allIndexes(p,3);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]);
			System.out.print(" ");
		}
	}

    
}
