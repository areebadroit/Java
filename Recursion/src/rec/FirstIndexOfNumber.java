package rec;
//Given an array and a number, you have to find the first occurrence of that number in the array
public class FirstIndexOfNumber {
	public static int firstIndex(int input[], int startIndex, int x) {
		if(startIndex >= input.length){
            return -1;
        }
        if(input[startIndex]==x){
            return startIndex;
        }
        int smallAns=firstIndex(input,startIndex+1,x);
        return smallAns;
		
	}
    public static int firstIndex(int input[], int x) {
		
		return firstIndex(input, 0, x);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p[]= {2,3,4,6,3};
		System.out.println(firstIndex(p,3));

	}

}
