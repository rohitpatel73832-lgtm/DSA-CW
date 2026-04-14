class Solution {
    public int maxDepth(String s) {
        
        // int currentDepth = 0;
        // int maxDepth = 0;

        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);

        //     if (ch == '(') {
        //         currentDepth++;
        //         maxDepth = Math.max(maxDepth, currentDepth);
        //     } else if (ch == ')') {
        //         currentDepth--;
        //     }
        // }

       // return maxDepth;


       //solution via stack

       Stack<Character> st = new Stack<>();
       int ans = 0;
       for (char ch : s.toCharArray()) {
        if (ch == '(') {
                st.push(ch);
         } 
         else if (ch == ')') {
                ans = Math.max(ans, st.size());
                st.pop();
            }
        }
        return ans;

    }
}