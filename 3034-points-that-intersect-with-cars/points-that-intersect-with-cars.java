class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        HashSet<Integer> st = new HashSet<>();
        for (List<Integer> e : nums) {
            int a = e.get(0);
            int b = e.get(1);
            for(int i=a; i<=b; i++){
                if(!st.contains(i)){
                    st.add(i);
                }
            }
        }
        return st.size();
    }
}