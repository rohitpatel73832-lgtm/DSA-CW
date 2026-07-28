// class Solution {
//     public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

//         HashSet<Integer> h1 = new HashSet<>(Set.of(2, 3, 4, 5));
//         HashSet<Integer> h2 = new HashSet<>(Set.of(4, 5, 6, 7));
//         HashSet<Integer> h3 = new HashSet<>(Set.of(6, 7, 8, 9));

//         int ans = 0;

//         List<List<Integer>> adj = new ArrayList<>();

//         // Create adjacency list for all rows
//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         // Store reserved seats row-wise
//         for (int i = 0; i < reservedSeats.length; i++) {
//             int row = reservedSeats[i][0];
//             int seat = reservedSeats[i][1];
//             adj.get(row).add(seat);
//         }

//         // Check every row
//         for (int row = 1; row <= n; row++) {

//             if (adj.get(row).size() == 0) {
//                 ans += 2;
//                 continue;
//             }

//             boolean left = true;
//             boolean middle = true;
//             boolean right = true;

//             for (int seat : adj.get(row)) {

//                 if (h1.contains(seat))
//                     left = false;

//                 if (h2.contains(seat))
//                     middle = false;

//                 if (h3.contains(seat))
//                     right = false;
//             }

//             if (left && right)
//                 ans += 2;
//             else if (left || middle || right)
//                 ans += 1;
//         }

//         return ans;
//     }
// }

import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Store reserved seats row-wise
        for (int[] seat : reservedSeats) {
            map.putIfAbsent(seat[0], new ArrayList<>());
            map.get(seat[0]).add(seat[1]);
        }

        int ans = 2 * n;

        for (int row : map.keySet()) {

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            for (int seat : map.get(row)) {

                if (seat >= 2 && seat <= 5)
                    left = false;

                if (seat >= 4 && seat <= 7)
                    middle = false;

                if (seat >= 6 && seat <= 9)
                    right = false;
            }

            if (left && right) {
                // Still 2 families; no adjustment needed.
            } else if (left || middle || right) {
                ans -= 1;
            } else {
                ans -= 2;
            }
        }

        return ans;
    }
}