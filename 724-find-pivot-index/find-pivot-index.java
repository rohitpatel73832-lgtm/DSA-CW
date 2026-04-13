class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int[] leftSum=new int[n];
        int[] rightSum=new int[n];

        for(int i=0; i<n; i++){
            if(i==0) leftSum[i]=0;
            else{
                leftSum[i]=leftSum[i-1]+nums[i-1];
            }
        }

        for(int i=n-1; i>=0; i--){
            if(i==n-1) rightSum[i]=0;
            else{
                rightSum[i] = rightSum[i + 1] + nums[i + 1];
            }
        }

        for(int i=0; i<n; i++){
            nums[i]=leftSum[i] -rightSum[i];
            if(nums[i]==0) return i;
        }
        return -1;
    }
}