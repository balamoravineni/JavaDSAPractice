package leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int [] mergedArr = new int[nums1.length+nums2.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i]<nums2[j]) {
                mergedArr[k++] = nums1[i++];
            }
            else if(nums1[i]>nums2[j]) {
                mergedArr[k++] = nums2[j++];
            }
            else {
                mergedArr[k++] = nums1[i++];
                mergedArr[k++] = nums2[j++];
            }
        }
        while(i<nums1.length) {
            mergedArr[k++] = nums1[i++];   
        }
        while(j<nums2.length) {
            mergedArr[k++] = nums2[j++];   
        }
        System.out.println("Merged Array: "+ Arrays.toString(mergedArr));
        double median = 0.0;
        if(mergedArr.length%2==0) {
            median += (mergedArr[mergedArr.length/2 - 1] + mergedArr[mergedArr.length/2]);
            median /=2;
        }
        else {
            median += mergedArr[mergedArr.length/2];
        }
        return median;
    }
}
