
class Solution {
    public void helper(TreeNode root, StringBuilder s1){
        if(root==null) {
            return ;
            
        }
        if(root.left==null && root.right==null){
             s1.append(root.val).append(",");
             return;
            
        }
        helper(root.left,s1);
        helper(root.right,s1);
        
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        //if(root1==null && root2==null) return true;
        StringBuilder s1= new StringBuilder();
        StringBuilder s2= new StringBuilder();
        helper(root1,s1);
        helper(root2,s2);
        return s1.toString().equals(s2.toString());
    }
}