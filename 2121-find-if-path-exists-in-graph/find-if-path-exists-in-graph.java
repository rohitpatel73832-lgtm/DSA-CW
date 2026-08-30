// class Solution {
//     public void bfs(int st,List<List<Integer>> ans, boolean[] vis,int dest){
//         Queue<Integer> q= new LinkedList<>();
//         q.add(st);
//         vis[st]=true;
//         while(q.size()>0){
//             int front = q.remove();
//             for(int ele: ans.get(front)){
                
//                 if(vis[ele]==false){
//                     q.add(ele);
//                     vis[ele]=true;
//                 }
//             }
//         }
//     }
//     public boolean validPath(int n, int[][] edges, int s, int dest) {
//         int m=edges.length;
//         List<List<Integer>> ans= new ArrayList<>();
//         boolean[] vis= new boolean[n];
//         for(int i=0; i<n; i++){
//             ans.add(new ArrayList<>());
//         }
//         for(int i=0; i<m; i++){
//             int a=edges[i][0];
//             int b=edges[i][1];
//             ans.get(a).add(b);
//             ans.get(b).add(a);
//         }

//         for(int i=0; i<n; i++){
//             if(!vis[i]){
//                 bfs(s,ans,vis,dest);
//             }
//         }
//         return vis[dest];
//     }
// }

class Solution {
    public void bfs(int source, int destination, List<List<Integer>> adj, boolean[] vis){
        Queue<Integer> q= new LinkedList<>();
        q.add(source);
        vis[source]=true;

        while(q.size()>0){
            int front= q.remove();

            for(int ele: adj.get(front)){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele]=true;
                }
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj= new ArrayList<>();
        int m=edges.length;
        boolean[] vis= new boolean[n];
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int u=edges[i][0];
            int v=edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        bfs(source,destination,adj,vis);

        return vis[destination];
    }
}