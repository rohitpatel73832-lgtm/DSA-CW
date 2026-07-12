class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {

        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], i);
        }
        for (int[] op : operations) {
            int oldValue = op[0];
            int newValue = op[1];

            int index = mp.get(oldValue);
            nums[index] = newValue;

            mp.remove(oldValue);
            mp.put(newValue, index);
        }

        return nums;
    }
}