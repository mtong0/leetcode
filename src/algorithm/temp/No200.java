package src.algorithm.temp;

import java.util.LinkedList;

public class No200 {
    int m;
    int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int[][] visit = new int[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visit[i][j] != 1) {
                    count += 1;
                    markIsland(i, j, grid, visit);
                }
            }
        }
        return count;
    }

    public void markIsland(int i, int j, char[][] grid, int[][] visit) {
        LinkedList<int[]> layer = new LinkedList<>();
        LinkedList<int[]> nextLayer = new LinkedList<>();
        layer.add(new int[]{i, j});

        while(layer.size() > 0) {
            int[] node = layer.poll();
            if (node[0]+1 < m && grid[node[0]+1][j] == '1' && visit[node[0]+1][j] == 0) {
                nextLayer.add(new int[]{node[0]+1, j});
                visit[node[0]+1][j] = 1;
            }
            if (node[1]+1 < n && grid[i][node[1]+1] == '1' && visit[i][node[1]+1] == 0) {
                nextLayer.add(new int[]{i, node[1]+1});
                visit[i][node[1]+1] = 1;
            }
            if (node[1]-1 >= 0 && grid[i][node[1]-1] == '1' && visit[i][node[1]-1] == 0) {
                nextLayer.add(new int[]{i, node[1]-1});
                visit[i][node[1]-1] = 1;
            }

            if (layer.size() == 0) {
                layer.addAll(nextLayer);
                nextLayer = new LinkedList<>();
            }
        }
    }
}
