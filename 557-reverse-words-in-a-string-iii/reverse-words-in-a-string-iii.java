class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        StringBuilder str = new StringBuilder();

        for (int i = 0; i <= arr.length - 1; i++) {
            String st = arr[i];
            char[] ch = st.toCharArray();
            int n = ch.length;

            for (int j = 0, k = n - 1; j <= k; j++, k--) {
                char temp = ch[j];
                ch[j] = ch[k];
                ch[k] = temp;
            }

            str.append(new String(ch));

            if (i != arr.length - 1)
                str.append(" ");
        }

        return str.toString();
    }
}