
class Solution {

    public List<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if(root == null) return arr;

        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);

        return arr;
    }

    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();

        inorder(root, arr);

        TreeNode newRoot = new TreeNode(arr.get(0));
        TreeNode curr = newRoot;

        for(int i = 1; i < arr.size(); i++) {
            curr.right = new TreeNode(arr.get(i));
            curr = curr.right;
        }

        return newRoot;
    }
}