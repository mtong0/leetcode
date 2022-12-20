package src.algorithm.temp;
public class MaximumNumberOfAchievableTransferRequests {
    int[][] requests;
    int n;
    int max = 0;
    public int maximumRequests(int n, int[][] requests) {
        this.n = requests.length;
        int[] degree = new int[n];
        this.requests = requests;
        dp(0, 0, degree);
        return max;
    }

    public void dp(int i, int bitmask, int[] degree) {
        if (i == requests.length) {
            return;
        }
        if (i > max && testDegree(degree)) {
            max = i;
        }
        for (int j = 0; j < n; j++) {
            if (((1<<j) & bitmask) == 0) {
                degree[requests[j][0]] -= 1;
                degree[requests[j][1]] += 1;
                dp(i+1, bitmask | (1<<j), degree);
                degree[requests[j][0]] += 1;
                degree[requests[j][1]] -= 1;
            }
        }
    }

    public boolean testDegree(int[] degree) {
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] != 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] request = {{0,0},{1,1},{0,0},{2,0},{2,2},{1,1},{2,1},{0,1},{0,1}};
        new MaximumNumberOfAchievableTransferRequests().maximumRequests(n, request);
    }
}
