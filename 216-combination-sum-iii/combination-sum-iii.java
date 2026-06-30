class Solution {
    public void helper(int i, int k, int n,List<Integer> list, int sum,List<List<Integer>> ans) {
                
        if (list.size() == k) {
            if (sum == n) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if (i > 9 || sum > n)
            return;
        

        
           list.add(i);
            helper(i+1, k,n,list,sum+i,ans);
            list.remove(list.size() - 1);
        

        helper(i+1, k,n,list,sum,ans);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int sum=0;
        List<Integer> list= new ArrayList<>();
        helper(1, k, n,list,sum, ans);
        return ans;
    }
}