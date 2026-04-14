class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb= new StringBuilder("");
        int n= s.length();
        int sum=0;
        for(int i=0; i<n; i++){
            char ch= s.charAt(i);
            if(ch=='('){
                sum++;
                if(sum==1) continue;
                else sb.append(ch);
            }else{
                if(ch==')'){
                    sum--;
                    if(sum==0) continue;
                    else sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}