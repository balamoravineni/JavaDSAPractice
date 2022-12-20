package recursion.functionalrecursion;

import java.util.ArrayList;
import java.util.List;

public class ReverseArray {

  public static void main(String args[]) {
  
    List<Integer> arrayList = new ArrayList<>();
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(4);
    arrayList.add(5);

    System.out.println("Input: "+ arrayList);
    reverse(arrayList, 0);
    System.out.println("Output: "+ arrayList);

    
  }

  public static void reverse(List<Integer> arr, int lo, int hi) {
    if(lo>=hi) {
      return;
    }
    int temp = arr.get(lo);
    arr.set(lo, arr.get(hi));
    arr.set(hi, temp);
    reverse(arr, lo+1, hi-1);
  }

  public static void reverse(List<Integer> arr, int lo) {
    if(lo>=arr.size()/2) {
      return;
    }
    int temp = arr.get(lo);
    arr.set(lo, arr.get(arr.size()-1-lo));
    arr.set(arr.size()-1-lo, temp);
    reverse(arr, lo+1);
  }
}
