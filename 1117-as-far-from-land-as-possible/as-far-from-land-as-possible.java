class Solution {
    public int maxDistance(int[][] grid) {

        int n = grid.length;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j});
                }
            }
        }

        if(q.size()==0 || q.size()==n*n){
            return -1;
        }

        int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};

        int level=-1;

        while(!q.isEmpty()){

            int size=q.size();

            while(size-- > 0){

                int[] cur=q.remove();

                int r=cur[0];
                int c=cur[1];

                for(int[] d:dir){

                    int nr=r+d[0];
                    int nc=c+d[1];

                    if(nr>=0 && nr<n && nc>=0 && nc<n
                       && grid[nr][nc]==0){

                        grid[nr][nc]=1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }

            level++;
        }

        return level;
    }
}