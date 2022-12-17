package src;

import java.util.ArrayList;
import java.util.List;

public class No1992 {
    int[][] visited;
    int[][] land;
    public int[][] findFarmland(int[][] land) {
        List<int[]> res = new ArrayList<>();
        this.land = land;
        visited = new int[land.length][land[0].length];

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (visited[j][j] == 0 && land[i][j] == 1)
                    res.add(findGroup(i, j));
            }
        }
        int[][] r = new int[res.size()][4];
        return res.toArray(r);
    }

    public int[] findGroup(int i, int j) {
         int x = i;
         int y = j;
         while (land[x][y] != 0) {
             y++;
             visited[x][y] = 1;
         }

         int lineEnd = y-1;
         x = x + 1;
         while (land[x][j] != 0) {
             y = j;
             for (; y <= lineEnd; y++) {
                 visited[x][y] = 1;
             }
             x++;
         }
         return new int[]{i, j, x - 1, lineEnd};
    }
}
