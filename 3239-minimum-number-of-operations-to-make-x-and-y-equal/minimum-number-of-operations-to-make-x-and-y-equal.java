class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();

        q.add(x);
        vis.add(x);

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int cur = q.remove();

                if (cur == y) return steps;

                if (cur % 11 == 0) {
                    int nxt = cur / 11;
                    if (!vis.contains(nxt)) {
                        vis.add(nxt);
                        q.add(nxt);
                    }
                }

                if (cur % 5 == 0) {
                    int nxt = cur / 5;
                    if (!vis.contains(nxt)) {
                        vis.add(nxt);
                        q.add(nxt);
                    }
                }

                if (cur + 1 <= 10000 && !vis.contains(cur + 1)) {
                    vis.add(cur + 1);
                    q.add(cur + 1);
                }

                if (cur - 1 >= 0 && !vis.contains(cur - 1)) {
                    vis.add(cur - 1);
                    q.add(cur - 1);
                }
            }

            steps++;
        }

        return -1;
    }
}