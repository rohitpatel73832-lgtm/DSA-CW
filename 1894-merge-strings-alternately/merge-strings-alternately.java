class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0; int j=0;
        String str="";
        StringBuilder sb= new StringBuilder(str);
        while(i<word1.length() && j<word2.length()){
            
            
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        }
        while(word1.length()<word2.length() && j < word2.length()){
                sb.append(word2.charAt(j));
                j++;
            }
            while(word1.length()>word2.length()  && i < word1.length()){
                sb.append(word1.charAt(i));
                i++;
            }
        return sb.toString();
    }
}