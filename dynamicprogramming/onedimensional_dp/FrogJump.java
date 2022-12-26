package dynamicprogramming.onedimensional_dp;

import java.util.Arrays;

public class FrogJump {

  public static void main(String args[]) {
    
    int n = 4;
    System.out.println("Input: "+n);
    int[] heights = {10, 20, 30, 10};
    System.out.println(Arrays.toString(heights));

    // find minimum total energy required to reach from 0th step to n-1th step
    // frog can jump one step or two steps at a time
    // energy requiredt to jump between 2 steps is given difference of respective elements in heights array
    System.out.println("Output: ");
    System.out.println(frogJump(n, heights));
  }
  

  public static int frogJump(int n, int heights[]) {

    // Greedy algorithm doesn't work here, we need to check all possible scenarios using recursion
    int[] dp = new int[n];
    for(int i=0;i<n;i++) {
        dp[i]=-1;
    }
    
    return jump(n,heights, 0, dp);
}

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
