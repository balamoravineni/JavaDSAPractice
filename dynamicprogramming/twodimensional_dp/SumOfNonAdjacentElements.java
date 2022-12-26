package dynamicprogramming.twodimensional_dp;

import java.util.ArrayList;
import java.util.List;

public class SumOfNonAdjacentElements {
	public static void main(String args[]) {
    
		// You are given array of n integers.
		// return max sum of subsequence with constraint that no two elements are adjacent in the given array
		
		int n = 4;
		System.out.println("Input: " + n);
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(2);
		nums.add(1);
		nums.add(4);
		nums.add(9);

		System.out.println(nums);
		System.out.println("Output: ");
		System.out.println(maximumNonAdjacentSum(nums));
	}
  
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int[][] dp = new int[nums.size()][2];
        for(int i=0;i<nums.size();i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
//         return maxSubSeq(nums, 0, 0, dp);
//         return maxSubSeqTabulation(nums, dp);
        return maxSubSeqSpaceOptimization(nums);
	}
    
    public static int maxSubSeqSpaceOptimization(List<Integer> nums) {
        int prevNotPicked = 0;
        int prevPicked = nums.get(0);
        int currentNotPicked = Integer.MIN_VALUE;
        int currentPicked = Integer.MIN_VALUE;
        for(int i=1;i<nums.size();i++) {
            // pick
            currentPicked = nums.get(i) + prevNotPicked;
            // not pick
            currentNotPicked = Math.max(prevNotPicked, prevPicked);
						// set prevPicked, prevNotPicked for next iteration
            prevNotPicked = currentNotPicked;
            prevPicked = currentPicked;
        }
        return Math.max(prevNotPicked, prevPicked);
    }
    
    public static int maxSubSeqTabulation(List<Integer> nums, int[][] dp) {
        dp[0][0] = 0;
        dp[0][1] = nums.get(0);
        for(int i=1;i<nums.size();i++) {
            // pick
            dp[i][1] = nums.get(i) + dp[i-1][0];
            // not pick
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);
        }
        return Math.max(dp[nums.size()-1][0], dp[nums.size()-1][1]);
    }
    
    public static int maxSubSeq(List<Integer> nums, int ind, int prevPicked, int[][] dp) {
        if(ind==nums.size()) {
            return 0;
        }
        if(dp[ind][prevPicked]==-1) {
            // pick
            int left = Integer.MIN_VALUE;
            if(prevPicked==0) {
                left = nums.get(ind) + maxSubSeq(nums, ind+1, 1, dp);
            }
            //not pick
            int right = maxSubSeq(nums, ind+1, 0, dp);
            dp[ind][prevPicked]= Math.max(left, right);
        }
        
        return dp[ind][prevPicked];
    }
}