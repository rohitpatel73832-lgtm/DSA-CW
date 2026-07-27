import java.util.*;

class Solution {

    class Pair {
        int node;
        long dist;

        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int countPaths(int n, int[][] roads) {

        int MOD = 1_000_000_007;

        // Adjacency List
        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            graph.get(u).add(new Pair(v, wt));
            graph.get(v).add(new Pair(u, wt));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        long[] ways = new long[n];

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            long d = curr.dist;

            // Ignore outdated entries
            if (d > dist[node]) {
                continue;
            }

            for (Pair neigh : graph.get(node)) {

                int adj = neigh.node;
                long newDist = d + neigh.dist;

                // Found a shorter path
                if (newDist < dist[adj]) {
                    dist[adj] = newDist;
                    ways[adj] = ways[node];
                    pq.offer(new Pair(adj, newDist));
                }

                // Found another shortest path
                else if (newDist == dist[adj]) {
                    ways[adj] = (ways[adj] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}