import java.util.*;

public class MaximumPathQualityOfAGraph {
    int[] shortestPath;
    boolean[] visited;
    int maxValue;
    int maxTime;
    int[] values;
    List<List<int[]>> map;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        shortestPath = new int[values.length];
        visited = new boolean[values.length];
        this.maxTime = maxTime;
        this.values = values;
        map = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            map.add(new ArrayList<>());
            shortestPath[i] = Integer.MAX_VALUE;
        }
        shortestPath[0] = 0;

        for (int[] edge: edges) {
            map.get(edge[0]).add(new int[]{edge[1], edge[2]});
            map.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        Queue<int[]> currentLayer = new LinkedList<>();
        Queue<int[]> nextLayer = new LinkedList<>();

        currentLayer.add(new int[]{0,0});

        int[] node;
        int path;
        int nodeIndex;
        int childPath;
        while (currentLayer.size() > 0) {
            node = currentLayer.poll();
            nodeIndex = node[0];
            path = node[1];
            for (int[] child: map.get(nodeIndex)) {
                childPath = path + child[1];
                if (childPath < shortestPath[child[0]]) {
                    shortestPath[child[0]] = childPath;
                    nextLayer.add(new int[]{child[0], childPath});
                }
            }
            if (currentLayer.size() == 0) {
                currentLayer.addAll(nextLayer);
                nextLayer.clear();
            }
        }

        visited[0] = true;
        dfs(0, values[0], 0);
        return maxValue;
    }

    public void dfs(int node, int currentVal, int totalLength) {
        if (totalLength + shortestPath[node] > maxTime) return;
        for (int[] child: map.get(node)) {
            boolean flag = false;
            if (totalLength + child[1] + shortestPath[child[0]]> maxTime) return;
            else {
                totalLength += child[1];
                if (!visited[child[0]]) {
                    currentVal += values[child[0]];
                    if (currentVal > maxValue) maxValue = currentVal;
                    visited[child[0]] = true;
                    flag = true;
                }
            }
            dfs(child[0], currentVal, totalLength);
            if (flag) {
                visited[child[0]] = false;
                currentVal -= values[child[0]];
            }
        }
    }

    public static void main(String[] args) {
        int[] values = {5,10,15,20};
        int[][] edges = {{0,1,10},{1,2,10},{0,3,10}};
        int maxTime = 30;
        System.out.println(new MaximumPathQualityOfAGraph().maximalPathQuality(values, edges, maxTime));
    }
}
