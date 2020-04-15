package rec;

public class Multiplication_Rec {
	public static int multiplyTwoIntegers(int m, int n){
		// Write your code here
	if(n==0){
            return 0;
        }else if(n==1){
            return m;
        }
        return m+multiplyTwoIntegers(m,n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiplyTwoIntegers(3,5));
	}
}
