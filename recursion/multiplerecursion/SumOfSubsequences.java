package recursion.multiplerecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfSubsequences {
  public static void main(String args[]) {
  
    int[] arr = {5, 1, 3, 3, 2 };
    int sum = 8;
    System.out.println("Input:");
    System.out.println("Array: "+ Arrays.toString(arr));
    System.out.println("Given Sum: "+ sum);
    System.out.println("Output: ");

    printAllSubsequencesOfSum(arr, sum, 0, new ArrayList<>(), 0);

    // boolean isPresent = printAnyOneSubsequenceOfSum(arr, sum, 0, new ArrayList<>(), 0);
    // if(!isPresent) {
    //   System.out.println("No such subsequence");
    // }

    System.out.println(countAllSubsequencesOfSum(arr, sum, 0, 0));
  }

  public static void printAllSubsequencesOfSum(int[] arr, int givenSum, int low, List<Integer> subsequence, int sumOfSubsequence) {
    if(low>=arr.length) {
      if(sumOfSubsequence==givenSum) {
        System.out.println(subsequence);
      }
      return;
    }
    // not take element
    printAllSubsequencesOfSum(arr, givenSum, low+1, subsequence,  sumOfSubsequence);
    // take element
    subsequence.add(arr[low]);
    printAllSubsequencesOfSum(arr, givenSum, low+1, subsequence, sumOfSubsequence+arr[low]);
    // int last = subsequence.get(subsequence.size()-1);
    subsequence.remove(subsequence.size()-1);
  }

  public static boolean printAnyOneSubsequenceOfSum(int[] arr, int givenSum, int low, List<Integer> subsequence, int sumOfSubsequence) {
    if(low>=arr.length) {
      if(sumOfSubsequence==givenSum) {
        System.out.println(subsequence);
        return true;
      }
      return false;
    }
    // not take element
    if(printAnyOneSubsequenceOfSum(arr, givenSum, low+1, subsequence,  sumOfSubsequence)) {
      return true;
    }
    // take element
    subsequence.add(arr[low]);
    if(printAnyOneSubsequenceOfSum(arr, givenSum, low+1, subsequence, sumOfSubsequence+arr[low])) {
      return true;
    }
    subsequence.remove(subsequence.size()-1);
    return false;
  }

  public static int countAllSubsequencesOfSum(int[] arr, int givenSum, int low, int sumOfSubsequence) {

    // slight optimization when array contains only positive numbers
    // worst case scenario complexity is still 2^n
    if(sumOfSubsequence>givenSum) {
      return 0;
    }
    
    if(low>=arr.length) {
      if(sumOfSubsequence==givenSum) {
        return 1;
      }
      return 0;
    }
    // not take element
    int count1 = countAllSubsequencesOfSum(arr, givenSum, low+1,  sumOfSubsequence);
    // take element
    int count2 = countAllSubsequencesOfSum(arr, givenSum, low+1, sumOfSubsequence+arr[low]);

    return count1+count2;

  }

}
