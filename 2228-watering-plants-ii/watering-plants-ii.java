class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int i=0; 
        int j= plants.length-1;
        int a= capacityA;
        int b=capacityB;
        int refill=0;
        while(i<j){
            if(a<plants[i]){
                refill++;
                a=capacityA;
            }
            a-=plants[i];

            if(b<plants[j]){
                refill++;
                b=capacityB;
            }
            b-=plants[j];
            i++;
            j--;
        }
        if(i==j){
            if(Math.max(a,b)<plants[i]){
                refill++;
            }
        }
        return refill;
    }
}