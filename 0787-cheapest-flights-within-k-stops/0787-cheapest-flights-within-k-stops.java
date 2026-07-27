class Solution {
    class Triplet {
    int src;
    int cost;
    int stop;

    Triplet(int src, int cost, int stop) {
        this.src = src;
        this.cost = cost;
        this.stop = stop;
    }
}

public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

    List<List<Triplet>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++)
        adj.add(new ArrayList<>());

    for (int i = 0; i < flights.length; i++) {
        int from = flights[i][0];
        int to = flights[i][1];
        int price = flights[i][2];

        adj.get(from).add(new Triplet(to, price, 0));
    }

    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    Queue<Triplet> q = new LinkedList<>();
    q.offer(new Triplet(src, 0, 0));

    while (!q.isEmpty()) {

        Triplet cur = q.poll();

        int node = cur.src;
        int cost = cur.cost;
        int stops = cur.stop;

        if (stops > k)
            continue;

        for (Triplet next : adj.get(node)) {

            int newCost = cost + next.cost;

            if (newCost < dist[next.src]) {

                dist[next.src] = newCost;

                q.offer(new Triplet(next.src, newCost, stops + 1));
            }
        }
    }

    return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
}
}