package rec;
//Calculating the sum of elements of array using recursion
public class Array_Sum_Rec {
		public static int sum(int input[]) {

			if(input.length<=0){
	            return 0;
	        }
	        int smallInput[] = new int[input.length - 1];
			for(int i = 1; i < input.length; i++){
				smallInput[i - 1] = input[i];
			}
	        return input[0]+sum(smallInput);
		}
		public static void main(String[] args) {
			int input[]= {1,4,7,8,10};//Modify the input here or take input from the user
			System.out.println(sum(input));
		}
	}
