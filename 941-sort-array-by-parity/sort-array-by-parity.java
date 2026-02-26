class Solution {
    public int[] sortArrayByParity(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr2= new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==0){
                arr.add(nums[i]);
            }
            else{
                arr2.add(nums[i]);
            }
        }
        arr.addAll(arr2);
        int[] ans = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            ans[i] = arr.get(i);
        }
        return ans;
    }
}