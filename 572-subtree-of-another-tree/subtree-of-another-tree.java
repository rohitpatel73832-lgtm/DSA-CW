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

    public boolean isSame(TreeNode root, TreeNode subRoot) {

        // Both null
        if(root == null && subRoot == null) {
            return true;
        }

        // One null
        if(root == null || subRoot == null) {
            return false;
        }

        // Value different
        if(root.val != subRoot.val) {
            return false;
        }

        // Check left and right
        return isSame(root.left, subRoot.left) &&
               isSame(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // Base case
        if(root == null) {
            return false;
        }

        // If same tree found
        if(isSame(root, subRoot)) {
            return true;
        }

        // Search left or right
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }
}