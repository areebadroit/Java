package rec;

public class Power_Recursion {

		public static int power(int x, int n) {
	        if(n==0){
	            return 1;
	        }else if(n==1){
	            return x;
	        }
	        return x*power(x,n-1);
		}
		public static void main(String[] args) {
			System.out.println(power(5,5));
			
		}
	}
