class Solution {
    private void bfs(int start, List<List<Integer>> adj , boolean visited[], int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int front = q.remove();
            for (int i : adj.get(front)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    if(i==end) return;
                }
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start == end) return true;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        for(int i= 0; i<edges.length;i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] visited = new boolean[n];
        visited[start] = true;
        bfs(start, adj, visited, end);
        return visited[end];

    }
}