package dynamicprogramming.grids;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UniquePaths2WithObstacles {

    static int mod = 1000000007;

    public static void main(String args[]) {
      // You are given a matrix of size m*n, 
      // return count of unique paths you can traverse from left-top of matrix to right-bottom
      //  with constraint that you can move only either right or down (from M[i][j] to M[i][j+1] or M[i+1][j])
      // and also have a constraint if M[i][j]==-1, then there is an obstacle
      // return the value % (10^9+7), since value may be very large
      
      int m=3;
      int n=3;
      System.out.println("Input: ");
      System.out.println("m: "+m);
      System.out.println("n: "+n);
      ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
      ArrayList<Integer> row1 = new ArrayList<>();
      ArrayList<Integer> row2 = new ArrayList<>();
      ArrayList<Integer> row3 = new ArrayList<>();
      Collections.addAll(row1, 0, 0, 0);
      Collections.addAll(row2, 0, -1, 0);
      Collections.addAll(row3, 0, 0, 0);
      Collections.addAll(mat, row1, row2, row3);
      System.out.println("matrix: "+ mat);
  
      System.out.println("Output: ");
      System.out.println(mazeObstacles(m, n, mat));
    }

    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        // Write your code here.
        if(mat.get(0).get(0)==-1 || mat.get(n-1).get(m-1)==-1) {
            return 0;
        }
        long[][] dp = new long[n][m];
        for(long[] temp:dp) {
            Arrays.fill(temp,-1);
        }
        // long ans = count(n,m,mat,0,0,dp);
        // long ans = countTabulation(n,m,mat,dp);
        long ans = countSpaceOptimization(n,m,mat);
        return (int)ans;
    }
    
    static long countSpaceOptimization(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        long[] prev = new long[m];
        for(int i=0;i<n;i++) {
            long[] temp = new long[m];
            for(int j=0;j<m;j++) {
                if(i!=0 || j!=0) {
                    long curr = 0;
                    if(i>0 && mat.get(i).get(j)!=-1) {
                        curr += prev[j];
                    }
                    if(j>0 && mat.get(i).get(j)!=-1) {
                        curr += temp[j-1];
                    }
                    temp[j] = curr%mod;
                }
                else {
                    temp[j]=1;
                }
            }
            for(int j=0;j<m;j++) {
                prev[j] = temp[j];
            }
        }
        return prev[m-1];
    }
    
    static long countTabulation(int n, int m, ArrayList<ArrayList<Integer>> mat, long[][] dp) {
        dp[0][0] = 1;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(i!=0 || j!=0) {
                    long curr = 0;
                    if(i>0 && mat.get(i).get(j)!=-1) {
                        curr += dp[i-1][j];
                    }
                    if(j>0 && mat.get(i).get(j)!=-1) {
                        curr += dp[i][j-1];
                    }
                    dp[i][j] = curr%mod;
                }
            }
        }
        return dp[n-1][m-1];
    }
    
    static long count(int n, int m, ArrayList<ArrayList<Integer>> mat, int i, int j, long[][] dp) {
        if(i==n-1 && j==m-1) {
            return 1;
        }
        if(dp[i][j]!=-1) {
            return dp[i][j];
        }
        long down = 0;
        long right =0;
        if(i+1<n && mat.get(i+1).get(j)==0) {
            down = count(n,m,mat,i+1,j,dp);
        }
        if(j+1<m && mat.get(i).get(j+1)==0) {
            right = count(n,m,mat,i,j+1,dp);
        }
        return dp[i][j] = (down+right)%mod;
    }

}

