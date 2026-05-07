class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans= new ArrayList<>();
        HashSet<Integer> st = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(st.contains(nums[i])){
                ans.add(nums[i]);
            }else{
                st.add(nums[i]);
            }
        }
        return ans;
    }
}