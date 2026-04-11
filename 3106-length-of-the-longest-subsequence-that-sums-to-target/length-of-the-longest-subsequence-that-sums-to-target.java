// class Solution {
//     public int count(int i,List<Integer> nums, int target){
//         if(i==nums.size()){
//             if(target==0) return 0;
//             else return -1;
//         }
//         int skip=count(i+1,nums,target);
//         if(target-nums.get(i)<0) return skip;
//         int take=count(i+1,nums,target-nums.get(i));
//         int res = -1;

//         if(take != -1){  
//             res = 1 + take;
//         }
//         return Math.max(skip,res);
//     }
//     public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
//         int n= nums.size();
//         return count(0,nums,target);
//     }
// }

class Solution {
    public int count(int i, List<Integer> nums, int target, int[][] dp){
        if(i == nums.size()){
            if(target == 0) return 0;
            else return -1;
        }

        if(dp[i][target] != -2) return dp[i][target]; 

        int skip = count(i+1, nums, target, dp);

        int res = -1;

        if(target - nums.get(i) >= 0){
            int take = count(i+1, nums, target - nums.get(i), dp);

            if(take != -1){
                res = 1 + take;
            }
        }

        return dp[i][target] = Math.max(skip, res);
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();

        int[][] dp = new int[n][target+1];

       
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= target; j++){
                dp[i][j] = -2;
            }
        }

        return count(0, nums, target, dp);
    }
}