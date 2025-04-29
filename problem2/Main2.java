// Gracie Driggers CSCE 350
import java.io.*;
import java.util.*;
import java.time.*;

public class Main2 {

    public static void main(String[] args) {
        // Loads the input.txt
        float[] arrMerge = readInput("problem2/input.txt");
        if (arrMerge == null) {
            System.out.println("Error reading input file.");
            return;
        }
        // Copies array for Quicksort
        float[] arrQuick = arrMerge.clone();

        try (PrintWriter writer = new PrintWriter(new FileWriter("problem2/output.txt"))) {

            // Starts tracking the time of algorithms and outputs
            Instant startMerge = Instant.now();
            MergeSort.Mergesort(arrMerge);
            Instant endMerge = Instant.now();
            long mergeTime = Duration.between(startMerge, endMerge).toNanos();

            writer.println("MergeSort Output:");
            for (float num : arrMerge) {
                writer.print(num + " ");
            }
            writer.println();
            writer.println("Execution time (nanoseconds): " + mergeTime);
            writer.println();

            Instant startQuick = Instant.now();
            QuickSort.Quicksort(arrQuick, 0, arrQuick.length - 1);
            Instant endQuick = Instant.now();
            long quickTime = Duration.between(startQuick, endQuick).toNanos();

            writer.println("QuickSort Output:");
            for (float num : arrQuick) {
                writer.print(num + " ");
            }
            writer.println();
            writer.println("Execution time (nanoseconds): " + quickTime);

        } catch (IOException e) {
            System.out.println("Error writing output file.");
        }
    }

    // Reads the input file
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
}


