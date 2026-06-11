class Solution {
    static boolean ans;

    public void bfs(int i, int[] vis, List<List<Integer>> dislikes) {
        Queue<Integer> q = new LinkedList<>();

        vis[i] = 0;
        q.add(i);

        while (q.size() > 0) {
            int front = q.remove();
            int color = vis[front];

            for (int ele : dislikes.get(front)) {

                if (vis[ele] == vis[front]) {
                    ans = false;
                    return;
                }

                if (vis[ele] == -1) {
                    vis[ele] = 1 - color;
                    q.add(ele);
                }
            }
        }
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {

        ans = true;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] d : dislikes) {
            int u = d[0];
            int v = d[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n + 1];
        Arrays.fill(vis, -1);

        for (int i = 1; i <= n; i++) {
            if (ans == false) return ans;

            if (vis[i] == -1) {
                bfs(i, vis, adj);   
            }
        }

        return ans;
    }
}