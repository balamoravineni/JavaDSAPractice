package recursion.multiplerecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum1 {
  public static void main(String args[]) {
  
    int[] arr = {2, 3, 6, 7, 2};
    int sum = 9;
    System.out.println("Input:");
    System.out.println("Given Array: " + Arrays.toString(arr));
    System.out.println("Given Sum: "+ sum);
    System.out.println("Output: ");

    // passing a list of input integers to avoid duplicates for unique combinations
    Set<Integer> inputSet = new HashSet<>();
    Arrays.stream(arr).forEach(element -> inputSet.add(element));
    List<Integer> inputList = new ArrayList<>();
    inputSet.stream().forEach(element -> inputList.add(element));

    // main recursive function - we can pick an element multiple times, if duplicates are not allowed, just remove duplicate elements in the inputList
    boolean isPresent = printAllUniqueCombinationsOfSum(inputList, sum, 0, new ArrayList<>());
    if(!isPresent) {
      System.out.println("No Such combination");
    }
  }

  public static boolean printAllUniqueCombinationsOfSum(List<Integer> list, int sum, int low, List<Integer> combination) {
    if(low>=list.size() || sum==0) {
      if(sum==0) {
        System.out.println(combination);
        return true;
      }
      return false;
    }

    //not pick current element
    boolean left = printAllUniqueCombinationsOfSum(list, sum, low+1, combination);
    //pick current element, but don't increment the index (for multiple picking)
    boolean right = false;
    if(sum>=list.get(low)) {
      sum -= list.get(low);
      combination.add(list.get(low));
      right = printAllUniqueCombinationsOfSum(list, sum, low, combination);
      combination.remove(combination.size()-1);
    }
    return left || right;
  }

}
