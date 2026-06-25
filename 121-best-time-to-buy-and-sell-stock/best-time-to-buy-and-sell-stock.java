// class Solution {
//     public int maxProfit(int[] prices) {
//         int n=prices.length;
//         int profit=Integer.MIN_VALUE;
//         for(int i=0; i<n; i++){
//             for(int j=i+1; j<n; j++){
//                 int diff=prices[j]-prices[i];
//                 //if(diff>0){
//                     profit=Math.max(profit,diff);
//                 //}
//             }
//         }
//         if(profit<=0) {
//             return 0;
//         }else{
//             return profit;
//         }
        
//     }
// }
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}