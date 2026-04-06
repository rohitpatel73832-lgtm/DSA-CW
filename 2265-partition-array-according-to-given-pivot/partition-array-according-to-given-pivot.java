class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n= nums.length;
        int[] ans= new int[n];
        int p=0;
        for(int i=0;i<n; i++){
            if(nums[i]<pivot){
                ans[p]=nums[i];
                p++;
            }
        }
        for(int i=0;i<n; i++){
            if(nums[i]==pivot){
                ans[p]=nums[i];
                p++;
            }
        }
        for(int i=0;i<n; i++){
            if(nums[i]>pivot){
                ans[p]=nums[i];
                p++;
            }
        }
        
        return ans;
    }
}