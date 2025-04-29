// Gracie Driggers CSCE350

import java.io.*;
import java.util.*;
import java.time.*;

// Performs QuickSort method on an array of floats
public class QuickSort {

    /**
     * Performs Hoare partitioning on the array.
     *
     * @param A the array to partition
     * @param l the left index of the subarray
     * @param r the right index of the subarray
     * @return the index where the pivot ends up after partitioning
     */
    private static int HoarePartition(float[] A, int l, int r){
        float p = A[l];
        int i = l;
        int j = r+1;

        while(true) {
            do {
                i++;
            } while (i <= r && A[i] < p);

            do {
                j--;
            } while (A[j] > p);

            if (i < j) {
                float temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            } else {
                float temp = A[l];
                A[l] = A[j];
                A[j] = temp;
                return j;
            }
        }

    }

      /**
     * Performs quicksort on an array of floats between indices l and r.
     *
     * @param A the array to sort
     * @param l the left index
     * @param r the right index
     */
    public static void Quicksort(float[] A, int l, int r) {
        if (l < r) {
            // Recursive calls so that the different 
            // parts of the array can be sorted
            int s = HoarePartition(A, l, r);
            Quicksort(A, l, s - 1);
            Quicksort(A, s + 1, r);
        }
    }
}