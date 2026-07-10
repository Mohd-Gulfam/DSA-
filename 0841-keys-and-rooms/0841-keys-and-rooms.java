class Solution {
   public boolean canVisitAllRooms(List<List<Integer>>  adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        bfs(0, adj, visited);
        for (boolean ele : visited) {
            if (!ele) {
                return false;
            }

        }
        return true;
    }
    public void bfs(int start, List<List<Integer>> adj, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int front = queue.remove();
            for (int i : adj.get(front)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

}