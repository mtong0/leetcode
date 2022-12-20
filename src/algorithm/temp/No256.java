package src.algorithm.temp;
class No256 {
    int[][] costsFrom;
    int[][] costs;
    int n;
    public int minCost(int[][] costs) {
        this.costs = costs;
        n = costs.length;
        costsFrom = new int[n][3];
        
        int res = 0;
        for(int i = 0; i < 3; i++) {
            res = Math.min(res, paintFromWithColor(0, i));
        }
        return res;
    }

    public int paintFromWithColor(int i, int j) {
        if(i == n) {
            return 0;
        }

        if(j == 0) {
            costsFrom[i][j] = 
                costs[i][j] 
                + Math.min(
                    costsFrom[i+1][1] == 0 ? paintFromWithColor(i+1, 1):costsFrom[i+1][1], 
                    costsFrom[i+1][2] == 0 ? paintFromWithColor(i+1, 2):costsFrom[i+1][2]
                );
        } else if (j == 1) {
            costsFrom[i][j] = 
                costs[i][j] 
                + Math.min(
                    costsFrom[i+1][0] == 0 ? paintFromWithColor(i+1, 0):costsFrom[i+1][0], 
                    costsFrom[i+1][2] == 0 ? paintFromWithColor(i+1, 2):costsFrom[i+1][2]
                );
        } else if (j == 2) {
            costsFrom[i][j] = 
                costs[i][j] 
                + Math.min(
                    costsFrom[i+1][0] == 0 ? paintFromWithColor(i+1, 0):costsFrom[i+1][0], 
                    costsFrom[i+1][1] == 0 ? paintFromWithColor(i+1, 1):costsFrom[i+1][1]
                );
        }
        return costsFrom[i][j];
    }
}