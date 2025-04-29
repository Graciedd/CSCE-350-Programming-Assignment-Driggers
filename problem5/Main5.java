// Gracie Driggers CSCE350
import java.io.*;
import java.util.*;
import java.time.*;

public class Main5 {
// Reads input from file
    public static void main(String[] args) {
        float[][] D = readInput("problem5/input.txt");
        if (D == null) {
            System.out.println("Error reading input file.");
            return;
        }

        // Runs Floyd's Algorithm and then finds time
        Instant start = Instant.now();
        FloydsAlgorithm.floyd(D);
        Instant end = Instant.now();
        long executionTime = Duration.between(start, end).toNanos();

        // Write output
        try (PrintWriter writer = new PrintWriter(new FileWriter("problem5/output.txt"))) {
            writer.println("Floyd's Algorithm Output: ");
            for (int i = 0; i < D.length; i++) {
                for (int j = 0; j < D.length; j++) {
                    writer.print(D[i][j] + " ");
                }
                writer.println();
            }
            writer.println("Execution time (nanoseconds): " + executionTime);
        } catch (IOException e) {
            System.out.println("Error writing output file.");
        }
    }

    // Writes the output
    private static float[][] readInput(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            List<List<Float>> temp = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().trim().split("\\s+");
                if (tokens.length == 0) continue;
                List<Float> row = new ArrayList<>();
                for (String token : tokens) {
                    row.add(Float.parseFloat(token));
                }
                temp.add(row);
            }

            int n = temp.size();
            float[][] D = new float[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    D[i][j] = temp.get(i).get(j);
                }
            }
            return D;
        } catch (IOException e) {
            return null;
        }
    }
}


