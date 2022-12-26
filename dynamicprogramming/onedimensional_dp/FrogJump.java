package dynamicprogramming.onedimensional_dp;

import java.util.Arrays;

public class FrogJump {

  public static void main(String args[]) {
    
    int n = 4;
    System.out.println("Input: "+n);
    int[] heights = {10, 20, 30, 10};
    System.out.println(Arrays.toString(heights));
    int k = 2;
    System.out.println("k: "+k);

    // find minimum total energy required to reach from 0th step to n-1th step
    // frog can jump one step or two steps at a time
    // energy requiredt to jump between 2 steps is given difference of respective elements in heights array
    System.out.println("Output: ");
    System.out.println(frogJump(n, heights,k));
  }
  

    public static int frogJump(int n, int heights[], int k) {
        // return jumpSpaceOptimization(n, heights);
        // Greedy algorithm doesn't work here, we need to check all possible scenarios using recursion
        int[] dp = new int[n];
        for(int i=0;i<n;i++) {
            dp[i]=-1;
        }
        // return jump(n,heights, 0, dp);
        // return jumpTabulation(n, heights, n, dp);
        return jumpTabulationWithKDistance(n, heights, n, dp, k);
    }

    // tabulation for k distance
    public static int jumpTabulationWithKDistance(int n, int[] heights,int current, int[] dp, int k) {
        dp[0] = 0;
        for(current=1;current<n;current++) {
            int min = Integer.MAX_VALUE;
            for(int j=1; j<=k;j++) {
                if(current-j>=0) {
                    int val = dp[current-j] + Math.abs(heights[current]-heights[current-j]);
                    min = Math.min(min, val);
                }
            }
            dp[current] = min;
        }
        return dp[n-1];
    }

    // space optimization
    public static int jumpSpaceOptimization(int n, int[] heights) {
        int prev2 = Integer.MAX_VALUE;
        int prev1 = 0;
        int current = Integer.MAX_VALUE;
        for(int ind=1;ind<n;ind++) {
            int left = prev1 + Math.abs(heights[ind]-heights[ind-1]);
            int right = Integer.MAX_VALUE;
            if(ind>1) {
                right = prev2 + Math.abs(heights[ind]-heights[ind-2]);
            }
            current = Math.min(left, right);
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }

    // tabulation
    public static int jumpTabulation(int n, int[] heights,int current, int[] dp) {
        dp[0] = 0;
        for(current=1;current<n;current++) {
            int left = dp[current-1] + Math.abs(heights[current]-heights[current-1]);
            int right = Integer.MAX_VALUE;
            if(current>1) {
                right = dp[current-2] + Math.abs(heights[current]-heights[current-2]);
            }
            dp[current] = Math.min(left, right);
        }
        return dp[n-1];
    }

    // memoization
    public static int jump(int n, int[] heights,int ind, int[] dp) {
        if(ind==n-1) {
            return 0;
        }
        if(dp[ind]==-1) {
            int energy = Math.abs(heights[ind]-heights[ind+1]) + jump(n,heights, ind+1, dp);
            if(ind+2<=n-1) {
                int temp = Math.abs(heights[ind]-heights[ind+2]) + jump(n,heights, ind+2, dp);
                if(temp<energy) {
                    energy = temp;
                }
            }
            dp[ind] = energy;
        }
        
        return dp[ind];
    }

}
