class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
        int[] ans= new int[n];
        for( int i=0; i<n ; i++){
            ans[i] = -1;
            for(int j=0;j<n; j++){
                int next = nums[(i + j) % n];
                if(nums[i]<next){
                    ans[i]=next;
                    break;
                }
            }
        }
        return ans;
    }
}