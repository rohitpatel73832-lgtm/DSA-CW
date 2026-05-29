class Solution {
    public int traverse(TreeNode root, int low, int high) {
        if(root == null) return 0;

        int sum = 0;

        if(root.val >= low && root.val <= high) {
            sum += root.val;
        }

        int left = traverse(root.left, low, high);
        int right = traverse(root.right, low, high);

        return sum+left+right;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        return traverse(root, low, high);
    }
}