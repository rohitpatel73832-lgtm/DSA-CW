class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> ans = new ArrayList<>();

        if (n == 1) {
            ans.add(0);
            return ans;
        }

        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            indegree[u]++;
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // Put all leaves into queue
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                q.add(i);
            }
        }

        int remaining = n;

        while (remaining > 2) {

            int size = q.size();
            remaining -= size;

            ans.clear();   // Keep only the last level

            for (int i = 0; i < size; i++) {

                int front = q.remove();
                ans.add(front);

                for (int ele : adj.get(front)) {
                    indegree[ele]--;

                    if (indegree[ele] == 1) {
                        q.add(ele);
                    }
                }
            }
        }

        ans.clear();

        while (!q.isEmpty()) {
            ans.add(q.remove());
        }

        return ans;
    }
}