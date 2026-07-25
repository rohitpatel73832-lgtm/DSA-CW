class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void bfs(int i, int j, char[][] board) {

        int m = board.length;
        int n = board[0].length;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(i, j));
        board[i][j] = '#';     // Mark as safe

        while (!q.isEmpty()) {

            Pair front = q.remove();

            int row = front.row;
            int col = front.col;

            // Up
            if (row > 0 && board[row - 1][col] == 'O') {
                board[row - 1][col] = '#';
                q.add(new Pair(row - 1, col));
            }

            // Down
            if (row + 1 < m && board[row + 1][col] == 'O') {
                board[row + 1][col] = '#';
                q.add(new Pair(row + 1, col));
            }

            // Left
            if (col > 0 && board[row][col - 1] == 'O') {
                board[row][col - 1] = '#';
                q.add(new Pair(row, col - 1));
            }

            // Right
            if (col + 1 < n && board[row][col + 1] == 'O') {
                board[row][col + 1] = '#';
                q.add(new Pair(row, col + 1));
            }
        }
    }

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // First row
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                bfs(0, j, board);
            }
        }

        // Last row
        for (int j = 0; j < n; j++) {
            if (board[m - 1][j] == 'O') {
                bfs(m - 1, j, board);
            }
        }

        // First column
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                bfs(i, 0, board);
            }
        }

        // Last column
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O') {
                bfs(i, n - 1, board);
            }
        }

        // Convert remaining O to X and # back to O
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}