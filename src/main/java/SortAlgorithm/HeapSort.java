package SortAlgorithm;

//  1. build Max-Heap
//  2. At this point, the largest item is stored at the root of the heap,
//     Replace it with the last item of the heap followed by reducing the size of heap by 1,
//     Rebuild Max-Heap with the new root of the tree.
//  3. Repeat step 2 while size of heap is greater than 1.
//  Time Complexity: O(nlogn)  Because O(heapify) = O(Logn) and O(Create and Build Heap) = O(n)
//  Space Complexity: ?

public class HeapSort {
    public void HeapSort(int arr[]) {
        int len = arr.length;

        //Build the heap (rearrange array)
        for(int i = len/2 - 1; i >= 0; i--) {
            heapify(arr, len, i);
        }

        //One by one extract an element from heap
        //Swap root with the last node
        for(int i = len - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            //Rebuild heap after delete last node
            heapify(arr, i, 0);
        }
    }

    //  len is size of heap and i is index of root node
    private void heapify(int arr[], int len, int i) {
        int largest = i;    //Initiate largest to be root
        int l = 2*i + 1;    //left child
        int r = 2*i + 2;    //right child

        //If left child is larger than root
        if(l < len && arr[l] > arr[largest]) {
            largest = l;
        }

        //If right child is larger than root
        if(r < len && arr[r] > arr[largest]) {
            largest = r;
        }

        //If largest is not root
        //swap largest with i until largest becomes root
        //Recursively heapify the subtree
        if(largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, len, largest);
        }
    }
}
