class Solution {
    public int singleNumber(int[] nums) {
        // int result=0;
        // for(int i =0; i<nums.length; i++){
        //     result^=nums[i];
        // }
        // return result;

        HashSet<Integer> set= new HashSet<>();
        int sum=0;
        int hSum=0;
        int fin=0;
     for (int num : nums) {
            sum += num;
            if (!set.contains(num)) {
                set.add(num);
                hSum += num;
            }
        }
        
       
        fin=2*hSum-sum;
        return fin;

        // Map<Integer,Integer> mp = new HashMap<>();
        // for(int num: nums){
        //     if(!mp.containsKey(num)){
        //         mp.put(num,1);
        //     }else{
        //         mp.put(num,mp.get(num)+1);

        //     }
            
        // }
        // for(int num:nums){
        //         if(mp.get(num)==1) return num;
        //     }
        // return -1;
    }
}