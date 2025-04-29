package problem3;

import java.io.*;
import java.time.*;
import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        int[] arr = readInput("input.txt");
        if (arr == null) {
            System.out.println("Error reading input file.");
            return;
        }

        // MaxHeap
        int[] arrMax = arr.clone();
        Instant startMax = Instant.now();
        MaxHeap.HeapBottomUp(arrMax, arrMax.length - 1);
        Instant endMax = Instant.now();
        writeOutput(arrMax, "output_maxheap.txt");
        System.out.println("MaxHeap execution time (nanoseconds): " + Duration.between(startMax, endMax).toNanos());

        // MinHeap
        int[] arrMin = arr.clone();
        Instant startMin = Instant.now();
        MinHeap.HeapBottomUp(arrMin, arrMin.length - 1);
        Instant endMin = Instant.now();
        writeOutput(arrMin, "output_minheap.txt");
        System.out.println("MinHeap execution time (nanoseconds): " + Duration.between(startMin, endMin).toNanos());
    }

    private static int[] readInput(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            int n = scanner.nextInt();
            int[] arr = new int[n + 1]; // 1-based indexing
            for (int i = 1; i <= n; i++) {
                arr[i] = scanner.nextInt();
            }
            return arr;
        } catch (IOException e) {
            return null;
        }
    }

    private static void writeOutput(int[] arr, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int i = 1; i < arr.length; i++) {
                writer.print(arr[i] + " ");
            }
        } catch (IOException e) {
            System.out.println("Error writing to " + filename);
        }
    }
}
