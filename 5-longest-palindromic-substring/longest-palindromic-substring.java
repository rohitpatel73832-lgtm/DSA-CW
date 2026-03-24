class Solution {
    // public int countSubstrings(String s) {
    //     int n=s.length();
    //     int[][] dp=new int[n][n];
        
    //     for(int k=0;k<n;k++){
    //         int i=0; 
    //         int j=k;
    //         while(j<n){
    //             if(i==j){
    //                 dp[i][j]=1;
                    
    //             }else if(j==i+1){
    //                 if(s.charAt(i)==s.charAt(j)){
    //                     dp[i][j]=1;
                        
    //             }
    //                 }else{
    //                     if(s.charAt(i)==s.charAt(j)){
    //                         if(dp[i+1][j-1]==1){
    //                             dp[i][j]=1;
                                
    //                         }
    //                     }
    //                 }
    //                 i++;
    //                 j++;
                
    //         }
            
            
    //     }
    //     return count;
       
//}
    public String longestPalindrome(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        int maxLen = 1;
        int start = 0;
        for(int k=0;k<n;k++){
            int i=0; 
            int j=k;
            while(j<n){
                if(i==j){
                    dp[i][j]=1;
                    
                }else if(j==i+1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=1;
                        if (2 > maxLen) {
                            maxLen = 2;
                            start = i;
                        }
                }
                    }else{
                        if(s.charAt(i)==s.charAt(j)){
                            if(dp[i+1][j-1]==1){
                                dp[i][j]=1;
                                 if (j - i + 1 > maxLen) {
                                    maxLen = j - i + 1;
                                    start = i;
                                }
                            }
                        }
                    }
                    i++;
                    j++;
                
            }
            
            
        }
        return s.substring(start, start + maxLen);
        
    }
}