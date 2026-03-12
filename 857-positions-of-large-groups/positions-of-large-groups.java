class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();

        int sum=1,i;

        for(i =1; i<s.length(); i++)
        {
            if(s.charAt(i-1) == s.charAt(i) )
                sum++;
            else
            {
                if(sum>=3)
                {
                    List<Integer> l2 = new ArrayList<Integer>();
                    l2.add(i-sum);
                    l2.add(i-1);
                    l.add(l2);
                }
                sum=1;
            }
        }
        if(sum>=3)
        {
            List<Integer> l2 = new ArrayList<Integer>();
            l2.add(i-sum);
            l2.add(i-1);
            l.add(l2);
        }
        return l;

    }
}