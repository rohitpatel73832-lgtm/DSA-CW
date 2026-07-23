class Solution {

    class Pair {
        int v;
        int d;

        Pair(int v, int d) {
            this.v = v;
            this.d = d;
        }
    }

    public int minScore(int n, int[][] roads) {

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int d = road[2];

            graph.get(u).add(new Pair(v, d));
            graph.get(v).add(new Pair(u, d));
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];

        q.add(1);
        vis[1] = true;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (Pair ele : graph.get(curr)) {

                int next = ele.v;
                int dist = ele.d;

                ans = Math.min(ans, dist);

                if (!vis[next]) {
                    vis[next] = true;
                    q.add(next);
                }
            }
        }

        return ans;
    }
}