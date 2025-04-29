// Gracie Driggers CSCE 350
import java.io.*;
import java.util.*;
import java.time.*;

public class Main6 {
    // Reads input from input.txt and outputs output.txt
    public static void main(String[] args) {
        List<String> V = new ArrayList<>();
        List<String> U = new ArrayList<>();
        Map<String, List<String>> adj = new HashMap<>();

        if (!readInput("problem6/input.txt", V, U, adj)) {
            System.out.println("Error reading input file.");
            return;
        }

        Map<String, String> match = null;
        long executionTime = 0;

        // Finds execution time
        Instant start = Instant.now();
        match = MaximumBipartiteMatching.MaximumMatching(V, U, adj);
        Instant end = Instant.now();
        executionTime = Duration.between(start, end).toNanos();

        // Writes to output.txt
        try (PrintWriter writer = new PrintWriter(new FileWriter("problem6/output.txt"))) {
            writer.println("Maximum Bipartite Matching Output:");
            Set<String> printed = new HashSet<>();
            for (String v : V) {
                if (match.containsKey(v) && !printed.contains(v)) {
                    String u = match.get(v);
                    writer.println(v + " " + u);
                    printed.add(v);
                    printed.add(u);
                }
            }
            writer.println("Execution time (nanoseconds): " + executionTime);
        } catch (IOException e) {
            System.out.println("Error writing output file.");
        }
    }

    // Reads the input
    private static boolean readInput(String filename, List<String> V, List<String> U, Map<String, List<String>> adj) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            if (!scanner.hasNextLine()) return false;
            V.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));

            if (!scanner.hasNextLine()) return false;
            U.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));

            for (String v : V) adj.put(v, new ArrayList<>());
            for (String u : U) adj.put(u, new ArrayList<>());

            for (int i = 0; i < V.size(); i++) {
                String[] row = scanner.nextLine().split("\\s+");
                for (int j = 0; j < U.size(); j++) {
                    if (row[j].equals("1")) {
                        adj.get(V.get(i)).add(U.get(j));
                        adj.get(U.get(j)).add(V.get(i));
                    }
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}

