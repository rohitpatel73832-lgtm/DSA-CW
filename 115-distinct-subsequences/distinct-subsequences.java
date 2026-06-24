// class Solution {

//     public int helper(int i, int j, String s, String t) {

//         // Entire target matched
//         if (j == t.length())
//             return 1;

//         // Source finished but target not matched
//         if (i == s.length())
//             return 0;

//         if (s.charAt(i) == t.charAt(j)) {

//             // Take current character
//             int take = helper(i + 1, j + 1, s, t);

//             // Skip current character
//             int skip = helper(i + 1, j, s, t);

//             return take + skip;
//         }

//         // Characters don't match, only skip
//         return helper(i + 1, j, s, t);
//     }

//     public int numDistinct(String s, String t) {
//         return helper(0, 0, s, t);
//     }
// }
class Solution {

    public int helper(int i, int j, String s, String t, Integer[][] dp) {

        if (j == t.length())
            return 1;

        if (i == s.length())
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        int ans;

        if (s.charAt(i) == t.charAt(j)) {
            ans = helper(i + 1, j + 1, s, t, dp)  // take
                + helper(i + 1, j, s, t, dp);     // skip
        } else {
            ans = helper(i + 1, j, s, t, dp);
        }

        return dp[i][j] = ans;
    }

    public int numDistinct(String s, String t) {

        Integer[][] dp = new Integer[s.length()][t.length()];

        return helper(0, 0, s, t, dp);
    }
}