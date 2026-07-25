class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public boolean bfs(int i, int j, int[][] grid1, int[][] grid2, boolean[][] vis) {

        int m = grid1.length;
        int n = grid1[0].length;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(i, j));
        vis[i][j] = true;

        boolean isSubIsland = true;

        while (!q.isEmpty()) {

            Pair front = q.remove();

            int row = front.row;
            int col = front.col;

            if (grid1[row][col] == 0) {
                isSubIsland = false;
            }

            // Up
            if (row > 0 && !vis[row - 1][col] && grid2[row - 1][col] == 1) {
                vis[row - 1][col] = true;
                q.add(new Pair(row - 1, col));
            }

            // Down
            if (row + 1 < m && !vis[row + 1][col] && grid2[row + 1][col] == 1) {
                vis[row + 1][col] = true;
                q.add(new Pair(row + 1, col));
            }

            // Left
            if (col > 0 && !vis[row][col - 1] && grid2[row][col - 1] == 1) {
                vis[row][col - 1] = true;
                q.add(new Pair(row, col - 1));
            }

            // Right
            if (col + 1 < n && !vis[row][col + 1] && grid2[row][col + 1] == 1) {
                vis[row][col + 1] = true;
                q.add(new Pair(row, col + 1));
            }
        }

        return isSubIsland;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int m = grid1.length;
        int n = grid1[0].length;

        boolean[][] vis = new boolean[m][n];

        int count = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid2[i][j] == 1 && !vis[i][j]) {

                    if (bfs(i, j, grid1, grid2, vis)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}