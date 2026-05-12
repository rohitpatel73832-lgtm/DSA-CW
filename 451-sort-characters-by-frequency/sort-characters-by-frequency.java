class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> mp = new HashMap<>();
    
        for(int i=0; i< s.length(); i++){
            char ch= s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        List<Character> list = new ArrayList<>(mp.keySet());
        list.sort((a, b) -> mp.get(b) - mp.get(a));
        StringBuilder ans = new StringBuilder();
        for (char ch : list) {
            int freq = mp.get(ch);

            while (freq != 0) {
                ans.append(ch);
                freq--;
            }
        }
        return ans.toString();

    }
}