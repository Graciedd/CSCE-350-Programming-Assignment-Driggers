// MaximumBipartiteMatchingMain.java
import java.io.*;
import java.time.*;
import java.util.*;

public class Main6 {

    public static void main(String[] args) {
        List<String> V = new ArrayList<>();
        List<String> U = new ArrayList<>();
        Map<String, List<String>> adj = new HashMap<>();

        if (!readInput("input.txt", V, U, adj)) {
            System.out.println("Error reading input file.");
            return;
        }

        Instant start = Instant.now();
        Map<String, String> match = MaximumBipartiteMatching.MaximumMatching(V, U, adj);
        Instant end = Instant.now();

        writeOutput(match, V, "output.txt");

        System.out.println("Maximum Bipartite Matching execution time (nanoseconds): " + Duration.between(start, end).toNanos());
    }

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

    private static void writeOutput(Map<String, String> match, List<String> V, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            Set<String> printed = new HashSet<>();
            for (String v : V) {
                if (match.containsKey(v) && !printed.contains(v)) {
                    String u = match.get(v);
                    writer.println(v + " " + u);
                    printed.add(v);
                    printed.add(u);
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing output file.");
        }
    }
}
