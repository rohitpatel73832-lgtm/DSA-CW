class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            adj.get(u).add(v);
            adj.get(v).add(-u);
        }
        boolean vis[]=new boolean[n];
        int ans=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()){

    int node = q.poll();

    for(int curr : adj.get(node)){

        int nei = Math.abs(curr);

        if(!vis[nei]){

            vis[nei] = true;
            q.offer(nei);

            if(curr > 0){
                ans++;
            }
        }
    }
}
        return ans;
    }
}