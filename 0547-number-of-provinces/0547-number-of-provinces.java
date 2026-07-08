class Solution {
     public int findCircleNum(int[][] adj) {
        int n = adj.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i , visited , adj);
                count++;
            }
        }
        return count;

    }
    private void bfs(int i, boolean visited[], int[][] adj){
        int n = adj.length;
        visited[i] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while(!queue.isEmpty()){
            int front = queue.remove();
            for(int j=0; j<n; j++){
                if(adj[front][j] == 1 && visited[j] == false){
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }


    }
}