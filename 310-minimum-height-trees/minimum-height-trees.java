import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> ans = new ArrayList<>();

        if (n == 1) {
            ans.add(0);
            return ans;
        }

        List<List<Integer>> adj = new ArrayList<>();
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // Put all leaves into queue
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }

        int remainingNodes = n;

        while (remainingNodes > 2) {

            int size = q.size();
            remainingNodes -= size;

            while (size-- > 0) {

                int leaf = q.poll();

                for (int nei : adj.get(leaf)) {

                    degree[nei]--;

                    if (degree[nei] == 1) {
                        q.offer(nei);
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            ans.add(q.poll());
        }

        return ans;
    }
}