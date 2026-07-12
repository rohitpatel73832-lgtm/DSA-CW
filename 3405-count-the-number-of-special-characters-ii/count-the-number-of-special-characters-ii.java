class Solution {
    public int numberOfSpecialChars(String word) {
        int ans = 0;
        HashMap<Character, Integer> firstUpper = new HashMap<>();
        HashMap<Character, Integer> lastLower = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {
                lastLower.put(ch, i);
            } else {
                char lower = Character.toLowerCase(ch);
                firstUpper.putIfAbsent(lower, i);
            }
        }

        

        for (char ch : lastLower.keySet()) {
            if (firstUpper.containsKey(ch)
                    && lastLower.get(ch) < firstUpper.get(ch)) {
                ans++;
            }
        }

        return ans;
    }
}