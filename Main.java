import leetcode.MedianOfTwoSortedArrays;

import java.util.Arrays;

import arrays.OrderedPair;
import arrays.TwoDimensionalArray;

    
class Main {
    public static void main(String[] args) {
        medianOfTwoSortedArrays();
    }

    private static void medianOfTwoSortedArrays() {
        int[] arr1 = {1, 3};
        int[] arr2 = {2};

        System.out.println(MedianOfTwoSortedArrays.findMedianSortedArrays(arr1, arr2));
    }

    public static void rotateMatrix() {
        TwoDimensionalArray twoDArray = new TwoDimensionalArray(3, 5);
        twoDArray.traverse();
        int base = 0;
        for( int i=1; i<=3; i++) {
            for (int j=1;j<=5; j++) {
                twoDArray.set(i-1, j-1, base+j);
            }
            base += 10;
        }
        System.out.println("twoDArray: " + Arrays.deepToString(twoDArray.arr));
        twoDArray.set(3, 3, 50);


        System.out.println("Element at index (1, 4):" + twoDArray.get(1, 4));
        twoDArray.delete(1, 4);
        System.out.println("twoDArray: " + Arrays.deepToString(twoDArray.arr));

         OrderedPair pair1 = twoDArray.search(23);
         System.out.println("Index of value 23: (" + pair1.i + "," + pair1.j + ")");
         OrderedPair pair2 = twoDArray.search(34);
         System.out.println("Index of value 34: (" + pair2.i + "," + pair2.j + ")");


         System.out.println("New Array 3x3: " + Arrays.deepToString(new TwoDimensionalArray(3, 3, 0).arr));
    }
}