class Solution {

    public int helper(int i, int[] nums, int[] dp) {

        int n = nums.length;

        if (i >= n - 1) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int ans = Integer.MAX_VALUE;

        for (int jump = 1; jump <= nums[i]; jump++) {

            int next = i + jump;

            if (next < n) {

                int temp = helper(next, nums, dp);

                if (temp != Integer.MAX_VALUE) {
                    ans = Math.min(ans, 1 + temp);
                }
            }
        }

        return dp[i] = ans;
    }

    public int jump(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return helper(0, nums, dp);
    }
}