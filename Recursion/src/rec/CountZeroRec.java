package rec;

public class CountZeroRec {
	static int count=0;
	public static int countZerosRec(int input){
		// Write your code here
        if(input==0)
            return 1;
        int d=input%10;
        if(d==0)
            count=count+1;
        countZerosRec(input/10);
        return count;
        
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countZerosRec(102060));
	}

}
//package rec;
//
//public class CountZeroRec {
//	//static int count=0;
//	public static int countZerosRec(int input){
//		// Write your code here
//        if(input==0) {
//        	//System.out.println(1);
//            return 1;
//            }
//        int n=countZerosRec(input/10);
//        int d=input%10;
//        if(d==0)
//            n=n+1;
//        //System.out.println(count);
//        return n;
//        
//	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//System.out.println(102060);
//		System.out.println(countZerosRec(3005060)-1);
//	}
//
//}
