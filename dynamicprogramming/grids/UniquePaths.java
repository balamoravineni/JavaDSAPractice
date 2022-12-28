package dynamicprogramming.grids;

import java.util.Arrays;

public class UniquePaths {


  public static void main(String args[]) {
    // You are given a matrix of size m*n
		// return count of unique paths you can traverse from left-top of matrix to right-bottom
    //  with constraint that you can move only either right or down (from M[i][j] to M[i][j+1] or M[i+1][j])
		
		int m=2;
    int n=3;
		System.out.println("Input: ");
		System.out.println("m: "+m);
		System.out.println("n: "+n);


		System.out.println("Output: ");
		System.out.println(uniquePaths(m, n));
  }


	public static int uniquePaths(int m, int n) {
		// Write your code here.
        int[][] dp = new int[m][n];
        for(int[] arr: dp) {
            Arrays.fill(arr,-1);
        }
        // return count(m,n,0,0,dp);
        // return countTabulation(m,n,dp);
        return countSpaceOptimization(m,n);
	}

  public static int countSpaceOptimization(int m, int n) {
    int[] prev = new int[n]; //intital values:0
    for(int i=0;i<m;i++) {
        int temp[] = new int[n];
        for(int j=0;j<n;j++) {
            if(i!=0 || j!=0) {
                temp[j] = 0;
                if(j-1>=0) {
                    temp[j] += temp[j-1];
                }
                if(i-1>=0) {
                    temp[j] += prev[j];
                }
            }
            else {
                temp[j] = 1;
            }
        }
        for(int j=0;j<n;j++) {
            prev[j] = temp[j];
        }
    }
    return prev[n-1];
  }
    
  
  public static int countTabulation(int m, int n,int[][] dp) {
    dp[0][0]=1;
    for(int i=0;i<m;i++) {
        for(int j=0;j<n;j++) {
            if(i!=0 || j!=0) {
                dp[i][j] = 0;
                if(j-1>=0) {
                    dp[i][j] += dp[i][j-1];      
                }
                if(i-1>=0) {
                    dp[i][j] += dp[i-1][j];   
                }  
            }
        }
    }
    return dp[m-1][n-1];
  }
  
  public static int count(int m, int n, int i, int j,int[][] dp) {
    // Write your code here.
    if(i==m-1 && j==n-1) {
        return 1;
    }
    if(dp[i][j]!=-1) {
        return dp[i][j];
    }
    //go right
    int right = 0;
    if(j+1<n) {
        right = count(m,n,i,j+1,dp);
    }
    //go down
    int down = 0;
    if(i+1<m) {
        down = count(m,n,i+1,j,dp);
    }
    return dp[i][j] = down+right;
  }
}
