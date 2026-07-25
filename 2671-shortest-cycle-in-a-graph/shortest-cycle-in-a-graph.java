class Solution {

    public int findShortestCycle(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int ans = Integer.MAX_VALUE;

        for (int src = 0; src < n; src++) {

            boolean[] vis = new boolean[n];
            int[] dist = new int[n];
            int[] parent = new int[n];

            Arrays.fill(parent, -1);

            Queue<Integer> q = new LinkedList<>();

            q.offer(src);
            vis[src] = true;
            dist[src] = 0;

            while (!q.isEmpty()) {

                int node = q.poll();

                for (int neigh : graph.get(node)) {

                    if (!vis[neigh]) {

                        vis[neigh] = true;
                        dist[neigh] = dist[node] + 1;
                        parent[neigh] = node;

                        q.offer(neigh);

                    } else if (parent[node] != neigh) {

                        ans = Math.min(ans,
                                dist[node] + dist[neigh] + 1);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}