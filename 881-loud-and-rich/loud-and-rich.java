class Solution {

    public int[] loudAndRich(int[][] richer, int[] quiet) {

        int n = quiet.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        // Richer -> Poorer
        for (int[] edge : richer) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = i;
        }

        while (!q.isEmpty()) {

            int u = q.remove();

            for (int v : adj.get(u)) {

                if (quiet[ans[u]] < quiet[ans[v]]) {
                    ans[v] = ans[u];
                }

                indegree[v]--;

                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        return ans;
    }
}