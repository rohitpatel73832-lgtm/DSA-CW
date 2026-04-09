class Solution {
    public String reversePrefix(String s, char ch) {
        int idx = s.indexOf(ch);
        if (idx == -1) return s;  
        
        StringBuilder sb = new StringBuilder(s.substring(0, idx + 1));
        sb.reverse();
        
        return sb.toString() + s.substring(idx + 1);
    }
}