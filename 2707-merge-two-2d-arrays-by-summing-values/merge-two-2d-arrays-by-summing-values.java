class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0, j = 0;
        List<List<Integer>> ans = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            int id1 = nums1[i][0], id2 = nums2[j][0];

            if (id1 == id2) {
                List<Integer> temp = new ArrayList<>();
                temp.add(id1);
                temp.add(nums1[i][1] + nums2[j][1]);
                ans.add(temp);
                i++; 
                j++;
            } 
            else if (id1 < id2) {
                List<Integer> temp = new ArrayList<>();
                temp.add(id1);
                temp.add(nums1[i][1]);
                ans.add(temp);
                i++;
            } 
            else { // id2 < id1
                List<Integer> temp = new ArrayList<>();
                temp.add(id2);
                temp.add(nums2[j][1]);
                ans.add(temp);
                j++;
            }
        }

        // Add remaining elements of nums1
        while (i < nums1.length) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[i][0]);
            temp.add(nums1[i][1]);
            ans.add(temp);
            i++;
        }

        // Add remaining elements of nums2
        while (j < nums2.length) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums2[j][0]);
            temp.add(nums2[j][1]);
            ans.add(temp);
            j++;
        }
        int[][] arr = new int[ans.size()][];
         

        for (int r = 0; r < ans.size(); r++) {
            arr[r] = new int[ans.get(r).size()];
            for (int c = 0; c < ans.get(r).size(); c++) {
                arr[r][c] = ans.get(r).get(c);
            }
        }

        return arr;



        
    }
}