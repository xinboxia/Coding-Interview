package Array;

/**
 * LeetCode 31. Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 * The replacement must be in place and use only constant extra memory.
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //find the first index that breaks the descending order.
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        int j = nums.length - 1;
        if(i >= 0) {
            while(nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1, nums.length - 1);
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
    private void reverse(int[] nums, int i, int j) {
        while(i < j) swap(nums, i++, j--);
    }
}
