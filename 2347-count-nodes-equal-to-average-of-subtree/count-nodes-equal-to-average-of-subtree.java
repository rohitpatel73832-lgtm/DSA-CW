/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public int getSum(TreeNode root) {
        if (root == null) return 0;

        int left = getSum(root.left);
        int right = getSum(root.right);

        return root.val + left + right;
    }

    public int getCount(TreeNode root) {
        if (root == null) return 0;

        int left = getCount(root.left);
        int right = getCount(root.right);

        return 1 + left + right;
    }

    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;

        int ans = 0;

        int sum = getSum(root);
        int count = getCount(root);

        if (sum / count == root.val) {
            ans++;
        }

        ans += averageOfSubtree(root.left);
        ans += averageOfSubtree(root.right);

        return ans;
    }
}