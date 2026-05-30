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
    public void inorder(TreeNode root,ArrayList<Integer> arr){
        if(root==null) return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
    // public int height(TreeNode root){
    //     if(root==null) return 0;
    //     return 1+ Math.max(height(root.left),height(root.right));
    // }
    public TreeNode helper(ArrayList<Integer> arr, int lo, int hi) {
        if(lo > hi) return null;

        int mid = (lo + hi) / 2;

        TreeNode root = new TreeNode(arr.get(mid));

        root.left = helper(arr, lo, mid - 1);
        root.right = helper(arr, mid + 1, hi);

        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr= new ArrayList<>();
        
        inorder(root,arr);
        int n = arr.size();
        return helper(arr,0,n-1);
        // int l=height(root.left);
        // int r=height(root.right);
        // int d=Math.abs(l-r);
        // if(d>1){

        // }
        
    }
}