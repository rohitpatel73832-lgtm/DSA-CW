class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int i=0;
        int n=plants.length;
        int steps=0;
        int cap=capacity;
        while(i<n){
            if(plants[i]>cap){
                steps+=i*2;
                cap=capacity;

            }
            cap-=plants[i];
        steps++;
        i++;
        }
        return steps;
        
    }
}