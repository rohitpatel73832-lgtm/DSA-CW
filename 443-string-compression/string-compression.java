class Solution {
    public int compress(char[] chars) {
        String s = "";
        int n = chars.length;
        int count = 1;   
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < n; i++) {
            char p = chars[i];

            
            if (i < n - 1 && chars[i] == chars[i + 1]) {
                count++;
            } else {
                
                sb.append(p);

                
                if (count > 1) {
                    sb.append(count);
                }

                count = 1; 
            }
        }

        
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length(); 
    }
}