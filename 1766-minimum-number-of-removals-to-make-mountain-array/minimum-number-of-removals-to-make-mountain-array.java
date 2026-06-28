class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n= nums.length;
        int[] dp1= new int[n];
        //LIS -> Left to Right
        for(int i=0; i<n; i++){
            for(int j=0; j<=i-1; j++){
                if(nums[i]>nums[j]){
                    dp1[i]=Math.max(dp1[i],dp1[j]);
                }

            }
            dp1[i]++;
        } 
         int[] dp2= new int[n];
        //LIS -> Right to Left
        for(int i=n-1; i>=0; i--){
            //for(int j=i+1; j<=n-1; j++){
             for (int j = n - 1; j >= i + 1; j--) {
                if(nums[i]>nums[j]){
                    dp2[i]=Math.max(dp2[i],dp2[j]);
                }

            }
            dp2[i]++;
        } 
        int mxLen=0;
        for(int i=0; i<n; i++){
            if(dp1[i]>1 && dp2[i]>1){
                int len=dp1[i] + dp2[i]-1;
                mxLen=Math.max(mxLen,len);
            }
        }

        if(mxLen<3) return 0;
        return n-mxLen;
    }

    
}