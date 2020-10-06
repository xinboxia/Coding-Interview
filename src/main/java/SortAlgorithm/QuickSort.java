package SortAlgorithm;

//  Divide and Conquer Algorithm
//  4 different ways to implement quicksort:
//  (1). Always pick first element as pivot
//  (2). Always pick last element as pivot
//  (3). pick a random element as pivot
//  (4). pick median element as pivot

// Time Complexity: O(nlogn)
// Space Complexity: O(1)       because it happens in place

//  If it is an array, quicksort better than mergesort because takes less space

//  If it is a linked list, mergesort is better because insertion in LinkedList takes O(1) time
//  while random access is costly, which is largely needed by quicksort


//  Here, I choose pick last element as pivot as an example
public class QuickSort {
    public void QuickSort(int arr[], int low, int high) {
        int len = arr.length;
        if(low < high) {
            int pi = partition(arr, low, high);
            QuickSort(arr, low, pi-1);
            QuickSort(arr, pi+1, high);
        }
    }

    //Put everything larger than pivot to right
    //and everything smaller than pivot to left
    //and return the right pivot position index
    private int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);      //index of smaller element, initially -1

        //swap everything smaller than pivot to the left of pivot
        for(int j = low; j < high; j++) {
            if((arr[j]) < pivot) {
                i++;
                //swap arr[i] with arr[j]
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        //swap arr[i+1] and arr[high] (or pivot)
        //so that pivot is now in the right place
        int tmp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = tmp;

        return i+1;
    }
}
