// class Solution {
//     public int helper(int i,int prev,int[] nums){
//         if(i==nums.length){
//             return 0;
//         }
//         int skip = helper(i + 1, prev, nums);
//         int take=0;
//         if(prev==-1 || nums[i]>nums[prev]){
//             take=1+helper(i + 1, i, nums);
//         }
//         return Math.max(take,skip);
        

//     }
//     public int lengthOfLIS(int[] nums) {
        
//        return helper(0,-1,nums);
//     }
// }
// class Solution {

//     public int helper(int i, int prev, int[] nums, int[][] dp) {

//         if (i == nums.length)
//             return 0;

//         if (dp[i][prev + 1] != -1)
//             return dp[i][prev + 1];

        
//         int skip = helper(i + 1, prev, nums, dp);

        
//         int take = 0;
//         if (prev == -1 || nums[i] > nums[prev]) {
//             take = 1 + helper(i + 1, i, nums, dp);
//         }

//         return dp[i][prev + 1] = Math.max(take, skip);
//     }

//     public int lengthOfLIS(int[] nums) {

//         int n = nums.length;

//         int[][] dp = new int[n][n + 1];

//         for (int i = 0; i < n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return helper(0, -1, nums, dp);
//     }
//}
class Solution {
    public int lengthOfLIS(int[] nums){
        int n= nums.length;
        int max=0;
        int[] dp= new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<=i-1; j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]);
                }
                
            }
            dp[i]++;
            max=Math.max(dp[i],max);
        }
        return max;
    }
}