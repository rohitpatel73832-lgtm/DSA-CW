// class Solution {

//     public int helper(int row, int col, int[][] grid) {

//         int m = grid.length;
//         int n = grid[0].length;

//         int ans = 0;

//         // right-up
//         if (row - 1 >= 0 &&
//             col + 1 < n &&
//             grid[row - 1][col + 1] > grid[row][col]) {

//             ans = Math.max(ans,
//                     1 + helper(row - 1, col + 1, grid));
//         }

//         // right
//         if (col + 1 < n &&
//             grid[row][col + 1] > grid[row][col]) {

//             ans = Math.max(ans,
//                     1 + helper(row, col + 1, grid));
//         }

//         // right-down
//         if (row + 1 < m &&
//             col + 1 < n &&
//             grid[row + 1][col + 1] > grid[row][col]) {

//             ans = Math.max(ans,
//                     1 + helper(row + 1, col + 1, grid));
//         }

//         return ans;
//     }

//     public int maxMoves(int[][] grid) {

//         int m = grid.length;

//         int ans = 0;

//         for (int row = 0; row < m; row++) {
//             ans = Math.max(ans, helper(row, 0, grid));
//         }

//         return ans;
//     }
// }

class Solution {

    int[][] dp;

    public int helper(int row, int col, int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int ans = 0;

        // right-up
        if (row - 1 >= 0 &&
            col + 1 < n &&
            grid[row - 1][col + 1] > grid[row][col]) {

            ans = Math.max(ans,
                    1 + helper(row - 1, col + 1, grid));
        }

        // right
        if (col + 1 < n &&
            grid[row][col + 1] > grid[row][col]) {

            ans = Math.max(ans,
                    1 + helper(row, col + 1, grid));
        }

        // right-down
        if (row + 1 < m &&
            col + 1 < n &&
            grid[row + 1][col + 1] > grid[row][col]) {

            ans = Math.max(ans,
                    1 + helper(row + 1, col + 1, grid));
        }

        return dp[row][col] = ans;
    }

    public int maxMoves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;

        for (int row = 0; row < m; row++) {
            ans = Math.max(ans, helper(row, 0, grid));
        }

        return ans;
    }
}