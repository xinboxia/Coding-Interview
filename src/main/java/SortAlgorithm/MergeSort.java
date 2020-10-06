package SortAlgorithm;

/*
MergeSort(arr[], l,  r)
        If r > l
        1. Find the middle point to divide the array into two halves:
        middle m = (l+r)/2
        2. Call mergeSort for first half:
        Call mergeSort(arr, l, m)
        3. Call mergeSort for second half:
        Call mergeSort(arr, m+1, r)
        4. Merge the two halves sorted in step 2 and 3:
        Call merge(arr, l, m, r)
 */

//  Recursively split arrays into two halves
//  then recursively merge two halves until all parts are merged into one array
public class MergeSort {
    public void MergeSort(int arr[], int l, int r) {
        if(l < r) {
            int m = (l+r)/2;    //  middle point
            //  Sort first and second halves
            MergeSort(arr, l, m);
            MergeSort(arr, m+1, r);
            //  Merge sorted halves
            Merge(arr, l, m, r);
        }
    }

    private void Merge(int arr[], int l, int m, int r) {
        //  find size of two sub arrays
        int n1 = m - l + 1;
        int n2 = r - m;
        //create two tmp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
        //Copy data to tmp arrays
        for(int i = 0; i < n1; i++) {
            L[i] = arr[i+l];
        }
        for(int j = 0; j < n2; j++) {
            R[j] = arr[m+1+j];
        }
        //Merge two tmp arrays
        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        //Copy remaining elements if any
        while(i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
