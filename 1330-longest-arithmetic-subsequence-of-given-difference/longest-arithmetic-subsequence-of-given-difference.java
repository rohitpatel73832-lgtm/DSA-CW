// class Solution {

//     public int helper(int idx, int prev,
//                       int[] arr, int difference,
//                       int[][] dp) {

//         if (idx == arr.length) {
//             return 0;
//         }

//         if (dp[idx][prev + 1] != -1) {
//             return dp[idx][prev + 1];
//         }

//         // Skip
//         int notTake = helper(idx + 1, prev,
//                              arr, difference, dp);

//         // Take
//         int take = 0;

//         if (prev == -1 ||
//             arr[idx] - arr[prev] == difference) {

//             take = 1 + helper(idx + 1, idx,
//                               arr, difference, dp);
//         }

//         return dp[idx][prev + 1] =
//                 Math.max(take, notTake);
//     }

//     public int longestSubsequence(int[] arr, int difference) {

//         int n = arr.length;

//         int[][] dp = new int[n][n + 1];

//         for (int i = 0; i < n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return helper(0, -1, arr, difference, dp);
//     }
// }
class Solution {
    public int longestSubsequence(int[] arr, int difference) {

        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int x : arr) {

            int prev = x - difference;

            int currLen = dp.getOrDefault(prev, 0) + 1;

            dp.put(x, currLen);

            ans = Math.max(ans, currLen);
        }

        return ans;
    }
}