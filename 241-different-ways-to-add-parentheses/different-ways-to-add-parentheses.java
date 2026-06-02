class Solution {

    public List<Integer> diffWaysToCompute(String expression) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {

                String leftPart = expression.substring(0, i);
                String rightPart = expression.substring(i + 1);

                List<Integer> left = diffWaysToCompute(leftPart);
                List<Integer> right = diffWaysToCompute(rightPart);

                for (int l : left) {
                    for (int r : right) {

                        if (ch == '+') {
                            ans.add(l + r);
                        } else if (ch == '-') {
                            ans.add(l - r);
                        } else {
                            ans.add(l * r);
                        }
                    }
                }
            }
        }

        // Base case: expression is only a number
        if (ans.size() == 0) {
            ans.add(Integer.parseInt(expression));
        }

        return ans;
    }
}