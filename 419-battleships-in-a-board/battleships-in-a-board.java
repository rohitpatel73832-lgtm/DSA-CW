class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void bfs(int r, int c, boolean[][] vis, char[][] board) {

        int m = board.length;
        int n = board[0].length;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(r, c));
        vis[r][c] = true;

        while (!q.isEmpty()) {

            Pair front = q.remove();

            int row = front.row;
            int col = front.col;

            // Move Right
            if (col + 1 < n &&
                board[row][col + 1] == 'X' &&
                !vis[row][col + 1]) {

                vis[row][col + 1] = true;
                q.add(new Pair(row, col + 1));
            }

            // Move Down
            if (row + 1 < m &&
                board[row + 1][col] == 'X' &&
                !vis[row + 1][col]) {

                vis[row + 1][col] = true;
                q.add(new Pair(row + 1, col));
            }
        }
    }

    public int countBattleships(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        int count = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'X' && !vis[i][j]) {

                    bfs(i, j, vis, board);
                    count++;
                }
            }
        }

        return count;
    }
}