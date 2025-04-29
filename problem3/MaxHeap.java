// Gracie Driggers CSCE350

// Builds maxheap from unsorted array using bottom up 
public class MaxHeap {

    /**
     * Builds a max heap using HeapBottomUp.
     *
     * @param H the array representing the heap (indexing starts at 1)
     * @param n the number of elements in the heap
     */
    public static void HeapBottomUp(int[] H, int n) {
        for (int i = n / 2; i >= 1; i--) {
            int k = i;
            int v = H[k];
            boolean heap = false;

            while(!heap && 2 * k <= n) {
                int j = 2 * k;
                if (j < n) {
                    if (H[j] < H[j + 1]) {
                        j = j + 1;
                    }
                }
                if (v >= H[j]) {
                    heap = true;
                } else {
                    H[k] = H[j];
                    k = j;
                }
            }
            H[k] = v;
        }
    }
}

