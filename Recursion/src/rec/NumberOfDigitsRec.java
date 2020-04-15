package rec;

public class NumberOfDigitsRec {
	//static int smallAns=0;
		public static int count(int n){
			if(n<=9){
				return 1;
			}
			int smallAns=count(n / 10);
			return smallAns+1;
		}
		public static void main(String[] args) {
			System.out.println(count(2564));
		}
	}
