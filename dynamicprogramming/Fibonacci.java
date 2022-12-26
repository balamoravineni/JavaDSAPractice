package dynamicprogramming;


public class Fibonacci {
  
  public static void main(String[] args) {
    
    int n = 15;
    System.out.println("Input: "+n);
    System.out.println("Output: ");
    int[] dp = new int[n+1];
    for(int i=0;i<=n;i++) {
      dp[i]=-1;
    }
    dp[0] = 0;
    dp[1] = 1;
    // System.out.println(fibonacci(n, dp));
    // System.out.println(fibonacciTabulation(n, dp));
    System.out.println(fibonacciSpaceOptimized(n));
  }

  // memoization or recursion
  public static int fibonacci(int n, int[] dp) {
    if(dp[n]!=-1) {
      return dp[n];
    }
    int sum = fibonacci(n-1, dp) + fibonacci(n-2, dp);
    dp[n] = sum;
    return sum;
  }

  // tabulation
  public static int fibonacciTabulation(int n, int[] dp) {
    for(int i=2;i<=n;i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
  }

  // tabulation
  public static int fibonacciSpaceOptimized(int n) {
    if(n<=1) {
      return n;
    }
    int prev2 = 0;
    int prev1 = 1;
    int current = prev1 + prev2;
    for(int i=3;i<=n;i++) {
      prev2 = prev1;
      prev1 = current;
      current = prev1 + prev2;
    }
    return current;
  }
}
