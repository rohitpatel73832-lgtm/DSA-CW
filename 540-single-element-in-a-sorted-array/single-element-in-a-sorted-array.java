// class Solution {
//     public int singleNonDuplicate(int[] nums) {
//         HashMap<Integer,Integer> mp = new HashMap<>();
//         for(int i=0;i<nums.length; i++){
//             mp.put(nums[i],mp.getOrDefault(nums[i], 0) + 1);
//         }
//         for (Map.Entry<Integer, Integer> ele : mp.entrySet()) {
//             if (ele.getValue() == 1) {
//                 return ele.getKey();
//             }
//         }

//         return -1;
//     }
// }
class Solution {
    public int singleNonDuplicate(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;
            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }
}