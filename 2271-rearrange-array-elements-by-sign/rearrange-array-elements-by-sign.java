class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans= new int[n];
        int[] pos= new int[n/2];
        int[] neg= new int[n/2];
        int p=0;
        int q=0;

        for(int i=0; i<n; i++){
            if(nums[i]>0){
                pos[p]=nums[i];
                p++;
            }else{
                neg[q]=nums[i];
                q++;
            }
        }
        p = 0;
        q = 0;
        for(int i=0; i<n; i=i+2){
            ans[i]=pos[p];
            p++;
        }
        for(int i=1; i<n; i=i+2){
            ans[i]=neg[q];
            q++;
        }
        return ans;

    }
}