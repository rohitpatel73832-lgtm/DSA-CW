// class Solution {

//     public int helper(int i, int canBuy, int cap, int[] prices) {

//         if (i == prices.length || cap == 0)
//             return 0;

//         if (canBuy == 1) {

//             int buy = -prices[i] + helper(i + 1, 0, cap, prices);

//             int skip = helper(i + 1, 1, cap, prices);

//             return Math.max(buy, skip);

//         } else {

//             int sell = prices[i] + helper(i + 1, 1, cap - 1, prices);

//             int hold = helper(i + 1, 0, cap, prices);

//             return Math.max(sell, hold);
//         }
//     }

//     public int maxProfit(int[] prices) {
//         return helper(0, 1, 1, prices);
//     }
// }
import java.util.Arrays;

class Solution {

    public int helper(int i, int canBuy, int cap, int[] prices, int[][][] dp) {

        if (i == prices.length || cap == 0)
            return 0;

        if (dp[i][canBuy][cap] != -1)
            return dp[i][canBuy][cap];

        if (canBuy == 1) {

            int buy = -prices[i] + helper(i + 1, 0, cap, prices, dp);

            int skip = helper(i + 1, 1, cap, prices, dp);

            dp[i][canBuy][cap] = Math.max(buy, skip);

        } else {

            int sell = prices[i] + helper(i + 1, 1, cap - 1, prices, dp);

            int hold = helper(i + 1, 0, cap, prices, dp);

            dp[i][canBuy][cap] = Math.max(sell, hold);
        }

        return dp[i][canBuy][cap];
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n][2][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(0, 1, 1, prices, dp);
    }
}