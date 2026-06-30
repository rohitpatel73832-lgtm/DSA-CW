class Solution {

    public void helper(int i, int[] candidates, int target,List<Integer> list, List<List<Integer>> ans) {
                
        if (target == 0) {
            // ans.add(new ArrayList<>(list));
            ans.add(list);
            return;
        }
        if (i == candidates.length) {
            return;
        }
        if (candidates[i] <= target) {
            List<Integer> newList = new ArrayList<>(list);
            //list.add(candidates[i]);
            newList.add(candidates[i]);
            helper(i, candidates, target - candidates[i], newList, ans);
            //list.remove(list.size() - 1); 
        }

        helper(i + 1, candidates, target, list, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        helper(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }
}