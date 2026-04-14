class Solution {

    public void revS(int a, int b, StringBuilder sb){
        while(a < b){
            char temp = sb.charAt(a);
            sb.setCharAt(a, sb.charAt(b));
            sb.setCharAt(b, temp);
            a++;
            b--;
        }
    }

    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for(int i = 0; i < sb.length(); i++){
            char ch = sb.charAt(i);

            if(ch == '('){
                st.push(i);
            }
            else if(ch == ')'){
                int a = st.pop();
                revS(a + 1, i - 1, sb);
            }
        }

        
        StringBuilder ans = new StringBuilder();
        for(char ch : sb.toString().toCharArray()){
            if(ch != '(' && ch != ')'){
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}