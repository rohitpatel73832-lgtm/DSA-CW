class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int bfs(int i, int j, int[][] grid, boolean[][] vis) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(i, j));
        vis[i][j] = true;

        int area = 1;

        while (!q.isEmpty()) {

            Pair front = q.remove();

            int row = front.row;
            int col = front.col;

            // Up
            if (row > 0 && !vis[row - 1][col] && grid[row - 1][col] == 1) {
                vis[row - 1][col] = true;
                q.add(new Pair(row - 1, col));
                area++;
            }

            // Down
            if (row + 1 < m && !vis[row + 1][col] && grid[row + 1][col] == 1) {
                vis[row + 1][col] = true;
                q.add(new Pair(row + 1, col));
                area++;
            }

            // Left
            if (col > 0 && !vis[row][col - 1] && grid[row][col - 1] == 1) {
                vis[row][col - 1] = true;
                q.add(new Pair(row, col - 1));
                area++;
            }

            // Right
            if (col + 1 < n && !vis[row][col + 1] && grid[row][col + 1] == 1) {
                vis[row][col + 1] = true;
                q.add(new Pair(row, col + 1));
                area++;
            }
        }

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        int maxArea = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1 && !vis[i][j]) {

                    int area = bfs(i, j, grid, vis);

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}
