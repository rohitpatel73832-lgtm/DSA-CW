// class Solution {
//     public TreeNode insertIntoBST(TreeNode root, int val) {
//         if(root==null) return new TreeNode(val);
//         if(root.val>val){
//             if(root.left==null) root.left= new TreeNode(val);
//             else insertIntoBST(root.left,val);
//         }else{
//             if(root.right==null) root.right= new TreeNode(val);
//             else insertIntoBST(root.right,val);
//         }
//         return root;
//     }
    
    
    
//     public void inorder(TreeNode root, List<Integer> arr){
//         if(root==null) return ;
//         inorder(root.left,arr);
//         arr.add(root.val);
//         inorder(root.right,arr);
//     }
//     public TreeNode convertBST(TreeNode root) {
//         if(root==null) return null;
//         ArrayList<Integer> arr = new ArrayList<>();
//         inorder(root,arr);
//         int n = arr.size();
//         int[] ans = new int[n];
//         int sum=0;
//         for(int i=n-1; i>=0;i--){
//             sum=sum+arr.get(i);
//             ans[i]= sum;
//         }
//          TreeNode newRoot= new TreeNode(ans[n-1]);
//        for(int i=n-2; i>=0;i--){
//         newRoot=insertIntoBST(newRoot,ans[i]);
//        }
//        return newRoot;
//     }
// }

class Solution{
    static int sum=0;
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.right);
        root.val=root.val+sum;
        sum=root.val;
        helper(root.left);
    }
    public TreeNode convertBST(TreeNode root){
        sum=0;
        helper(root);
        return root;
    }
}