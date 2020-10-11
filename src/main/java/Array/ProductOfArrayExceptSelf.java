package Array;

import java.util.Arrays;

/**
 * LeetCode 238. Product of Array Except Self
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int left = 1, right = 1;
        Arrays.fill(result, 1);
        for(int i = 0; i < nums.length; i++) {
            result[i] *= left;
            left *= nums[i];
        }
        for(int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}
