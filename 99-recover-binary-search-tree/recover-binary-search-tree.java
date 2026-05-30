
class Solution {
    static int i=0;
    // public TreeNode makeBst(ArrayList<Integer> arr,int lo,int hi){
    //     if(lo>hi) return null;
    //     int mid=(lo+hi)/2;
    //     TreeNode root = new TreeNode(arr.get(mid));
    //     root.left=makeBst(arr,lo,mid-1);
    //     root.right=makeBst(arr,mid+1,hi);
    //     return root;
    // }
    public void inorder(TreeNode root,ArrayList<Integer> arr){
        if(root==null) return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
        public void fixTree(TreeNode root, ArrayList<Integer> arr) {
        if(root == null) return;

        fixTree(root.left, arr);

        root.val = arr.get(i);
        i++;

        fixTree(root.right, arr);
    }

    public void recoverTree(TreeNode root) {
        i=0;

        ArrayList<Integer> arr = new ArrayList<>();

        
        inorder(root, arr);

        
        Collections.sort(arr);

        
        int[] index = {0};
        

        fixTree(root, arr);
    }
}
