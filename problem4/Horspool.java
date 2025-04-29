
public class Horspool {

    // Construct the shift table
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

    // Horspool's Matching Algorithm
    public static int HorspoolMatching(String pattern, String text) {
        int[] table = shiftTable(pattern);
        int m = pattern.length();
        int n = text.length();
        int i = m - 1; // start from end of pattern

        while (i <= n - 1) {
            int k = 0;
            while (k <= m - 1 && pattern.charAt(m - 1 - k) == text.charAt(i - k)) {
                k++;
            }
            if (k == m) {
                return i - m + 1; // match found
            } else {
                i += table[text.charAt(i)];
            }
        }
        return -1; // no match
    }
}


