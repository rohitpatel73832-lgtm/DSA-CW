// class Solution {
//     public int findPeakElement(int[] a) {
//         int n = a.length;
//         int st=0;
//         int end=n-1;
//         while(st<=end){
//             int mid=(st+end)/2;
//             if ((mid == 0 || a[mid] > a[mid-1]) &&
//               (mid == n-1 || a[mid] > a[mid+1])) {
//               return mid;
//             }

//             if(a[mid]<a[mid+1]){
//                 st=mid+1;
//             }else{
//                 end=mid-1;
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}