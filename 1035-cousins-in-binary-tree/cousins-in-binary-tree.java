class Solution {

    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDepth = -1;
    int yDepth = -1;

    public void dfs(TreeNode root,
                    TreeNode parent,
                    int level,
                    int x,
                    int y){

        if(root == null) return;

        if(root.val == x){
            xDepth = level;
            xParent = parent;
        }

        if(root.val == y){
            yDepth = level;
            yParent = parent;
        }

        dfs(root.left, root, level + 1, x, y);
        dfs(root.right, root, level + 1, x, y);
    }

    public boolean isCousins(TreeNode root,
                              int x,
                              int y) {

        dfs(root, null, 0, x, y);

        return xDepth == yDepth
                && xParent != yParent;
    }
}