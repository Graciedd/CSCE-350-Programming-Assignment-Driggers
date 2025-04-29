// Gracie Driggers CSCE350

    /**
     * Floyd's Algorithm to compute the shortest paths between all pairs of verticeS
     * @param D a 2D float array where D[i][j] represents the weight of the edge from vertex i to j
     *  Elements of D should be set to a large value if there is no direct edge in place of infinity
     */
public class FloydsAlgorithm {
  public static void floyd(float[][] D) {
        int n = D.length;
        // K performs as a temp vertex
        for (int k = 0; k < n; k++) {
            // For each pair, update the shortest distance
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // If path through k is shorter than the current path, choose it.
                    if (D[i][k] + D[k][j] < D[i][j]) {
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }
    }
}



