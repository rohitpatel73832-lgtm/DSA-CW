/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
//     public boolean isContains(TreeNode root,TreeNode node){
//         if(root == null) return false;
//         if(root==node) return true;
//         return isContains(root.left,node) || isContains(root.right,node);
//     }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(p==root|| q==root) return root;
//         if(p==q) return p;
//         boolean leftp= isContains(root.left,p);
//         boolean rightq=isContains(root.right,q);
//         if((leftp && rightq) || (!leftp && !rightq)) return root;
//         if(leftp && !rightq) return lowestCommonAncestor(root.left,p,q);
//         if(!leftp && rightq) return lowestCommonAncestor(root.right,p,q);
//         return null;
//     }
// }

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}