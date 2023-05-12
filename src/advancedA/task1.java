package advancedA;
import java.util.Arrays;
import java.util.*;
public class task1 {
	public static String Duplicatesremover(char arr[], int n){
	        int ind = 0;
	        for (int i = 0; i < n; i++)
	        {
	            int j;
	            for (j = 0; j < i; j++)
	            {
	                if (arr[i] == arr[j])
	                {
	                    break;
	                    }
	                }
	            if (j == i)
	            {
	                arr[ind++] = arr[i];
	                }
	            }
	        return String.valueOf(Arrays.copyOf(arr, ind));
	        }
	public static void main (String[] args) {
		char Duplicated_array[] = {'m','o','h','a','m','e','d','r','e','d','a'};

		System.out.println( Duplicatesremover(Duplicated_array,Duplicated_array.length));
		}

	}

