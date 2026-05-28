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
    public int height(TreeNode root){
        if(root==null) return 0;
        //if(root.left==null && root.right==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public void traversal(TreeNode root,int n,List<Integer> arr){
        if(root==null) return;
        if(n==1){
            arr.add(root.val);
            return;
        }
        traversal(root.left,n-1,arr);
        traversal(root.right,n-1,arr);
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> ans= new ArrayList<>();
        int level=height(root);
        for(int i=level; i>=1; i--){
            List<Integer> arr = new ArrayList<>();
            traversal(root,i,arr);
            ans.add(arr);
        }
        return ans;
    }
}