// class Solution {
//     public int fact(int n) {
//         if (n <= 1) 
//             return 1;
//         return n * fact(n - 1);
//     }
//     public int trailingZeroes(int n) {
//         int b=fact(n);
//         String s = String.valueOf(b);

//         int count = 0;

//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '0') {
//                 count++;
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public int trailingZeroes(int n) {
    int res = 0;
    while (n > 0) {
        n /= 5;
        res += n;
    }
    return res;
}}