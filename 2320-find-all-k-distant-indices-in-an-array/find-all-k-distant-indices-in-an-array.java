class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n]; // to avoid duplicates

        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                int j = i;

                if (j - k < 0)
                    start = 0;
                else
                    start = j - k;

                if (j + k >= n)
                    end = n - 1;
                else
                    end = j + k;

                for (int x = start; x <= end; x++) {
                    if (!visited[x]) {
                        ans.add(x);
                        visited[x] = true;
                    }
                }
            }
        }

        return ans;
    }
}