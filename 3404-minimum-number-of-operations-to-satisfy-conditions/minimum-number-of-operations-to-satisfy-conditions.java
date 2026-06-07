class Solution {

    int[][] dp;

    public int helper(int col, int prev, int[][] grid) {

        int n = grid[0].length;
        int m = grid.length;

        if (col == n) {
            return 0;
        }

        // prev ranges from -1 to 9
        if (dp[col][prev + 1] != -1) {
            return dp[col][prev + 1];
        }

        int ans = Integer.MAX_VALUE;

        for (int digit = 0; digit <= 9; digit++) {

            if (digit == prev) {
                continue;
            }

            int changes = 0;

            for (int row = 0; row < m; row++) {
                if (grid[row][col] != digit) {
                    changes++;
                }
            }

            ans = Math.min(
                ans,
                changes + helper(col + 1, digit, grid)
            );
        }

        return dp[col][prev + 1] = ans;
    }

    public int minimumOperations(int[][] grid) {

        int n = grid[0].length;

        dp = new int[n][11];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, -1, grid);
    }
}