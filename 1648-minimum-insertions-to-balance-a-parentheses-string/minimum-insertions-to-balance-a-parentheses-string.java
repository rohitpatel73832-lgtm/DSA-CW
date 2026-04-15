class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int insertions = 0;
        int i = 0;
        int n = s.length();

        while (i < n) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(ch);
                i++;
            } else {
                
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i += 2;
                } else {
                    
                    insertions++;
                    i++;
                }

                
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                   
                    insertions++;
                }
            }
        }

        
        insertions += st.size() * 2;

        return insertions;
    }
}