package advancedA;
import java.util.*;
public class task2 {
    public static boolean ArrayComp(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        
        if (array1.length != array2.length)
        {
            return false;
            }
        
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i])
            {
                return false;
                }
     }
                return true;
   }


    public static void main(String [] args) {
    	int [] First_array = {1,2,3,4,5,1,3};
    	int [] Second_array = {5,2,3,1,4,3,1};
    	System.out.println("Do the arrays have the same set of numbers?");
    	System.out.println(ArrayComp(First_array,Second_array));
    	
    			
    	
    }	
}