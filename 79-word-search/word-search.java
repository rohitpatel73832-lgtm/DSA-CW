class Solution {

    public boolean helper(int i, int j, char[][] board, String word, String s, boolean[][] vis) {

        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n)
            return false;
        if (vis[i][j])
            return false;

        s = s + board[i][j];
        
        if (!word.startsWith(s))
            return false;

        if (s.equals(word))
            return true;

        vis[i][j] = true;

        boolean ans =
                helper(i + 1, j, board, word, s, vis) ||
                helper(i - 1, j, board, word, s, vis) ||
                helper(i, j + 1, board, word, s, vis) ||
                helper(i, j - 1, board, word, s, vis);

        vis[i][j] = false; // Backtrack

        return ans;
    }

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (helper(i, j, board, word, "", vis))
                    return true;
            }
        }

        return false;
    }
}