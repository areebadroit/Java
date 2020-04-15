//package rec;
//import java.util.*;
//public class TowerOfHanoi {
//	public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
//		// Write your code here
//        if(disks==0){
//            //System.out.println(source+" "+destination);
//            return;
//        }
//        towerOfHanoi(disks-1,source, destination, auxiliary);
//        System.out.println(source+" "+destination);
//        towerOfHanoi(disks-1,auxiliary, source, destination);
//	}
//	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		int n = s.nextInt();
//		towerOfHanoi(n, 'a', 'b', 'c');
//		s.close();
//	}
//}
//package rec;
//import java.util.*;
//public class TowerOfHanoi {
//	public static void towerOfHanoi(int disks, String source, String auxiliary, String destination) {
//		// Write your code here
//        if(disks==0){
//            //System.out.println(source+" "+destination);
//            return;
//        }
//        System.out.println(disks-1+" "+source+" "+ auxiliary +" "+destination);
//        towerOfHanoi(disks-1,source, destination, auxiliary);
//        //System.out.println(source+" "+destination);
//        System.out.println(disks-1+" "+auxiliary+" "+ source +" "+destination);
//        towerOfHanoi(disks-1,auxiliary, source, destination);
//	}
//	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		int n = s.nextInt();
//		System.out.println(n+" "+"source"+" "+ "auxiliary" +" "+"destination");
//		towerOfHanoi(n, "source", "auxiliary", "destination");
//		s.close();
//	}
//}
package rec;
import java.util.*;
public class TowerOfHanoi {
	public static void towerOfHanoi(int disks, String source, String auxiliary, String destination) {
		// Write your code here
        if(disks==0){
            //System.out.println(source+" "+destination);
            return;
        }
        System.out.println(disks-1+" "+source+" "+ auxiliary +" "+destination);
        towerOfHanoi(disks-1,source, destination, auxiliary);
        System.out.println(source+" "+destination);
        System.out.println(disks-1+" "+auxiliary+" "+ source +" "+destination);
        towerOfHanoi(disks-1,auxiliary, source, destination);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(n+" "+"a"+" "+ "b" +" "+"c");
		towerOfHanoi(n, "a", "b", "c");
		s.close();
	}
}

