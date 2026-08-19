class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st= new Stack<>();
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        st.push(s.charAt(0));
        for(int i=1; i<n; i++){
            char c=s.charAt(i);
            if(st.size()>0 && st.peek().equals(c)){
                st.pop();
            }else{
                st.push(c);
            }
        }

        while(st.size()>0){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}