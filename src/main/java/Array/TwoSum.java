package Array;

import java.util.HashMap;

/**
 * LeetCode 1. Two Sum
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //HashMap: key is value, value is index
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if(map.containsKey(tmp)) {
                result[1] = map.get(tmp);
                result[0] = i;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
