package SortAlgorithm;

//  Repeatedly select minimum element and put it at the beginning of the array
//  by exchange minimum element with first element
//  Time Complexity: O(n^2)
//  Space Complexity: O(1)
//  Useful when memory write is costly
public class SelectionSort {
    public void SelectionSort(int arr[]) {
        int len = arr.length;
        for(int i = 0; i < len - 1; i++) {

            //find index of minimum element
            int min_index = i;
            for(int j = i+1; j < len; j++) {
                if(arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }

            //swap minimum element with the first element
            int tmp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = tmp;
        }
    }
}
