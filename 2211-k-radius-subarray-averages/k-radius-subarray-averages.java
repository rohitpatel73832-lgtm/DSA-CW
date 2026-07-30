class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int right=2*k;
        int r=k;
        int[] ans= new int[n];
        long count=0;
        Arrays.fill(ans,-1);
        if(k==0) return nums;
        if (2 * k + 1 > n) return ans;
        while(right<n){
            for(int i=left; i<=right; i++){
                count+=nums[i];
                
            }
            ans[r]=(int)(count/(2*k+1));
            left++;
            right++;
            r++;
            count=0;
        }
        return ans;
    }
}