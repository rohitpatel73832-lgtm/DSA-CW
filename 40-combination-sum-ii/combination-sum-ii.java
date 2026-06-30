class Solution {

    public void helper(int i, int[] candidates, int target,List<Integer> list, List<List<Integer>> ans) {
                
        if (target == 0) {
            // ans.add(new ArrayList<>(list));
            ans.add(list);
            return;
        }
        if (i == candidates.length || target < 0)
            return;

        if (candidates[i] <= target) {
            List<Integer> newList = new ArrayList<>(list);
            //list.add(candidates[i]);
            newList.add(candidates[i]);
            helper(i+1, candidates, target - candidates[i], newList, ans);
            //list.remove(list.size() - 1); 
        }
        while (i + 1 < candidates.length &&
               candidates[i] == candidates[i + 1]) {
            i++;
        }

        helper(i + 1, candidates, target, list, ans);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        helper(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }
}