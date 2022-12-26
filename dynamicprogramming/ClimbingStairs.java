package dynamicprogramming;

public class ClimbingStairs {
  // from 0th stair to nth stair, print distinct ways of climibing
  // we can climb one or two steps at one time
  // TODO -- if n!2^17, we need to use matrix exponentation method for this problem.
  // otherwise this problem is similar to Fibonacci

  public static void main(String args[]) {
    
    int n = 3;
    System.out.println("Input: " + n);

    int[] dp = new int[n+1];
    for(int i=0;i<=n;i++) {
      dp[i] = -1;
    }
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    System.out.println("Output: "+ climb(n, dp));

  }

  //memoization
  public static int climb(int n, int[] dp) {
    if(dp[n]!=-1){
      return dp[n];
    }
    return dp[n] = climb(n-1,dp) + climb(n-2,dp);
  }

}
