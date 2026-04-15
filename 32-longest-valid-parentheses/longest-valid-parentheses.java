//  class Solution {
//     public int longestValidParentheses(String s) {
//         int n = s.length();
//         int ans = 0;
//         int count = 0;

//         Stack<Character> st = new Stack<>();

//         for(int i = 0; i < n; i++){
//             char ch = s.charAt(i);

//             if(ch == '('){
//                 st.push(ch);
//             } else {
//                 if(st.size() == 0){
//                     count = 0; // reset when invalid
//                 } else {
//                     st.pop();
//                     count += 2;
//                     ans = Math.max(ans, count);
//                 }
//             }
//         }
//         return ans;
//     }
// }

 class Solution {
     public int longestValidParentheses(String s) {
         int n = s.length();
        int ans = 0;

        // LEFT → RIGHT
        int left = 0, right = 0;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '(') left++;
            else right++;

            if(left == right){
                ans = Math.max(ans, 2 * right);
            } 
            else if(right > left){
                left = right = 0;
            }
        }
        //right->left
        left = 0; right = 0;
        for(int i = n - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if(ch == '(') left++;
            else right++;

            if(left == right){
                ans = Math.max(ans, 2 * left);
            } 
            else if(left > right){
                left = right = 0;
            }
        }
        return ans;
    }
}