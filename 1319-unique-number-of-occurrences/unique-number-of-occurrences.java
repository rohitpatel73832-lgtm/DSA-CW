class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int ele : arr) {
            mp.put(ele, mp.getOrDefault(ele, 0) + 1);
        }
        for (int freq : mp.values()) {
            if (set.contains(freq)) {
                return false;
            }
            set.add(freq);
        }

        return true;
    }
}