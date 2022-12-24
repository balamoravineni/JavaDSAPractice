package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

  public static void main(String args[]) {
    String str = "aabb";
    System.out.println("Input: "+ str);

    System.out.println("Output: ");
    List<List<String>> ans = new ArrayList<>();
    palindromes(str, 0, new ArrayList<>(), ans);
    System.out.println(ans);
  }

  public static void palindromes(String str, int i, List<String> partitions, List<List<String>> ans) {
    // when partitioning is done at the end, 
    //we have all the required partitons in out partitions datastructure
    if(i==str.length()) {
      ans.add(new ArrayList<>(partitions));
      return;
    }
    for(int j=i+1;j<=str.length();j++) {
      // partition at j index, only if substring i to j, is palindrome
      if(isPalindrome(str.substring(i,j), 0)) {
        partitions.add(str.substring(i,j));
        palindromes(str, j, partitions, ans);
        partitions.remove(partitions.size()-1);
      }
    }
  }

  public static boolean isPalindrome(String str, int ind) {
    if(str.length()%2==0 && ind==str.length()/2-1) {
      return str.charAt(ind)==str.charAt(str.length()-1-ind);
    }
    else if(str.length()%2!=0 && ind==str.length()/2) {
      return true;
    }
    return str.charAt(ind)==str.charAt(str.length()-1-ind) && isPalindrome(str, ind+1);
  }

  
}
