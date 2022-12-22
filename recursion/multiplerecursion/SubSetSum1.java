package recursion.multiplerecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubSetSum1 {
  
  public static void main(String args[]) {
    
    int[] arr = { 2, 3 };
    System.out.println("Input: "+ Arrays.toString(arr));

    // printing subset sums in increasing order
    Arrays.sort(arr);
    System.out.println("Output: ");

    // time complexity = (n*2^n + 2^n log(2^n)); space complexity = 2^n
    // printPowerSetSums(arr);

    List<Integer> ans = new ArrayList<>();
    // time complexity = ( 2^n + 2^n log(2^n)); space complexity = 2^n
    printSubsetSums(arr, 0, 0, ans);
    ans.sort((x, y)-> x-y);
    System.out.println(ans);
  }

  public static void printPowerSetSums(int arr[]) {
    List<Integer> ans = new ArrayList<>();
    for(int i=0; i< (1<<arr.length); i++) {
      int sum=0;
      for(int j=0;j<arr.length;j++) {
        if((i & (1<<j))!=0) {
          sum += arr[j];
        }
      }
      ans.add(sum);
    }
    Collections.sort(ans);
    System.out.println(ans);
  }

  public static void printSubsetSums(int[] arr, int low, int sum, List<Integer> ans) {
    if(low>=arr.length) {
      // System.out.print(sum + " ");
      ans.add(sum);
      return;
    }
    // not pick
    printSubsetSums(arr, low+1, sum, ans);
    //pick
    printSubsetSums(arr, low+1, sum+arr[low], ans);
  }
}

  
