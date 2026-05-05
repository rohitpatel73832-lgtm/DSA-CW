class Solution {
    public int singleNumber(int[] nums) {
        // int result=0;
        // for(int i =0; i<nums.length; i++){
        //     result^=nums[i];
        // }
        // return result;

        Map<Integer,Integer> mp = new HashMap<>();
        for(int num: nums){
            if(!mp.containsKey(num)){
                mp.put(num,1);
            }else{
                mp.put(num,mp.get(num)+1);

            }
            
        }
        for(int num:nums){
                if(mp.get(num)==1) return num;
            }
        return -1;
    }
}