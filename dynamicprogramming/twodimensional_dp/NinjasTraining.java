package dynamicprogramming.twodimensional_dp;

import java.util.Arrays;

public class NinjasTraining {

  public static void main(String args[]) {
    // You are given array of n integers corresponding to n house ARRANGED IN A CIRCLE.
		// return max value a robber can rob from the houses with constraint that if a robber robs any two adjacent houses, alarm will raise.
		
		int n = 3;
		System.out.println("Input: " + n);
		int[][] points = {{10, 40, 70},
                    {20, 50, 80},
                    {30, 60, 90}};
    for(int i=0;i<3;i++) {
      System.out.println(Arrays.toString(points[i]));
    }
		System.out.println("Output: ");
		System.out.println(ninjaTraining(n, points));
  }

  public static int ninjaTraining(int n, int points[][]) {
      // Write your code here..
      int[][] dp = new int[n][4];
      for(int i=0;i<n;i++) {
          for(int j=0;j<4;j++) {
              dp[i][j]=-1;
          }
      }
      return trainSpaceOptimization(n,points);
      // return trainTabulation(n, points,dp);
      // return train(n,points,n-1,0,dp);
  }
  
  public static int trainSpaceOptimization(int n, int[][] points) {
    int[] prev = new int[3];
    prev[0] = points[0][0];
    prev[1] = points[0][1];
    prev[2] = points[0][2];
    for(int ind=1; ind<n;ind++) {
      int[] temp = new int[3];
      for(int j=0;j<3;j++) {
          temp[j] = Integer.MIN_VALUE;
          for(int k=0;k<3;k++) {
              if(k!=j) {
                  temp[j] = Math.max(temp[j], prev[k]);
              }
          }
          temp[j] += points[ind][j];
      }
      prev[0] = temp[0];
      prev[1] = temp[1];
      prev[2] = temp[2];
    }
    return Math.max(prev[0], Math.max(prev[1], prev[2]));
  }
  
  public static int trainTabulation(int n, int[][] points,int[][] dp) {
      dp[0][1] = points[0][0];
      dp[0][2] = points[0][1];
      dp[0][3] = points[0][2];
      for(int ind=1; ind<n;ind++) {    
          for(int j=1;j<=3;j++) {
              dp[ind][j] = points[ind][j-1];
              int temp = 0;
              for(int k=1;k<=3;k++) {
                if(k!=j) {
                    temp = Math.max(temp, dp[ind-1][k]);
                }
            }
              dp[ind][j] += temp;
          }
      }
      return Math.max(dp[n-1][1], Math.max(dp[n-1][2], dp[n-1][3]));
  }
  
  public static int train(int n, int[][] points, int ind, int lastActivity,int[][] dp) {
    if(ind==0) {
      int maxMeritPoints = Integer.MIN_VALUE;
      for(int i=1;i<=3;i++) {
          if(lastActivity!=i) {
              maxMeritPoints = Math.max(maxMeritPoints, points[0][i-1]);
          }
      }
      return maxMeritPoints;
  }
      // pick any of the three activities
      if(dp[ind][lastActivity]==-1) {   
          int maxMeritPoints = Integer.MIN_VALUE;
          for(int i=1;i<=3;i++) {
              if(lastActivity!=i) {
                  int temp = points[ind][i-1] + train(n,points,ind-1,i,dp);
                  maxMeritPoints = Math.max(maxMeritPoints, temp);
              }
          }
          dp[ind][lastActivity] = maxMeritPoints;
      }
      return dp[ind][lastActivity];
  }

}
