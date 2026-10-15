

class Solution {

    public void helper(int idx, String num, int target, String s,List<String> ans, long currValue, long prev) {
                       

        if (idx == num.length()) {
            if (currValue == target) {
                ans.add(s);
            }
            return;
        }

        for (int i = idx; i < num.length(); i++) {

            // Avoid numbers with leading zeros
            if (i > idx && num.charAt(idx) == '0') {
                break;
            }

            String str = num.substring(idx, i + 1);
            long val = Long.parseLong(str);

            if (idx == 0) {
                helper(i + 1, num, target, str, ans, val, val);
            } else {
                // Addition
                helper(i + 1, num, target, s + "+" + str,
                       ans, currValue + val, val);

                // Subtraction
                helper(i + 1, num, target, s + "-" + str,
                       ans, currValue - val, -val);

                // Multiplication
                helper(i + 1, num, target, s + "*" + str,
                       ans, currValue - prev + prev * val,
                       prev * val);
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();

        helper(0, num, target, "", ans, 0, 0);

        return ans;
    }
}