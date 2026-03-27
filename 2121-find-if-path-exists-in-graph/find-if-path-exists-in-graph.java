class Solution {

    public void bfs(int st,List<List<Integer>> adj,boolean[] vis){
        Queue<Integer> q=new LinkedList<>();
        q.add(st);
        vis[st]=true;
        while(q.size()>0){
            int front=q.remove();
            for(int ele:adj.get(front)){
                if(vis[ele]==false){
                    vis[ele]=true;
                    q.add(ele);
                    
                }
            }
            
        }
    }
    public boolean validPath(int n, int[][] edges, int st, int end) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0; i<n;i++){
            ArrayList<Integer> in=new ArrayList<>();
            adj.add(in);
        }
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] vis=new boolean[n];
        vis[st]=true;
        bfs(st,adj,vis);
        return vis[end];
    }
}
