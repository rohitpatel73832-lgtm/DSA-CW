class Solution {
    public int myAtoi(String s) {

        String p = s.trim();

        if (p.length() == 0)
            return 0;

        StringBuilder sb = new StringBuilder();

        int i = 0;

        // Handle sign
        if (p.charAt(i) == '+' || p.charAt(i) == '-') {
            sb.append(p.charAt(i));
            i++;
        }

        // Read consecutive digits only
        while (i < p.length() && Character.isDigit(p.charAt(i))) {
            sb.append(p.charAt(i));
            i++;
        }

        // Cases like "+" or "-"
        if (sb.length() == 0 ||
            sb.toString().equals("+") ||
            sb.toString().equals("-")) {
            return 0;
        }

        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return sb.charAt(0) == '-'
                    ? Integer.MIN_VALUE
                    : Integer.MAX_VALUE;
        }
    }
}