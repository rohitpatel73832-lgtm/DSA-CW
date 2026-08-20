// class Solution {
//     public int[] nextGreaterElements(int[] nums) {
//         int n= nums.length;
//         int[] ans= new int[n];
//         for( int i=0; i<n ; i++){
//             ans[i] = -1;
//             for(int j=1;j<n; j++){
//                 int next = nums[(i + j) % n];
//                 if(nums[i]<next){
//                     ans[i]=next;
//                     break;
//                 }
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] nge = new int[n];

        Stack<Integer> st = new Stack<>();

        // Put circular elements into stack
        for (int i = n - 1; i >= 0; i--) {
            st.push(nums[i]);
        }

        // Find NGE
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[i] >= st.peek()) {
                st.pop();
            }

            if (st.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }

            st.push(nums[i]);
        }

        return nge;
    }
}