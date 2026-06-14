class Solution {

    public boolean helper(int i, int[] arr, boolean[] vis) {

        int n = arr.length;

        // Out of bounds
        if (i < 0 || i >= n) {
            return false;
        }

        // Already visited
        if (vis[i]) {
            return false;
        }

        // Found a zero
        if (arr[i] == 0) {
            return true;
        }

        vis[i] = true;

        int right = i + arr[i];
        int left = i - arr[i];

        return helper(right, arr, vis) || helper(left, arr, vis);
    }

    public boolean canReach(int[] arr, int start) {

        boolean[] vis = new boolean[arr.length];

        return helper(start, arr, vis);
    }
}