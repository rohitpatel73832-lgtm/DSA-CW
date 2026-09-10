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

        // int left = getSum(root.left);
        // int right = getSum(root.right);

        // return root.val + left + right;

        int left=root.val+getSum(root.left);
        int right=root.val+getSum(root.right);
        int ans=left+right;
        return ans-root.val;
    }

    public int getCount(TreeNode root) {
        if (root == null) return 0;

        // int left = getCount(root.left);
        // int right = getCount(root.right);

        // return 1 + left + right;

        int left=1+getCount(root.left);
        int right=1+getCount(root.right);
        return left+right-1;
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