class Solution {

    public void helper(Node root) {

        if (root == null)
            return;

        if (root.left == null || root.right == null)
            return;

        // Connect left child to right child
        root.left.next = root.right;

        // Connect right child to the next subtree
        if (root.next != null) {
            root.right.next = root.next.left;
        }

        helper(root.left);
        helper(root.right);
    }

    public Node connect(Node root) {

        if (root == null)
            return null;

        root.next = null;

        helper(root);

        return root;
    }
}