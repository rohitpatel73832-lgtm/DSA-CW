class Solution {
    public int[] applyOperations(int[] nums) {
        int n= nums.length;
        int[] ans= new int[n];
        int p=0;
        for(int i=0; i<n-1; i++){
            if(nums[i]==nums[i+1]){
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
        }
        for(int i=0;i<n; i++){
            if(nums[i]!=0){
                ans[p]=nums[i];
                p++;
            }
        }
        return ans;
    }
}