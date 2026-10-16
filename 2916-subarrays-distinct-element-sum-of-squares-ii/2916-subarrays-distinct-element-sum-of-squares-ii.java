class Solution {
    static final int MOD = 1_000_000_007;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        long[] sum = new long[4 * n];
        long[] sq = new long[4 * n];
        long[] lazy = new long[4 * n];

        java.util.HashMap<Integer, Integer> last = new java.util.HashMap<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int prev = last.getOrDefault(x, -1);

            update(1, 0, n - 1, prev + 1, i, sum, sq, lazy);

            ans = (ans + sq[1]) % MOD;
            last.put(x, i);
        }

        return (int) ans;
    }

    private void update(int node, int start, int end,
                        int l, int r, long[] sum,
                        long[] sq, long[] lazy) {
        if (l > end || r < start) return;

        if (l <= start && end <= r) {
            long len = end - start + 1L;
            sq[node] = (sq[node] + 2 * sum[node] + len) % MOD;
            sum[node] = (sum[node] + len) % MOD;
            lazy[node]++;
            return;
        }

        push(node, start, end, sum, sq, lazy);

        int mid = start + (end - start) / 2;

        update(node * 2, start, mid, l, r, sum, sq, lazy);
        update(node * 2 + 1, mid + 1, end, l, r, sum, sq, lazy);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }

    private void push(int node, int start, int end,
                      long[] sum, long[] sq, long[] lazy) {
        if (lazy[node] == 0 || start == end) return;

        int mid = start + (end - start) / 2;
        long val = lazy[node];

        apply(node * 2, start, mid, val, sum, sq, lazy);
        apply(node * 2 + 1, mid + 1, end, val, sum, sq, lazy);

        lazy[node] = 0;
    }

    private void apply(int node, int start, int end, long val,
                       long[] sum, long[] sq, long[] lazy) {
        long len = end - start + 1L;

        sq[node] = (sq[node] + 2 * val % MOD * sum[node]
                    + len * val % MOD * val) % MOD;

        sum[node] = (sum[node] + len * val) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }
}