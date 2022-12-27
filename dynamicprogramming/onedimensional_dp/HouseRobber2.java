package dynamicprogramming.onedimensional_dp;

import java.util.Arrays;

public class HouseRobber2 {

  public static void main(String args[]) {
    // You are given array of n integers corresponding to n house ARRANGED IN A CIRCLE.
		// return max value a robber can rob from the houses 
    // with constraint that if a robber robs any two adjacent houses, alarm will raise.
		
		int n = 5;
		System.out.println("Input: " + n);
		int[] nums = {1, 5, 1, 2, 6};

		System.out.println(Arrays.toString(nums));
		System.out.println("Output: ");
		System.out.println(houseRobber(nums));
  }
  
  public static long houseRobber(int[] valueInHouse) {
    // this problem is similar to SumOfNonAdjacentElements except that last & first elements are now considered to be adjacent
    // so, our answer should not contain value containing both last& first elements
    // answer is the max ofSumOfNonAdjacentElements by omittingFirstElement, & by omittingLastElement
    if(valueInHouse.length==1) {
        return valueInHouse[0];
    }
    else if(valueInHouse.length==1) {
        return 0;
    }
    long omitFirstHouse = robSpaceOptimization(valueInHouse, 1, valueInHouse.length-1);
    long omitLastHouse = robSpaceOptimization(valueInHouse, 0, valueInHouse.length-2);
    return Math.max(omitFirstHouse, omitLastHouse);
	}	
    
  public static long robSpaceOptimization(int[] nums, int low, int high) {
    long prev2=0;
    long prev1=nums[low];
    for(int i=low+1;i<=high;i++) {
        // pick
        long left = nums[i]+prev2;
        //not pick
        long right = prev1;
        long current = Math.max(left, right);
        prev2 = prev1;
        prev1 = current;
    }
    return prev1;
  }
}
