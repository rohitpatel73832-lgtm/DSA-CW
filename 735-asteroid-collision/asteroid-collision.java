class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            int a = asteroids[i];
            boolean alive = true;

            while (st.size() > 0 && a < 0 && st.peek() > 0) {
                if (st.peek() < -a) {
                    st.pop();
                } 
                else if (st.peek() == -a) {
                    st.pop();
                    alive = false;
                    break;
                } 
                else {//st.peek()>-a
                    alive = false;
                    break;
                }
            }

            if (alive) {
                st.push(a);
            }
        }

        int[] result = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
    }
}