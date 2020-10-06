package Array;

/**
 * LeetCode 42: Trapping rain water
 */

/**
 * Use - two pointers - to traverse the whole array.
 * Always traverse from small value to large value so that we can guarantee to have water trapped
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int lo = 0, high = height.length - 1;
        int area = 0, level = 0;
        while(lo < high) {
            if(height[lo] > height[high]) {
                level = Math.max(height[high], level);
                area += Math.max(level - height[high], 0);
                high--;
            } else {
                level = Math.max(height[lo], level);
                area += Math.max(level - height[lo], 0);
                lo++;
            }
        }
        return area;
    }
}
