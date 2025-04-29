// Gracie Driggers CSCE350
public class Horspool {

     /**
     * Constructs the shift table used in Horspool's algorithm.
     * 
     * @param pattern the pattern string to search for
     * @return an integer array representing the shift table
     */
    public static int[] shiftTable(String pattern) {
        int m = pattern.length();
        int[] table = new int[128]; // assuming ASCII characters

        for (int i = 0; i < 128; i++) {
            table[i] = m;
        }
        for (int j = 0; j < m - 1; j++) {
            table[pattern.charAt(j)] = m - 1 - j;
        }
        return table;
    }

    
    /**
     * Horspool's string matching algorithm.
     * Searches for the pattern in the string.
     * 
     * @param pattern to search for
     * @param string to search in
     * @return the starting index of the first match, or -1 if no match
     */
    public static int HorspoolMatching(String pattern, String text) {
        int[] table = shiftTable(pattern);
        int m = pattern.length();
        int n = text.length();
        int i = m - 1; // Start from rightmost part of the pattern

        //Keep searching while there is enough text left in the string
        while (i <= n - 1) {
            int k = 0;
            while (k <= m - 1 && pattern.charAt(m - 1 - k) == text.charAt(i - k)) {
                k++;
            }
            if (k == m) {
                return i - m + 1; // A match is found
            } else {
                i += table[text.charAt(i)];
            }
        }
        return -1; // No match is found
    }
}


