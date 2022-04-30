package arrays;

import java.util.Arrays;

public class InsertIntoArray {
   
    public static void main(String[] args) {
        
        int[] arr = {1, 2, 3, 4, 5};
        insertIntoArray(arr, 2, 21);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertIntoArray(int[] arr, int ind, int val) {

        if(ind==arr.length) {
            return;
        }
        int temp = arr[ind];
        arr[ind] = val;
        insertIntoArray(arr, ind+1, temp);
    }

}

