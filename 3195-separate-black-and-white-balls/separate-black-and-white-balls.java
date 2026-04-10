class Solution {
    public long minimumSteps(String s) {
        long b=0; 
        long n=s.length();
        long steps=0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                b++;            
            } else {
                steps += b;     
            }
        }
        return steps;

    }
}