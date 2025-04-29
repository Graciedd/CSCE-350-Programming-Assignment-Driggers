// Gracie Driggers CSCE350
package problem2;
import java.util.*;

public class MergeSort{

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

public static void Mergesort(float[] A){
    int n = A.length;
    if (n <= 1) {
        return; // BASE CASE: don't recurse on arrays of size 1
    }
      int mid = n/2;
    float[] B = Arrays.copyOfRange(A, 0, mid);
    float[] C = Arrays.copyOfRange(A, mid, n);
    Mergesort(B);
    Mergesort(C);
    merge(B,C,A);
}
}