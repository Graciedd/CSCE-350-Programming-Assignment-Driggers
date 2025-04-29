// Gracie Driggers CSCE350
import java.util.*;

 // MergeSort class: performs merge sort on an array of floats.
public class MergeSort{

// Merge method that merges two sorted array into single sorted array
private static void merge(float[] B, float[] C, float[] A){
    int i = 0; 
    int j = 0; 
    int k = 0;
    int bLength = B.length;
    int cLength = C.length;
    while (i < bLength && j < cLength) {
        if (B[i] <= C[j] ) {
            A[k++] = B[i++];
        } else {
            A[k++] = C[j++];
        }
    }

    while (i < bLength) {
        A[k++] = B[i++];
    }
    while (j < cLength) {
        A[k++] = C[j++];
    }
}

/**
     * Performs merge sort on an array of floats.
     * 
     * @param A the array to be sorted
     */
public static void Mergesort(float[] A){
    int n = A.length;
    if (n <= 1) {
        return; 
    }
    // splits array
      int mid = n/2;
    float[] B = Arrays.copyOfRange(A, 0, mid);
    float[] C = Arrays.copyOfRange(A, mid, n);

    //Recursive call to sort both of the halves and and then merge them
    Mergesort(B);
    Mergesort(C);
    merge(B,C,A);
}
}