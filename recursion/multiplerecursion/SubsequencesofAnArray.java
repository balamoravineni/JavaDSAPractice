package recursion.multiplerecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsequencesofAnArray {
  
  public static void main(String args[]) {
  
    int[] arr = {3, 4, 2};
    System.out.println("Input: "+ Arrays.toString(arr));
    System.out.println("Output: ");
    printAllSubsequences(arr, 0, new ArrayList<>());

  }

  public static void printAllSubsequences(int[] arr, int low, List<Integer> subsequence) {
    if(low>=arr.length) {
      // if(subsequence.size()>0){
        System.out.println(subsequence);
      // }
      return;
    }
    printAllSubsequences(arr, low+1, subsequence);
    subsequence.add(arr[low]);
    printAllSubsequences(arr, low+1, subsequence);
    subsequence.remove(subsequence.size()-1);
    
  }


}
