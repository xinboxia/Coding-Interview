package Array;

/**
 * LeetCode #4: Median of Two Sorted Arrays  (hard)
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * Follow up: The overall run time complexity should be O(log (m+n)).
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        if(len % 2 == 0) {
            double left = (double)findKthNumber(nums1, 0, nums2, 0, len/2);
            double right = (double)findKthNumber(nums1, 0, nums2, 0, len/2 + 1);
            return (left+right)/2;
        } else {
            return findKthNumber(nums1, 0, nums2, 0, len/2+1);
        }
    }

    private int findKthNumber(int[] a, int aStart,int[] b, int bStart, int k) {
        if(aStart >= a.length) {
            return b[bStart + k - 1];
        }
        if(bStart >= b.length) {
            return a[aStart + k - 1];
        }
        if(k == 1) {
            return Math.min(a[aStart], b[bStart]);
        }
        int aMid = aStart + k/2 - 1;
        int bMid = bStart + k/2 - 1;
        int aVal = aMid >= a.length ? Integer.MAX_VALUE : a[aMid];
        int bVal = bMid >= b.length ? Integer.MAX_VALUE : b[bMid];
        if(aVal <= bVal) {
            return findKthNumber(a, aStart+1, b, bStart, k/2);
        } else {
            return findKthNumber(a, aStart, b, bStart+1, k/2);
        }
    }
}
