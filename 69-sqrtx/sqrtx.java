class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // if (mid == x / mid) {
            //     return mid;
            // } else if (mid < x / mid) {
            //     left = mid + 1;
            // } else {
            //     right = mid - 1;
            // }
            if((long)mid*mid==x){
                return mid;
            }else if((long)mid*mid>x){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return right;
    }
}