package recursion.multiplerecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSetSum2 {
  
  public static void main(String args[]) {
    
    int[] arr = { 2, 1, 2};
    System.out.println("Input: "+ Arrays.toString(arr));

    // printing all unique subsets
    System.out.println("Output: ");

    // time complexity = O(k*2^n); space complexity = O(k*2^n); auxiliary space complexity: O(n) (depth of recurison is size of array)
    Arrays.sort(arr);
    List<List<Integer>> ans = new ArrayList<>();
    printUniqueSubsetsOptimized(arr, 0, new ArrayList<>(), ans);
    System.out.println(ans);

    // time complexity = ( 2^n + 2^n log(2^n)); space complexity = 2^n
    // List<List<Integer>> ans = new ArrayList<>();
    // Set<List<Integer>> ansSet = new HashSet<>();
    // printUniqueSubsets(arr, 0, new ArrayList<>(), ansSet);
    // ansSet.stream().forEach(el -> {ans.add(el);});
    // System.out.println(ans);

    // time complexity = (n*2^n + 2^n log(2^n)); space complexity = 2^n
    // printUniqueSubsetsInPowerSet(arr);
  }

  public static void printUniqueSubsetsOptimized(int[] arr, int low, List<Integer> subset, List<List<Integer>> ans) {
    ans.add(new ArrayList<>(subset));
    // if(low>=arr.length) {
    //   return;
    // }
    // at current index, pick any index greater than or equal to current index, skip if element is repeating
    for(int i=low; i<arr.length; i++) {
      if(i>low && arr[i]==arr[i-1]) {
        continue;
      }
      subset.add(arr[i]);
      printUniqueSubsetsOptimized(arr, i+1, subset, ans);
      subset.remove(subset.size()-1);
    }
  }

  public static void printUniqueSubsetsInPowerSet(int arr[]) {
    Set<List<Integer>> ans = new HashSet<>();
    for(int i=0; i< (1<<arr.length); i++) {
      List<Integer> list = new ArrayList<>();
      for(int j=0;j<arr.length;j++) {
        if((i & (1<<j))!=0) {
          list.add(arr[j]);
        }
      }
      ans.add(list);
    }
    System.out.println(ans);
  }

  public static void printUniqueSubsets(int[] arr, int low, List<Integer> subset, Set<List<Integer>> ans) {
    if(low>=arr.length) {
      ans.add(new ArrayList<>(subset));
      return;
    }
    // not pick
    printUniqueSubsets(arr, low+1, subset, ans);
    //pick
    subset.add(arr[low]);
    printUniqueSubsets(arr, low+1, subset, ans);
    subset.remove(subset.size()-1);
  }

}

  
