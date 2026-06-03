class Solution {

    public int helper(int[] points, int i, int[] dp) {

        if (i >= points.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int take = points[i] + helper(points, i + 2, dp);

        int skip = helper(points, i + 1, dp);

        return dp[i] = Math.max(take, skip);
    }

    public int deleteAndEarn(int[] nums) {

        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] points = new int[max + 1];

        for (int num : nums) {
            points[num] += num;
        }

        int[] dp = new int[max + 1];
        Arrays.fill(dp, -1);

        return helper(points, 0, dp);
    }
}