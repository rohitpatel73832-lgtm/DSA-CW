// class Solution {
//     public int helper(int i,int k,int canBuy,int[] prices){
//     if(i==prices.length || k<=0) return 0;
//         if(canBuy==1){
//             int buy=-prices[i] + helper(i+1,k-1,0,prices);
//             int skip= helper(i+1,k,1,prices);
//             return Math.max(buy,skip);
//         }else{
//             int sell=prices[i] + helper(i+1,k,1,prices);
//             int hold=helper(i+1,k,0,prices);
//             return Math.max(sell,hold);
//         }
//     }
//     public int maxProfit(int k, int[] prices) {
//         return helper(0,k,1,prices);
//     }
// }



class Solution {

    public int helper(int i, int k, int canBuy, int[] prices, int[][][] dp) {

        if (i == prices.length || k <= 0)
            return 0;

        if (dp[i][k][canBuy] != -1)
            return dp[i][k][canBuy];

        if (canBuy == 1) {

            int buy = -prices[i] + helper(i + 1, k , 0, prices, dp);

            int skip = helper(i + 1, k, 1, prices, dp);

            dp[i][k][canBuy] = Math.max(buy, skip);

        } else {

            int sell = prices[i] + helper(i + 1, k-1, 1, prices, dp);

            int hold = helper(i + 1, k, 0, prices, dp);

            dp[i][k][canBuy] = Math.max(sell, hold);
        }

        return dp[i][k][canBuy];
    }

    public int maxProfit(int k, int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n][k + 1][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(0, k, 1, prices, dp);
    }
}