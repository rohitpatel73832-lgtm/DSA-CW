class Solution {

    public void helper(TreeNode root,int level,List<Integer> ans){

        if(root == null) return;

        // first node at this level
        if(level == ans.size()){
            ans.add(root.val);
        }

        // visit right first
        helper(root.right, level + 1, ans);
        helper(root.left, level + 1, ans);
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans =
                new ArrayList<>();

        helper(root, 0, ans);

        return ans;
    }
}