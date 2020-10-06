package codinginterview;

import SortAlgorithm.HeapSort;
import SortAlgorithm.MergeSort;
import SortAlgorithm.QuickSort;
import SortAlgorithm.TreeSort;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterviewApplication {

    public static void main(String[] args) {

        int arr[] = {12, 11, 13, 5, 6, 7, 3, 16};
        int n = arr.length;

        TreeSort tree = new TreeSort();
        TreeSort.buildBST(arr);
        TreeSort.inorderRec(tree.root);

        /*System.out.println("Sorted array is");
        printArray(arr);*/

    }

    private static void printArray(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

}
