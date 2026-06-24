// class Solution {

//     int helper(int i, int j, List<List<Integer>> triangle, int[][] dp) {

//         if (i == triangle.size() - 1)
//             return triangle.get(i).get(j);

//         if (dp[i][j] != -1)
//             return dp[i][j];

//         int down = helper(i + 1, j, triangle, dp);
//         int diagonal = helper(i + 1, j + 1, triangle, dp);

//         return dp[i][j] =
//                 triangle.get(i).get(j) + Math.min(down, diagonal);
//     }

//     public int minimumTotal(List<List<Integer>> triangle) {

//         int n = triangle.size();

//         int[][] dp = new int[n][n];

//         for (int[] row : dp)
//             Arrays.fill(row, -1);

//         return helper(0, 0, triangle, dp);
//     }
// }
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int[] dp = new int[n];

        // Copy last row
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }

        // Move upward
        for (int i = n - 2; i >= 0; i--) {

            for (int j = 0; j <= i; j++) {

                dp[j] = triangle.get(i).get(j)
                        + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}