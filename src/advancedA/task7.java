package advancedA;

import java.util.Arrays;

public class task7 {
    public static void Sortheaps(int[] arr) {
        int L = arr.length;

        for (int i = L / 2 - 1; i >= 0; i--) 
        {
             heap(arr, L, i);
        }

        for (int i = L - 1; i >= 0; i--) 
        {
        	
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heap(arr, i, 0);
        }
     }

    private static void heap(int[] arr, int n, int s) {
        int smallest = s, left = 2 * s + 1, right = 2 * s + 2;

        if (left < n && arr[left] < arr[smallest]) 
        {
        	smallest = left;
        }
        if (right < n && arr[right] < arr[smallest])
        {
        	smallest = right;
        }

        if (smallest != s) 
        {
            int temp = arr[s];
            arr[s] = arr[smallest];
            arr[smallest] = temp;
            heap(arr, n, smallest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 7, 2, 1, 44, 9, 8};
        Sortheaps(arr);
        System.out.println(Arrays.toString(arr));
    }
}
