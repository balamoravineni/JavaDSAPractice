package recursion.multiplerecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {

  public static void main(String args[]) {
    
    int arr[] = {1, 2, 3}; // array of distint integers
    System.out.println("Input: "+ Arrays.toString(arr));
    System.out.println("Output: ");

    //recursion - approach of picking any element not picked before 
    // time complexity: O(n!*n); space complexity: O(n); auxilary space complexity: O(n);
    printAllPermutations(arr, 0, new HashSet<>(), new ArrayList<>());

    //recusion - approach of swapping
    // time complexity: O(n!*n); space complexity: O(1); auxilary space complexity: O(n);
    printAllPermutationsBySwapping(arr, 0);
  }

  public static void printAllPermutations(int[] arr, int low, Set<Integer> alreadyTaken, List<Integer> permutation) {
    if(low>=arr.length) {
      System.out.println(permutation);
      return;
    }
    for(int i=0; i<arr.length; i++) {
      if(!alreadyTaken.contains(arr[i])) {
        permutation.add(arr[i]);
        alreadyTaken.add(arr[i]);
        printAllPermutations(arr, low+1, alreadyTaken, permutation);
        permutation.remove(permutation.size()-1);
        alreadyTaken.remove(arr[i]);
      }
    }
  }

  public static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public static void printAllPermutationsBySwapping(int[] arr, int low) {
    if(low>=arr.length) {
      System.out.println(Arrays.toString(arr));
      return;
    }

    for(int i=low;i<arr.length;i++) {
      swap(arr, i, low);
      printAllPermutationsBySwapping(arr, low+1);
      swap(arr, i, low);
    }
    
  }
}
