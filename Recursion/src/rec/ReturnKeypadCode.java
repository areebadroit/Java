package rec;
import java.util.Scanner;
public class ReturnKeypadCode {
	public static String[] keypad(int n){
	       
	       // base case 
	       if(n==0){
				String[] empty = {""};
				return empty;
			}
			
	       String[] restOfKeypadComb = keypad(n/10);
	       String[] currentCombinations = keypadComb(n%10);
	       String[] allCombinations = new String [restOfKeypadComb.length*currentCombinations.length];
	       int k=0;
			for (String s1 : restOfKeypadComb){
	            for(String s2 : currentCombinations){
					allCombinations[k++]=s1+s2;
				}
	        }
			return allCombinations;
		
		}
	    
	    public static String[] keypadComb(int n){
	if(n == 2){
		String[] retVal = {"a","b","c"};
		return retVal;
	}
	else if(n == 3){
		String[] retVal = {"d","e","f"};
		return retVal;
	}
	else if(n == 4){
		String[] retVal = {"g","h","i"};
		return retVal;
	}

	else if(n == 5){
		String[] retVal = {"j","k","l"};
		return retVal;
	}

	else if(n == 6){
		String[] retVal = {"m","n","o"};
		return retVal;
	}

	else if(n == 7){
		String[] retVal = {"p","q","r","s"};
		return retVal;
	}

	else if(n == 8){
		String[] retVal = {"t","u","v"};
		return retVal;
	}
	else if(n == 9){
		String[] retVal = {"w","x","y","z"};
		return retVal;
	}
	else{
		String[] retVal = {};
		return retVal;
	}


	    }
	    public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			int input = s.nextInt();
			String output[] = keypad(input);
			for(int i = 0; i < output.length; i++) {
				System.out.println(output[i]);
			}
			s.close();
		}    
}
