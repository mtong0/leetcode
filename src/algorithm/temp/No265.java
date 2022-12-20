package src.algorithm.temp;
public class No265 {
    int[][] costsFrom;
    int[][] costs;
    int n;
    int k;
    public int minCost(int[][] costs) {
        this.costs = costs;
        n = costs.length;
        k = costs[0].length;
        costsFrom = new int[n][k];
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            res = Math.min(res, paintFromWithColor(0, i));
        }
        return res;
    }

    public int paintFromWithColor(int i, int j) {
        if(i == n-1) {
            return costs[i][j];
        }

        int next = Integer.MAX_VALUE;
        for (int a = 0; a < k && a != k; a++) {
            next = Math.min(
                costsFrom[i+1][a] == 0 ? paintFromWithColor(i+1, a):costsFrom[i+1][a], 
                next
            );
        }
        costsFrom[i][j] = costs[i][j] + next;
    
        return costsFrom[i][j];
    }
}
