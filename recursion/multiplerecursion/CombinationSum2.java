package recursion.multiplerecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
  public static void main(String args[]) {
  
    int[] arr = {10, 1, 2, 7, 6, 1, 5};
    int sum = 8;
    System.out.println("Input:");
    System.out.println("Given Array: " + Arrays.toString(arr));
    System.out.println("Given Sum: "+ sum);
    System.out.println("Output: ");

    List<Integer> inputList = new ArrayList<>();
    Arrays.stream(arr).forEach(element -> inputList.add(element));

    inputList.sort((x, y)-> x-y);
    System.out.println("Sorted Array: "+ inputList);

    // main recursive function - we can pick an element only once, duplicate answers not allowed
    boolean isPresent = printAllUniqueCombinationsOfSum(inputList, sum, 0, new ArrayList<>());
    if(!isPresent) {
      System.out.println("No Such combination");
    }
  }

  public static boolean printAllUniqueCombinationsOfSum(List<Integer> list, int sum, int low, List<Integer> combination) {

    if(sum==0) {
      System.out.println(combination);
      return true;
    }

    boolean result = false;
    int current;

    // at every index, we can pick any of the indexes greater than or equal to that index
    // we also need to avoid duplicate values if already picked
    for(int i=low; i<list.size();) {
      if(sum>=list.get(i)) {
        current = list.get(i);
        combination.add(list.get(i));
        if(printAllUniqueCombinationsOfSum(list, sum-current, i+1, combination)) {
          result = true;
        }
        combination.remove(combination.size()-1);
        while(i<list.size() && list.get(i)==current) {
          i++;
        }
      }
      else {
        break;
      }
    }
    return result;
  }

}
