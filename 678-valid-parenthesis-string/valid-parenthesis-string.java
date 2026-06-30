// import java.util.*;

// class Solution {
//     public boolean checkValidString(String s) {

//         Stack<Integer> open = new Stack<>();
//         Stack<Integer> star = new Stack<>();

//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);

//             if (ch == '(') {
//                 open.push(i);
//             }
//             else if (ch == '*') {
//                 star.push(i);
//             }
//             else { // ch == ')'

//                 if (!open.isEmpty()) {
//                     open.pop();
//                 }
//                 else if (!star.isEmpty()) {
//                     star.pop();
//                 }
//                 else {
//                     return false;
//                 }
//             }
//         }

//         while (!open.isEmpty() && !star.isEmpty()) {

//             if (open.peek() < star.peek()) {
//                 open.pop();
//                 star.pop();
//             } else {
//                 return false;
//             }
//         }

//         return open.isEmpty();
//     }
// }


class Solution {

    class Pair {
        char ch;
        int index;

        Pair(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }

    public boolean checkValidString(String s) {

        Stack<Pair> open = new Stack<>();
        Stack<Pair> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                open.push(new Pair(ch, i));
            }
            else if (ch == '*') {
                star.push(new Pair(ch, i));
            }
            else { // ch == ')'

                if (!open.isEmpty()) {
                    open.pop();
                }
                else if (!star.isEmpty()) {
                    star.pop();
                }
                else {
                    return false;
                }
            }
        }

        while (!open.isEmpty() && !star.isEmpty()) {

            Pair openPair = open.peek();
            Pair starPair = star.peek();

            if (openPair.index < starPair.index) {
                open.pop();
                star.pop();
            } else {
                return false;
            }
        }

        return open.isEmpty();
    }
}