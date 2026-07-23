class Solution {
    public void bfs(int i, int[][] adj,int n,boolean[] vis){
        Queue<Integer> q= new LinkedList<>();
        q.add(i);
        vis[i]=true;
        while(q.size()>0){
            int front=q.remove();
            for(int j=0;j<n; j++){
                if(  vis[j]==false && adj[front][j]==1){
                    q.add(j);
                    vis[j]=true;
                }
            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int n= adj.length;
        boolean[] vis= new boolean[n];
        int ans=0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                bfs(i,adj,n,vis);
                ans++;
            }
        }
        return ans;
        
    }
}
