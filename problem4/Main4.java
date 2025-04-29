// HorspoolMain.java
import java.io.*;
import java.time.*;
import java.util.*;

public class Main4 {

    public static void main(String[] args) {
        String pattern = "";
        String text = "";

        // Read input
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            if (scanner.hasNextLine()) {
                pattern = scanner.nextLine();
            }
            if (scanner.hasNextLine()) {
                text = scanner.nextLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading input file.");
            return;
        }

        if (pattern.isEmpty() || text.isEmpty()) {
            System.out.println("Invalid input.");
            return;
        }

        // Time the Horspool algorithm
        Instant start = Instant.now();
        int matchIndex = Horspool.HorspoolMatching(pattern, text);
        Instant end = Instant.now();

        // Write output
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {
            writer.println(matchIndex);
        } catch (IOException e) {
            System.out.println("Error writing output file.");
        }

        // Print execution time
        System.out.println("Horspool Matching execution time (nanoseconds): " + Duration.between(start, end).toNanos());
    }
}

