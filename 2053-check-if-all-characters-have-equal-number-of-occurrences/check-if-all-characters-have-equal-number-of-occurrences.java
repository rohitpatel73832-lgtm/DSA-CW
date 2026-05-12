class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> mp= new HashMap<>();
        int freq=-1;
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch,0)+1);
        }
        for(int count: mp.values()){
            if(freq==-1){
                freq=count;
            }else if(freq!=count){
                return false;
            }
        }
        return true;

    }
}