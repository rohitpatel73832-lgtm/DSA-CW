class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        int st=0;
        int end=n-1;
        int ans=-1;
        while(st<=end){
            int mid=(st+end)/2;
            if(arr[mid+1]>arr[mid]){
                ans=mid+1;
                st=mid+1;

            }else{
                end=mid-1;
            }
        }
        return ans;

    }
}