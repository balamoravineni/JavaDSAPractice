package recursion.multiplerecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation1 {

  public static void main(String args[]) {
    
    int arr[] = {1, 2, 3}; // array of distint integers
    System.out.println("Input: "+ Arrays.toString(arr));
    System.out.println("Output: ");

    printAllPermutations(arr, 0, new HashSet<>(), new ArrayList<>());
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
}
