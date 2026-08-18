class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp= new HashMap<>();
        ArrayList<List<String>> arr =new ArrayList<>();
        for(String str:strs){
            char[] c=str.toCharArray();
            Arrays.sort(c);
            String key= new String(c);
            if(!mp.containsKey(key)){
                mp.put(key,new ArrayList<String>());
            }
            mp.get(key).add(str);
        }
        for(Map.Entry<String,List<String>> e: mp.entrySet()){
            arr.add(e.getValue());

        }
        return arr;
    }
}