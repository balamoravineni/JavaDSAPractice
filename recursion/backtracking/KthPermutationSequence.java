package recursion.backtracking;

public class KthPermutationSequence {
  
  public static void main(String args[]) {
    
    int n=4; // all permutations of numbers 1,2,3,4
    int k=23; //output the kth permutation

    System.out.println("Input: ");
    System.out.println("n = " + n);
    System.out.println("k = " + k);

    System.out.println("Output: ");
    int totalPermutations = factorial(n);
    // for(k=1;k<=totalPermutations;k++) {
      String ans = "";
      boolean[] visited = new boolean[n];
      findPermutation(visited, totalPermutations, n, k, ans);
    // }


  }

  public static int factorial(int n) {
    if(n<=1) {
      return 1;
    }
    return n*factorial(n-1);
  }

  public static void findPermutation(boolean[] visited, int totalPermutations, int n, int k, String ans) {
    if(n==0) {
      System.out.println(ans);
      return;
    }
    int remainingPermutations = totalPermutations/n;
    int count = 0;
    for(int i=0;i<visited.length;i++) {
      if(!visited[i]) {
        count+=remainingPermutations;
        if(k<=count) {
          ans += Integer.toString(i+1);
          visited[i] = true;
          findPermutation(visited, remainingPermutations, n-1, k-(count-remainingPermutations), ans);
        }
      }
    }

  }
}
