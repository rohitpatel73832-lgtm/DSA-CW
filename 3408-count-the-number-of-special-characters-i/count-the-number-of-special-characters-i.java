class Solution {
    public int numberOfSpecialChars(String word) {
        int ans = 0;
        HashSet<Character> st = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            st.add(word.charAt(i));
        }
        HashSet<Character> visited = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)
                    && !visited.contains(ch)
                    && st.contains(Character.toUpperCase(ch))) {
                ans++;
                visited.add(ch);
            }
        }

        return ans;
    }
}