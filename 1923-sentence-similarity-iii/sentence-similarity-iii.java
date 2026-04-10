class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        String[] a = s1.split(" ");
        String[] b = s2.split(" ");

        int p1 = 0;
        int p2 = 0;
        int ss1 = a.length - 1;
        int ss2 = b.length - 1;

        // Match prefix
        while (p1 <= ss1 && p2 <= ss2 && a[p1].equals(b[p2])) {
            p1++;
            p2++;
        }

        // Match suffix
        while (p1 <= ss1 && p2 <= ss2 && a[ss1].equals(b[ss2])) {
            ss1--;
            ss2--;
        }

        // If one sentence has only middle words left → similar
        return p1 > ss1 || p2 > ss2;
    }
}