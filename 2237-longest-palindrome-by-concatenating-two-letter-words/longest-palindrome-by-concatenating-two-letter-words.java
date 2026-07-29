class Solution {
    public int longestPalindrome(String[] words) {
       Map<String, Integer> mp = new HashMap<>();
        for (String word : words) {
            mp.put(word, mp.getOrDefault(word, 0) + 1);
        }
        boolean centreUsed = false;
        int result = 0;
        for (String w : words) {
        String rev = "" + w.charAt(1) + w.charAt(0);
        if (!rev.equals(w)) {
                if (mp.containsKey(rev) &&
                    mp.get(w) > 0 &&
                    mp.get(rev) > 0) {

                    mp.put(w, mp.get(w) - 1);
                    mp.put(rev, mp.get(rev) - 1);

                    result += 4;
                }

            } else {
                if (mp.get(w) >= 2) {
                    mp.put(w, mp.get(w) - 2);
                    result += 4;

                } else if (mp.get(w) == 1 && !centreUsed) {

                    mp.put(w, 0);
                    result += 2;
                    centreUsed = true;
                }
            }
        }

        return result;
    }
}