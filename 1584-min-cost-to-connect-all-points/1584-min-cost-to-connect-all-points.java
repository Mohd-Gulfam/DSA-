class Solution {
public  class Triplet implements Comparable<Triplet>{
    int node;
    int parent;
    int cost;
    public Triplet(int node, int parent, int cost){
        this.node = node;
        this.parent = parent;
        this.cost = cost;
    }
    public int compareTo(Triplet t){
    if(this.cost == t.cost) return  Integer.compare(this.node , t.node);
    return Integer.compare(this.cost ,t.cost);
}

}


    public int minCostConnectPoints(int[][] points) {
    int n =  points.length;
    PriorityQueue<Triplet> pq = new PriorityQueue<Triplet>();
    boolean[] vis =  new boolean[n];
    int sum = 0;
    pq.add(new Triplet(0, -1,0));
    while(!pq.isEmpty()){
        Triplet top = pq.poll();
        int node = top.node ,parent = top.parent, cost = top.cost;
        
        if(vis[node] == true) continue;
        vis[node] = true;
        sum += cost;
        for(int i = 0; i < n; i++){
            if( i == node || i == parent) continue;
            if(vis[i] == true)  continue;
            int x1 = points[node][0],y1 = points[node][1];
            int x2 = points[i][0],y2 = points[i][1];
            int mDis =  Math.abs(x2 - x1) +Math.abs(y2 - y1);
            pq.add(new Triplet(i, node ,mDis));
          
        }
    }
    return sum;
    }
}