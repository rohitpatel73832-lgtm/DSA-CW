class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        
        int[] leftSum=new int[n];
        int[] rightSum=new int[n];
        int[] result= new int[n];
        
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
            result[i]=Math.abs(leftSum[i]-rightSum[i]);
        }
        return result;
    }
}