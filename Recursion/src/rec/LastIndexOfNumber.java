package rec;
//Given an array and a number, you have to find the last occurrence of that number in the array
public class LastIndexOfNumber {
	public static int lastIndex(int input[], int endIndex, int x) {
		if(endIndex <= 0){
            return -1;
        }
        if(input[endIndex]==x){
            return endIndex;
        }
        int smallAns=lastIndex(input,endIndex-1,x);
        return smallAns;
		
	}
    public static int lastIndex(int input[], int x) {
		
		return lastIndex(input, input.length-1, x);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p[]= {2,3,4,6,3};
		System.out.println(lastIndex(p,3));
	}

}
