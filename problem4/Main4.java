// Gracie Driggers CSCE350
import java.io.*;
import java.util.*;
import java.time.*;

// Performs Horspool and writes it to output.txt
public class Main4 {

    public static void main(String[] args) {
        String pattern = "";
        String text = "";

        // Reads input from the input.txt file
        try (Scanner scanner = new Scanner(new File("problem4/input.txt"))) {
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

        int matchIndex = -1;
        long executionTime = 0;

        //  Starts the Horspool matching and counts execution time
        Instant start = Instant.now();
        matchIndex = Horspool.HorspoolMatching(pattern, text);
        Instant end = Instant.now();
        executionTime = Duration.between(start, end).toNanos();

        // Writes to output.txt
        try (PrintWriter writer = new PrintWriter(new FileWriter("problem4/output.txt"))) {
            writer.println("Horspool's Algorithm Output: ");
            writer.println("Match index: " + matchIndex);
            writer.println("Execution time (nanoseconds): " + executionTime);
        } catch (IOException e) {
            System.out.println("Error writing output file.");
        }
    }
}


