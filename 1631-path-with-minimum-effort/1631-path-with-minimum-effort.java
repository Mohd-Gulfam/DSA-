class Solution {
   static class Triplet implements Comparable<Triplet> {
        int row;
        int col;
        int effort;

        public Triplet(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }

        @Override
        public int compareTo(Triplet t) {
            return this.effort - t.effort;
        }
    }

    public int minimumEffortPath(int[][] arr) {

        int n = arr.length;
        int m = arr[0].length;

        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = Integer.MAX_VALUE;
            }
        }

        ans[0][0] = 0;

        PriorityQueue<Triplet> pq = new PriorityQueue<>();

        pq.add(new Triplet(0, 0, 0));

        while (!pq.isEmpty()) {

            Triplet top = pq.poll();

            int row = top.row;
            int col = top.col;
            int effort = top.effort;

            if (effort > ans[row][col])
                continue;

            if (row == n - 1 && col == m - 1)
                return effort;

            // Top
            if (row > 0) {
                int e = Math.abs(arr[row][col] - arr[row - 1][col]);
                e = Math.max(e, effort);

                if (e < ans[row - 1][col]) {
                    ans[row - 1][col] = e;
                    pq.add(new Triplet(row - 1, col, e));
                }
            }

            // Left
            if (col > 0) {
                int e = Math.abs(arr[row][col] - arr[row][col - 1]);
                e = Math.max(e, effort);

                if (e < ans[row][col - 1]) {
                    ans[row][col - 1] = e;
                    pq.add(new Triplet(row, col - 1, e));
                }
            }

            // Bottom
            if (row < n - 1) {
                int e = Math.abs(arr[row][col] - arr[row + 1][col]);
                e = Math.max(e, effort);

                if (e < ans[row + 1][col]) {
                    ans[row + 1][col] = e;
                    pq.add(new Triplet(row + 1, col, e));
                }
            }

            // Right
            if (col < m - 1) {
                int e = Math.abs(arr[row][col] - arr[row][col + 1]);
                e = Math.max(e, effort);

                if (e < ans[row][col + 1]) {
                    ans[row][col + 1] = e;
                    pq.add(new Triplet(row, col + 1, e));
                }
            }
        }

        return ans[n - 1][m - 1];
    }
}