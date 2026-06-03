class Solution {
    public int helper(String s, int idx, int[] dp) {
        if (idx == s.length()) {
            return 1;
        }

        if (s.charAt(idx) == '0') {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int count = helper(s, idx + 1, dp);

        if (idx + 1 < s.length()) {
            int num = (s.charAt(idx) - '0') * 10
                    + (s.charAt(idx + 1) - '0');

            if (num >= 10 && num <= 26) {
                count += helper(s, idx + 2, dp);
            }
        }

        return dp[idx] = count;
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return helper(s, 0, dp);
    }
}