package rec;
//check whether a number is present in an array or not using recursion;
public class CheckNumber_Array_Rec {
		
		public static boolean checkNumber(int input[], int x) {
			if(input.length<=0){
		            return false;
		        }
	        else if(input[0]==x){
	            return true;
	        }
		        int smallInput[] = new int[input.length - 1];
				for(int i = 1; i < input.length; i++){
					smallInput[i - 1] = input[i];
				}
		        boolean b = checkNumber(smallInput,x);
	        return b;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]= {1,4,7,8,10};//Modify the input here or take input from the user
		System.out.println(checkNumber(input,23));
	}

}
