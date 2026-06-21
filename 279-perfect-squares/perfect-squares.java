class Solution {
    // public boolean isPerfect(int n){
    //     int sqrt=(int)Math.sqrt(n);
    //     if(sqrt*sqrt==n) return true;
    //     return false;
        
    // }
    // public int minS(int n,int[] dp){
    //     if(isPerfect(n)) return 1;
    //     if(dp[n]!=-1) return dp[n];
    //     int min=Integer.MAX_VALUE;
    //     for(int i=1; i*i<=n;i++){
    //         int count=minS(i*i,dp) +minS(n-i*i,dp);
    //         min=Math.min(min,count);
           
    //     }
    //      return dp[n]=min;
    // }
    // public int numSquares(int n) {
    //     int[] dp=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return minS(n,dp);
    //}
   

    // public int helper(int st, int[] arr, int n) {

    //     if (n == 0)
    //         return 0;

    //     if (st >= arr.length)
    //         return Integer.MAX_VALUE;

    //     int take = Integer.MAX_VALUE;

    //     if (arr[st] <= n) {
    //         int temp = helper(st, arr, n - arr[st]);

    //         if (temp != Integer.MAX_VALUE)
    //             take = 1 + temp;
    //     }

    //     int skip = helper(st + 1, arr, n);

    //     return Math.min(take, skip);
    // }

    // public int numSquares(int n) {

    //     int size = (int) Math.sqrt(n);

    //     int[] arr = new int[size];

    //     for (int i = 1; i <= size; i++) {
    //         arr[i - 1] = i * i;
    //     }

    //     return helper(0, arr, n);
    // }

   

    public int helper(int st, int[] arr, int n, int[][] dp) {

        if (n == 0)
            return 0;

        if (st >= arr.length)
            return Integer.MAX_VALUE;

        if (dp[st][n] != -1)
            return dp[st][n];

        int take = Integer.MAX_VALUE;

if (arr[st] <= n) {
    take = helper(st, arr, n - arr[st], dp);

    if (take != Integer.MAX_VALUE)
        take = 1 + take;
}

int skip = helper(st + 1, arr, n, dp);

return dp[st][n] = Math.min(take, skip);
    }

    public int numSquares(int n) {

        int size = (int) Math.sqrt(n);

        int[] arr = new int[size];

        for (int i = 1; i <= size; i++) {
            arr[i - 1] = i * i;
        }

        int[][] dp = new int[size][n + 1];

        for (int i = 0; i < size; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, arr, n, dp);
    }

}