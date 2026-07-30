// class Solution {
//    int ans = 0;
//     public void helper(int st, int del, int[] nums, int count) {
//         if (st == nums.length) {
//             ans = Math.max(ans, count);
//             return;
//         }
//         if (nums[st] == 1) {
//             helper(st + 1, del, nums, count + 1);
//         } else {
//             // Delete this zero if possible
//             if (del > 0) {
//                 helper(st + 1, del - 1, nums, count);
//             }
//             // End current subarray and start a new one
//             ans = Math.max(ans, count);
//             helper(st + 1, 1, nums, 0);
//         }
//     }

//     public int longestSubarray(int[] nums) {
//         helper(0, 1, nums, 0);
//         // If all elements are 1, one element must still be deleted.
//         if (ans == nums.length) return ans - 1;
//         return ans;
//     }
// }
class Solution {

    Integer[][] dp;

    public int helper(int i, int del, int[] nums) {

        if (i == nums.length)
            return 0;

        if (dp[i][del] != null)
            return dp[i][del];

        int ans = 0;

        if (nums[i] == 1) {
            ans = 1 + helper(i + 1, del, nums);
        } else {

            if (del == 0) {
                ans = helper(i + 1, 1, nums);
            } else {
                ans = 0;
            }
        }

        return dp[i][del] = ans;
    }

    public int longestSubarray(int[] nums) {

        int n = nums.length;

        dp = new Integer[n][2];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, helper(i, 0, nums));
        }

        if (ans == n)
            return n - 1;

        return ans;
    }
}