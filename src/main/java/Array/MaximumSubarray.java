package Array;

/**
 * LeetCode 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Follow up: If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */

// 1. DP        O(n) time and O(n) space
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}


/**
 * 2. Simplified DP     O(n) time and O(1) space
 * public class MaximumSubarray {
 *     public int maxSubArray(int[] nums) {
 *      int res = Integer.MIN_VALUE, sum = 0;
 *      for (int i = 0; i < nums.length; i++) {
 *         sum = Math.max(sum, 0) + nums[i];
 *         res = Math.max(res, sum);
 *     }
 *     return res;
 *     }
 * }
 */
