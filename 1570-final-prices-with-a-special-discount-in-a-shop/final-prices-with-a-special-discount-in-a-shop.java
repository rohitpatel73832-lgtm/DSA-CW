// class Solution {
//     public int[] finalPrices(int[] prices) {
//         int n= prices.length;
//         int[] ans = new int[n];
//         for(int i=0; i<n; i++){
//             ans[i]=prices[i];
//             for(int j=i+1; j<n; j++){
//                 if(prices[j]<=prices[i]){
//                     ans[i] = prices[i] - prices[j];
//                     break;
//                 }
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!st.isEmpty() && prices[st.peek()] >= prices[i]) {
                prices[st.pop()] -= prices[i];
            }
            st.push(i);
        }

        return prices;
    }
}