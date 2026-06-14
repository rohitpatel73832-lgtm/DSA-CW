// class Solution {

//     public int helper(int i, int[] nums) {

//         int n = nums.length;

//         if (i >= n - 1) {
//             return 0;
//         }

//         int ans = Integer.MAX_VALUE;

//         for (int jump = 1; jump <= nums[i]; jump++) {

//             int next = i + jump;

//             if (next < n) {
//                 int temp = helper(next, nums);

//                 if (temp != Integer.MAX_VALUE) {
//                     ans = Math.min(ans, 1 + temp);
//                 }
//             }
//         }

//         return ans;
//     }

//     public int jump(int[] nums) {
//         return helper(0, nums);
//     }
// }
class Solution {
    public int jump(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}