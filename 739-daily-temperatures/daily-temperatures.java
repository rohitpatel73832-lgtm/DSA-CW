// class Solution {
//     public int[] dailyTemperatures(int[] t) {
//         int n=t.length;
//         int[] ans= new int[n];
       
//         for(int i=0; i<n; i++){
//             ans[i]=0;
//             for(int j=i+1; j<n; j++){
//                 if(t[j]>t[i]){
                    
//                     ans[i]=j-i;
                    
//                     break;
//                 }
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n= t.length;
        int[] ans= new int[n];
        Stack<Integer> st= new Stack<>();
        for(int i=0; i<n; i++){
            while(st.size()>0 && t[i]>t[st.peek()]){
                int prev= st.pop();
                ans[prev]=i-prev;
            }
            st.push(i);
        }
        return ans;
    }
}