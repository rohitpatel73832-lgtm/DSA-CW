class Solution {

    public class Pair {
        int row;
        int col;
        int dist;

        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
            return -1;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        q.add(new Pair(0, 0, 1));
        vis[0][0] = true;

        while (!q.isEmpty()) {

            Pair top = q.remove();

            int r = top.row;
            int c = top.col;
            int d = top.dist;

            if (r == m - 1 && c == n - 1)
                return d;

            // Up
            if (r > 0 && grid[r - 1][c] == 0 && !vis[r - 1][c]) {
                vis[r - 1][c] = true;
                q.add(new Pair(r - 1, c, d + 1));
            }

            // Down
            if (r + 1 < m && grid[r + 1][c] == 0 && !vis[r + 1][c]) {
                vis[r + 1][c] = true;
                q.add(new Pair(r + 1, c, d + 1));
            }

            // Left
            if (c > 0 && grid[r][c - 1] == 0 && !vis[r][c - 1]) {
                vis[r][c - 1] = true;
                q.add(new Pair(r, c - 1, d + 1));
            }

            // Right
            if (c + 1 < n && grid[r][c + 1] == 0 && !vis[r][c + 1]) {
                vis[r][c + 1] = true;
                q.add(new Pair(r, c + 1, d + 1));
            }

            // Upper Left
            if (r > 0 && c > 0 && grid[r - 1][c - 1] == 0 && !vis[r - 1][c - 1]) {
                vis[r - 1][c - 1] = true;
                q.add(new Pair(r - 1, c - 1, d + 1));
            }

            // Upper Right
            if (r > 0 && c + 1 < n && grid[r - 1][c + 1] == 0 && !vis[r - 1][c + 1]) {
                vis[r - 1][c + 1] = true;
                q.add(new Pair(r - 1, c + 1, d + 1));
            }

            // Lower Left
            if (r + 1 < m && c > 0 && grid[r + 1][c - 1] == 0 && !vis[r + 1][c - 1]) {
                vis[r + 1][c - 1] = true;
                q.add(new Pair(r + 1, c - 1, d + 1));
            }

            // Lower Right
            if (r + 1 < m && c + 1 < n && grid[r + 1][c + 1] == 0 && !vis[r + 1][c + 1]) {
                vis[r + 1][c + 1] = true;
                q.add(new Pair(r + 1, c + 1, d + 1));
            }
        }

        return -1;
    }
}