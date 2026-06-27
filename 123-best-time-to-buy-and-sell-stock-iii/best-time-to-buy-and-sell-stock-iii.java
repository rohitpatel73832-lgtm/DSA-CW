// class Solution {
//     public int helper(int i,int trans,int canBuy,int[] prices){
//         if(i==prices.length || trans<0) return 0;
//         if(canBuy==1){
//             int buy=-prices[i] + helper(i+1,trans-1,0,prices);
//             int skip= helper(i+1,trans,1,prices);
//             return Math.max(buy,skip);
//         }else{
//             int sell=prices[i] + helper(i+1,trans,1,prices);
//             int hold=helper(i+1,trans,0,prices);
//             return Math.max(sell,hold);
//         }
//     }
//     public int maxProfit(int[] prices) {
//        return helper(0,2,1,prices);
//     }
// }


class Solution {

    public int helper(int i, int trans, int canBuy, int[] prices, int[][][] dp) {

        if (i == prices.length || trans < 0)
            return 0;

        if (dp[i][trans][canBuy] != -1)
            return dp[i][trans][canBuy];

        if (canBuy == 1) {

            int buy = -prices[i] + helper(i + 1, trans - 1, 0, prices, dp);

            int skip = helper(i + 1, trans, 1, prices, dp);

            dp[i][trans][canBuy] = Math.max(buy, skip);

        } else {

            int sell = prices[i] + helper(i + 1, trans, 1, prices, dp);

            int hold = helper(i + 1, trans, 0, prices, dp);

            dp[i][trans][canBuy] = Math.max(sell, hold);
        }

        return dp[i][trans][canBuy];
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n][3][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(0, 2, 1, prices, dp);
    }
}