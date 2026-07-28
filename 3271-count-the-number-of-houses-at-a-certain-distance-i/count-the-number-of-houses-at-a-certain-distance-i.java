// class Solution {
//     public int[] countOfPairs(int n, int x, int y) {

//         List<List<Integer>> adj = new ArrayList<>();

//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         // Normal roads
//         for (int i = 1; i < n; i++) {
//             adj.get(i).add(i + 1);
//             adj.get(i + 1).add(i);
//         }

//         // Extra road
//         adj.get(x).add(y);
//         adj.get(y).add(x);

//         int[] ans = new int[n];

//         for (int start = 1; start <= n; start++) {

//             int[] dist = new int[n + 1];
//             Arrays.fill(dist, -1);

//             Queue<Integer> q = new LinkedList<>();

//             q.offer(start);
//             dist[start] = 0;

//             while (!q.isEmpty()) {

//                 int node = q.poll();

//                 for (int nbr : adj.get(node)) {

//                     if (dist[nbr] == -1) {
//                         dist[nbr] = dist[node] + 1;
//                         q.offer(nbr);
//                     }
//                 }
//             }

//             // Count distances
//             for (int end = 1; end <= n; end++) {

//                 if (start != end) {
//                     ans[dist[end] - 1]++;
//                 }
//             }
//         }

//         return ans;
//     }
// }
class Solution {
    public int[] countOfPairs(int n, int x, int y) {

        int INF = (int)1e9;
        int[][] dist = new int[n + 1][n + 1];

        // Initialize
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // Connect adjacent houses
        for (int i = 1; i < n; i++) {
            dist[i][i + 1] = 1;
            dist[i + 1][i] = 1;
        }

        // Extra edge
        dist[x][y] = 1;
        dist[y][x] = 1;

        // Floyd-Warshall
        for (int via = 1; via <= n; via++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j],
                                          dist[i][via] + dist[via][j]);
                }
            }
        }

        int[] ans = new int[n];

        // Count ordered pairs
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (i == j) continue;

                int d = dist[i][j];
                ans[d - 1]++;
            }
        }

        return ans;
    }
}