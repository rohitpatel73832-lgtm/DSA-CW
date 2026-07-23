class Solution {
    public void bfs(int st,List<List<Integer>> ans, boolean[] vis){
        Queue<Integer> q= new LinkedList<>();
        q.add(st);
        vis[st]=true;
        while(q.size()>0){
            int front = q.remove();
            for(int ele: ans.get(front)){
                if(vis[ele]==false){
                    q.add(ele);
                    vis[ele]=true;
                }
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int s, int dest) {
        int m=edges.length;
        List<List<Integer>> ans= new ArrayList<>();
        boolean[] vis= new boolean[n];
        for(int i=0; i<n; i++){
            ans.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int a=edges[i][0];
            int b=edges[i][1];
            ans.get(a).add(b);
            ans.get(b).add(a);
        }

        for(int i=0; i<n; i++){
            if(!vis[i]){
                bfs(s,ans,vis);
            }
        }
        return vis[dest];
    }
}