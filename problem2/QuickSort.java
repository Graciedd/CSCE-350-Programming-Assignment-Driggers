// Gracie Driggers CSCE350
package problem2;
import java.io.*;
import java.util.*;
import java.time.*;

public class QuickSort {
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
                return j; // Return split position
            }
        }

    }

    public static void Quicksort(float[] A, int l, int r) {
        if (l < r) {
            int s = HoarePartition(A, l, r);
            Quicksort(A, l, s - 1);
            Quicksort(A, s + 1, r);
        }
    }
}