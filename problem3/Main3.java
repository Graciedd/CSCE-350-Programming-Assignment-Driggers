// HeapMain.java
import java.io.*;
import java.util.*;
import java.time.*;

// Reads the array from the file, constructs Max and Min Heap and writes to an output file
public class Main3 {

    public static void main(String[] args) {
        // Reads from input.txt
        int[] arr = readInput("problem3/input.txt");
        if (arr == null) {
            System.out.println("Error reading input file.");
            return;
        }
        // Clones the array for MaxHeap and MinHeap
        int[] arrMax = arr.clone();
        int[] arrMin = arr.clone();

        try (PrintWriter writer = new PrintWriter(new FileWriter("problem3/output.txt"))) {

            // Prints MaxHeap and execution times
            Instant startMax = Instant.now();
            MaxHeap.HeapBottomUp(arrMax, arrMax.length - 1);
            Instant endMax = Instant.now();
            long maxTime = Duration.between(startMax, endMax).toNanos();

            writer.println("MaxHeap Output:");
            for (int i = 1; i < arrMax.length; i++) {
                writer.print(arrMax[i] + " ");
            }
            writer.println();
            writer.println("Execution time (nanoseconds): " + maxTime);
            writer.println();

            // Prints MinHeap and execution time
            Instant startMin = Instant.now();
            MinHeap.HeapBottomUp(arrMin, arrMin.length - 1);
            Instant endMin = Instant.now();
            long minTime = Duration.between(startMin, endMin).toNanos();

            writer.println("MinHeap Output:");
            for (int i = 1; i < arrMin.length; i++) {
                writer.print(arrMin[i] + " ");
            }
            writer.println();
            writer.println("Execution time (nanoseconds): " + minTime);

        } catch (IOException e) {
            System.out.println("Error writing output file.");
        }
    }
    // Reads the input from the files
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
}

