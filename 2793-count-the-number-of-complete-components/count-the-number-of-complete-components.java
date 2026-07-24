class Solution {
    public boolean bfs(int src, List<List<Integer>>list, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;

        int nodes = 0;
        int degreeSum = 0;

        while (!q.isEmpty()) {
            int curr = q.remove();
            nodes++;
            degreeSum += list.get(curr).size();

            for (int ele : list.get(curr)) {
                if (!vis[ele]) {
                    vis[ele] = true;
                    q.add(ele);
                }
            }
        }

        return degreeSum == nodes * (nodes - 1);
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> list= new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int a=edges[i][0];
            int b=edges[i][1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        boolean[] vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (bfs(i,list, vis)==true) {
                    ans++;
                }
            }
        }
        return ans;
    }
}