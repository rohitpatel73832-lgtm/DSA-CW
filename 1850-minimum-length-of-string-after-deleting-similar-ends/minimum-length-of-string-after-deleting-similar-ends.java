class Solution {
    public int minimumLength(String s) {
        int pre = 0; 
        int n = s.length();
        int suf = n - 1;

        while (pre < suf) {
            if (s.charAt(pre) == s.charAt(suf)) {
                char ch = s.charAt(pre);

                // remove all same chars from left
                while (pre <= suf && s.charAt(pre) == ch) {
                    pre++;
                }

                // remove all same chars from right
                while (pre <= suf && s.charAt(suf) == ch) {
                    suf--;
                }
            } else {
                break; 
            }
        }

        return suf - pre + 1;
    }
}