package src.algorithm.temp;

public class No135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        for (int i = 0; i < n-1; i++) {
            if (ratings[i+1] > ratings[i]) {
                candies[i+1] = candies[i] + 1;
            }
        }

        for (int i = n-1; i > 0; i--) {
            if (ratings[i-1] > ratings[i]) {
                candies[i-1] = candies[i] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candies[i];
        }

        return sum;
    }

}
