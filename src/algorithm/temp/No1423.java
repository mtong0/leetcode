package src.algorithm.temp;
class No1423 {
    public int maxScore(int[] cardPoints, int k) {
        int res = 0;
        int s = 0;
        for (int i = cardPoints.length-k; i < cardPoints.length; i++) {
            s += cardPoints[i];
        }
        res = s;


        for (int i = 0; i < k; i++) {
            s -= cardPoints[cardPoints.length-k+i];
            s += cardPoints[i];
            res = Math.max(res, s);
        }
        return res;
    }
}