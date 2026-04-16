class Solution {
    public String smallestNumber(String p) {
        int n= p.length();
        Stack<Integer> st = new Stack<>();
        StringBuilder ans= new StringBuilder();
        for(int i=0; i<=n; i++){
            st.push(i+1);
            if(i==n || p.charAt(i)=='I'){
                while(st.size()>0){
                    ans.append(st.pop());
                }
            }
        }
        return ans.toString();
    }
}