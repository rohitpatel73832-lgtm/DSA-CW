class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];
        int k = 0;

        for (int i = 0; i < n1; i++) {
            boolean found = false;

            for (int j = 0; j < n2; j++) {
                if (nums1[i] == nums2[j]) {

                    for (int p = j + 1; p < n2; p++) {
                        if (nums2[p] > nums1[i]) {
                            ans[k] = nums2[p];
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        ans[k] = -1;
                    }

                    k++;
                    break;
                }
            }
        }

        return ans;
    }
}