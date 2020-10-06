package SortAlgorithm;

//  Repeatedly swapping the adjacent elements if they are in wrong order
//  like bubbles go from left all the way to right(right most element is confirmed at each iteration)
//  so j can iterate one less element at each iteration
//  Best Time Complexity: O(n) when array is already sorted
//  Worst Time Complexity: O(n^2) when array is reverse sorted
//  Space Complexity: O(1)
//  How to improve?     Stop algorithm if inner loop has none swap

public class BubbleSort {
    public void BubbleSort(int arr[]) {
        boolean swapped;
        int len = arr.length;
        for(int i = 0; i < len - 1; i++) {
            //add a flag to determine if inner loop does swap
            swapped = false;
            for(int j = 0; j < len - i - i; j++) {
                //swap element if arr[j] > arr[j+1]
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swapped = true;
                }
            }
            if(swapped == false) {
                break;
            }
        }
    }
}
