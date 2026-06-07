class Solution {

    int ans = Integer.MIN_VALUE;
    Integer[][] dp;

    public int helper(int i, int j, List<List<Integer>> grid) {

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int curr = grid.get(i).get(j);

        // Starting cell
        if (i == 0 && j == 0) {
            return dp[i][j] = curr;
        }

        int minPrev = Integer.MAX_VALUE;

        if (i > 0) {
            minPrev = Math.min(minPrev, helper(i - 1, j, grid));
        }

        if (j > 0) {
            minPrev = Math.min(minPrev, helper(i, j - 1, grid));
        }

        ans = Math.max(ans, curr - minPrev);

        return dp[i][j] = Math.min(curr, minPrev);
    }

    public int maxScore(List<List<Integer>> grid) {

        int m = grid.size();
        int n = grid.get(0).size();

        dp = new Integer[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(i, j, grid);
            }
        }

        return ans;
    }
}