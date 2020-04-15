package rec;
public class SumOfDigits {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sumOfDigits(1256));
	}
}
