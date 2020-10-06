package SortAlgorithm;

/*
To sort an array of size n in ascending order:
        1: Iterate from arr[1] to arr[n] over the array.
        2: Compare the current element (key) to its predecessor.
        3: If the key element is smaller than its predecessor,
            compare it to the elements before.
            Move the greater elements one position up to make space for the swapped element.
 */
//  Time Complexity: O(n^2)
//  Space Complexity: O(1)  (in place swap)

public class InsertionSort {
    public void InsertionSort(int arr[]) {
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            int key = arr[i];
            int j = i - 1;

            //Keep traversing elements before index i until find right position for key value
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            //assign key value to correct position
            arr[j + 1] = key;
        }
    }
}
