class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Store frequency of characters in t
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = t.length();
        int i = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for (int j = 0; j < s.length(); j++) {

            char ch = s.charAt(j);

            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    count--;
                }
                map.put(ch, map.get(ch) - 1);
            }

            while (count == 0) {

                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }

                char leftChar = s.charAt(i);

                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);

                    if (map.get(leftChar) > 0) {
                        count++;
                    }
                }

                i++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}