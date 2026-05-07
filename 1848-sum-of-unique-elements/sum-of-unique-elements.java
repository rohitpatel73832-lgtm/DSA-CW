class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> st= new HashMap<>();
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            st.put(nums[i], st.getOrDefault(nums[i], 0) + 1);
        }

        for (int key : st.keySet()) {
            if (st.get(key) == 1) {
                sum += key;
            }
        }

        return sum;
        
    }
}