package problem2;
// package problem2;
import java.io.*;
import java.time.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        float[] arrMerge = readInput("problem2/input.txt");
        float[] arrQuick = arrMerge.clone(); // make a copy for QuickSort

        if (arrMerge == null) {
            System.out.println("Error reading input file.");
            return;
        }

        // Run MergeSort
        Instant startMerge = Instant.now();
        MergeSort.Mergesort(arrMerge);
        Instant endMerge = Instant.now();
        writeOutput(arrMerge, "problem2/output_mergesort.txt");
        System.out.println("MergeSort execution time (nanoseconds): " + Duration.between(startMerge, endMerge).toNanos());

        // Run QuickSort
        Instant startQuick = Instant.now();
        QuickSort.Quicksort(arrQuick, 0, arrQuick.length - 1);
        Instant endQuick = Instant.now();
        writeOutput(arrQuick, "problem2/output_quicksort.txt");
        System.out.println("QuickSort execution time (nanoseconds): " + Duration.between(startQuick, endQuick).toNanos());
    }

    private static float[] readInput(String filename) {
        List<Float> numbers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextFloat()) {
                numbers.add(scanner.nextFloat());
            }
        } catch (IOException e) {
            return null;
        }
        float[] arr = new float[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            arr[i] = numbers.get(i);
        }
        return arr;
    }

    private static void writeOutput(float[] arr, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (float num : arr) {
                writer.print(num + " ");
            }
        } catch (IOException e) {
            System.out.println("Error writing to " + filename);
        }
    }
}

