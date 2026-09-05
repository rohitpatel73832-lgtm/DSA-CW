class Solution {
    public int lengthOfLongestSubstring(String s) {
        

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            int count = 0;

            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);

                if (set.contains(ch)) {
                    break;
                }

                set.add(ch);
                count++;
            }

            res = Math.max(res, count);
        }

        return res;
    }
}
