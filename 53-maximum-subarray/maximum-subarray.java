// class Solution {
//     public int maxSubArray(int[] nums) {
//         int maxSum=Integer.MIN_VALUE;
//         int currSum=0;
//         for(int i=0;i<nums.length;i++){
//             currSum+=nums[i];
//             if(currSum>maxSum){
//                 maxSum=currSum;
//             }
//             if(currSum<0){
//                 currSum=0;
//             }
//         }
//         return maxSum;
//     }
// }

class Solution {

    int[] dp;

    public int helper(int idx, int[] nums) {

        if(idx == nums.length) {
            return 0;
        }

        if(dp[idx] != Integer.MIN_VALUE) {
            return dp[idx];
        }

        int take = nums[idx] + helper(idx + 1, nums);

        dp[idx] = Math.max(nums[idx], take);

        return dp[idx];
    }

    public int maxSubArray(int[] nums) {

        dp = new int[nums.length];

        Arrays.fill(dp, Integer.MIN_VALUE);

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, helper(i, nums));
        }

        return ans;
    }
}