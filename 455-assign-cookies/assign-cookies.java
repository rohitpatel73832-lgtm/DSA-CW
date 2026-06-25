class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length;
        int m=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(s[j]>=g[i]){
                    count++;
                    s[j]=0;
                   break;
                }
                 
            }
        }
        return count;
    }
}