class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] ans = new int[n];

        for (int garden = 1; garden <= n; garden++) {

            boolean[] vis = new boolean[5];

            // Mark flowers used by neighbors
            for (int nei : adj.get(garden)) {
                int flower = ans[nei - 1];

                if (flower != 0) {
                    vis[flower] = true;
                }
            }

            // Assign first available flower
            for (int flower = 1; flower <= 4; flower++) {
                if (!vis[flower]) {
                    ans[garden - 1] = flower;
                    break;
                }
            }
        }

        return ans;
    }
}