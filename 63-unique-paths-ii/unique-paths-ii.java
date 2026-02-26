class Solution {

    public int helper(int r, int c, int m, int n, int[][] obstacleGrid,int[][] dp){

        
        if(r >= m || c >= n) return 0;

       
        if(obstacleGrid[r][c] == 1) return 0;

        
        if(r == m-1 && c == n-1) return 1;
        if(dp[r][c]!=-1) return dp[r][c];

        int right = helper(r, c+1, m, n, obstacleGrid,dp);
        int down  = helper(r+1, c, m, n, obstacleGrid,dp);

        return dp[r][c] = right + down;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for(int[] row:dp)
            Arrays.fill(row,-1);

        return helper(0,0,m,n,obstacleGrid,dp);

        
    }
}