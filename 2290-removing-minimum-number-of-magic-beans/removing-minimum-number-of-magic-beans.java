

class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long total = 0;

        for (int b : beans) total += b;

        long min = Long.MAX_VALUE;
        int n = beans.length;

        for (int i = 0; i < n; i++) {
            long target = beans[i];
            long keep = target * (n - i); 
            long removed = total - keep;
            min = Math.min(min, removed);
        }

        return min;
    }
}