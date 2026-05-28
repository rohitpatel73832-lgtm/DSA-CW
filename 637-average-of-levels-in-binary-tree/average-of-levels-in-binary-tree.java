
class Solution {

    public int height(TreeNode root){
        if(root == null) return 0;

        return 1 + Math.max(height(root.left),
                             height(root.right));
    }

    public void traversal(TreeNode root,
                           int n,
                           double[] data){

        if(root == null) return;

        if(n == 1){
            data[0] += root.val; // sum
            data[1]++;           // count
            return;
        }

        traversal(root.left, n - 1, data);
        traversal(root.right, n - 1, data);
    }

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> ans = new ArrayList<>();

        int level = height(root);

        for(int i = 1; i <= level; i++){

            double[] data = new double[2];
            // data[0] = sum
            // data[1] = count

            traversal(root, i, data);

            ans.add(data[0] / data[1]);
        }

        return ans;
    }
}