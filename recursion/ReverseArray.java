package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number & array: ");
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        reverseArray(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseArray(int[] arr, int i) {

        if(i==arr.length/2) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[arr.length-1-i];
        arr[arr.length-1-i] = temp;
        reverseArray(arr, i+1);
    }

}
