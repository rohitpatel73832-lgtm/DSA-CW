class Solution {
    public int lengthOfLongestSubstring(String s) {
        

        // int res = 0;

        // for (int i = 0; i < s.length(); i++) {
        //     HashSet<Character> set = new HashSet<>();
        //     int count = 0;

        //     for (int j = i; j < s.length(); j++) {
        //         char ch = s.charAt(j);

        //         if (set.contains(ch)) {
        //             break;
        //         }

        //         set.add(ch);
        //         count++;
        //     }

        //     res = Math.max(res, count);
        // }

        // return res;

        Set<Character> st= new HashSet<>();
        int n= s.length();
        int l=0; 
        int r=0; 
        int mxLen=0;
        while(r<n){
            char ch=s.charAt(r);
            if(!st.contains(ch)){
                st.add(ch);
                mxLen=Math.max(mxLen,r-l+1);
                r++;
            }else{
                st.remove(s.charAt(l));
                l++;
            }
        }
        return mxLen;
    }
}
