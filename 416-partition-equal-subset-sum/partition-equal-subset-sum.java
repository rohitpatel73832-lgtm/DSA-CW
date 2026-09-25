// class Solution {
//     public boolean subset(int i,int[] arr,int target,int[][] dp){
//         if(i==arr.length){
//             if(target==0) return true;
//             else return false;
//         }
//         if(dp[i][target]!=-1) return (dp[i][target]==1);
//         boolean ans = false;
//         boolean skip = subset(i+1,arr,target,dp);
//         if(target-arr[i]<0) ans = skip;
//         else{
//             boolean pick = subset(i+1,arr,target-arr[i],dp);
//             ans=pick||skip;
//         }
//         dp[i][target]=(ans)?1:0;
//         return ans;
//     }
//     public boolean canPartition(int[] nums) {
//         int sum=0;
//         for(int ele:nums) sum+=ele;
//         if(sum%2!=0) return false;
//         int target=sum/2;
//         int[][] dp=new int[nums.length][target+1];
//         for(int i=0; i<dp.length;i++){
//             for(int j=0;j<dp[0].length;j++){
//                 dp[i][j]=-1;
//             }
//         } 
//         return subset(0,nums,target,dp);
//     }
// }

class Solution {
    //boolean ans;
    public boolean helper(int[] nums,int i,int sum,int count,Boolean[][] dp){
        if(count == sum/2){
            //ans = true;
            return true;
        }
        if(i>=nums.length){
            return false;
        }

        if(dp[i][count]!=null){
            return dp[i][count];
        }
        

        // helper(nums,i+1,sum,count+nums[i]);
        // helper(nums,i+1,sum,count);

        boolean take=helper(nums,i+1,sum,count+nums[i],dp);
        boolean skip=helper(nums,i+1,sum,count,dp);

        return dp[i][count] = take || skip;

    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int ele:nums){
            sum+=ele;
        }
        if(sum % 2 != 0){
            return false;
        }
        Boolean[][] dp= new Boolean[nums.length][sum];
        return helper(nums,0,sum,0,dp);
        //return ans;
    }
}