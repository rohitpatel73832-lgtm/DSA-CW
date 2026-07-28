class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int maxScore = 0;
        int i = 0;
        int j = tokens.length - 1;
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i];
                score++;
                maxScore = Math.max(maxScore, score);
                i++;
            }
            else if (score > 0) {
                power += tokens[j];
                score--;
                j--;
            }
            else {
                return maxScore;
            }
        }

        return maxScore;
    }
}