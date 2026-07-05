class Solution {

    public void helper(TreeNode root, int targetSum,List<Integer> list,List<List<Integer>> ans) {

        if (root == null)
            return;
            
        list.add(root.val);
        if (root.left == null && root.right == null) {

            if (targetSum == root.val) {
                ans.add(new ArrayList<>(list));
            }

            list.remove(list.size() - 1);
            return;
        }

        helper(root.left, targetSum - root.val, list, ans);
        helper(root.right, targetSum - root.val, list, ans);

        // Backtrack
        list.remove(list.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(root, targetSum, list, ans);

        return ans;
    }
}