class Solution {

    public class Pair {
        int row;
        int col;
        int steps;

        Pair(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;

        int a = entrance[0];
        int b = entrance[1];

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        q.add(new Pair(a, b, 0));
        vis[a][b] = true;   

        while (q.size() > 0) {

            Pair top = q.remove();

            int r = top.row;
            int c = top.col;
            int s = top.steps;

            // Current cell is an exit (but not the entrance)
            if ((r == 0 || r == m - 1 || c == 0 || c == n - 1)
                    && !(r == a && c == b)) {
                return s;
            }

            // Up
            if (r > 0) {
                if (maze[r - 1][c] == '.' && !vis[r - 1][c]) {
                    vis[r - 1][c] = true;
                    q.add(new Pair(r - 1, c, s + 1));
                }
            }

            // Left
            if (c > 0) {
                if (maze[r][c - 1] == '.' && !vis[r][c - 1]) {
                    vis[r][c - 1] = true;
                    q.add(new Pair(r, c - 1, s + 1));
                }
            }

            // Down
            if (r + 1 < m) {
                if (maze[r + 1][c] == '.' && !vis[r + 1][c]) {
                    vis[r + 1][c] = true;
                    q.add(new Pair(r + 1, c, s + 1));
                }
            }

            // Right
            if (c + 1 < n) {
                if (maze[r][c + 1] == '.' && !vis[r][c + 1]) {
                    vis[r][c + 1] = true;
                    q.add(new Pair(r, c + 1, s + 1));
                }
            }
        }

        return -1;
    }
}