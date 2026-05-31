class Solution {
    public double myPow(double x, int n) {
        double ans=Math.pow(x,n);
        return ans;
        // if(n==0) return 1;
        // double ans=myPow(x,n-1)*n;
        // return ans;
    }
}