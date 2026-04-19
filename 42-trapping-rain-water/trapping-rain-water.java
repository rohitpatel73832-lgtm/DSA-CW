class Solution {
    public int trap(int[] height) {
        int n= height.length;
        int[] leftMax= new int[n];
        int[] rightMax= new int[n];
        leftMax[0]= height[0];
        rightMax[n-1]= height[n-1];
        int ans=0;


        //finding left max element;
        for(int i=1; i<n; i++){
            leftMax[i]= Math.max(leftMax[i-1],height[i]);
        }

        //finding next max element;
        for(int i=n-2; i>=0; i--){
            rightMax[i]= Math.max(rightMax[i+1],height[i]);
        }

        for(int i=0; i<n; i++){
            ans+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return ans;
    }
}