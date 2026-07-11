
class Solution {
public void inorder(TreeNode root,List<Integer> arr){
    if(root==null) return;
    inorder(root.left,arr);
    arr.add(root.val);
    inorder(root.right,arr);
}
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> arr= new ArrayList<>();
        inorder(root1,arr);
        inorder(root2,arr);
        Collections.sort(arr);
        return arr;
    }
}