package SortAlgorithm;


import java.util.Arrays;

//  Use bianry search to reduce the number of comparisons in normal insertion sort.
//  Time Complexity: Still O(n^2) in worst case. But sort can be improved to O(logn) instead of O(n).

public class BinaryInsertionSort {
    public void BinaryInsertionSort(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            int x = arr[i];
            //index of correct position
            int j = Math.abs(Arrays.binarySearch(arr, 0, i, x) + 1);
            //shift array to one location right
            System.arraycopy(arr, j, arr, j+1, i-j);
            //Put x to right position
            arr[j] = x;
        }
    }
}
