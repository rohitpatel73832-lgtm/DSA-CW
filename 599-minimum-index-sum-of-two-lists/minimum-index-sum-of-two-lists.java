class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> mp1 = new HashMap<>();
        
        int idxSum= Integer.MAX_VALUE;
        
        List<String> temp = new ArrayList<>();
        for(int i=0; i<list1.length; i++){
            mp1.put(list1[i],i);
        }
        for(int i=0; i<list2.length; i++){
            if(mp1.containsKey(list2[i])){
                int idx= mp1.get(list2[i]);
                if(idx+i<idxSum){
                    temp.clear();
                    temp.add(list2[i]);
                    idxSum=idx+i;
                    
                }
                    else if (idx + i == idxSum) {
                    temp.add(list2[i]);        
                
                }

            }
        }
        return temp.toArray(new String[0]);
    }
}