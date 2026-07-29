import java.util.Arrays;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] dist = new int[n][n];

        // Initialize distance matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        // Fill given edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        // Floyd-Warshall Algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (dist[i][k] == Integer.MAX_VALUE ||
                        dist[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }

                    dist[i][j] = Math.min(dist[i][j],
                                          dist[i][k] + dist[k][j]);
                }
            }
        }

        int minCity = -1;
        int minCount = Integer.MAX_VALUE;

        // Count reachable cities
        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            // If tie, choose larger city index
            if (count <= minCount) {
                minCount = count;
                minCity = i;
            }
        }

        return minCity;
    }
}