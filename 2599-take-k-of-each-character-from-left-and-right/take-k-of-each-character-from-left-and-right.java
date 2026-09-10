class Solution {
    public int takeCharacters(String s, int k) {

        int n = s.length();
        int[] arr = new int[3];

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            arr[ch - 'a']++;
        }

        // Impossible to take k of any character
        if(arr[0] < k || arr[1] < k || arr[2] < k){
            return -1;
        }

        int maxW = 0;
        int l = 0;
        int r = 0;

        while(r < n){

            char ch = s.charAt(r);
            arr[ch - 'a']--;
            while(arr[0] < k || arr[1] < k || arr[2] < k){

                char left = s.charAt(l);

                arr[left - 'a']++;

                l++;
            }

            maxW = Math.max(maxW, r - l + 1);

            r++;
        }

        return n - maxW;
    }
}