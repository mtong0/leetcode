package src.algorithm.temp;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {
    int n;
    int[][] graph;
    int[][] steps;
    public int shortestPathLength(int[][] graph) {
        n = graph.length;
        this.graph = graph;
        steps = new int[n][1<<n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 1<<n; j++) {
                steps[i][j] = Integer.MAX_VALUE;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            bfs(i);
        }
        for(int i = 0; i < n; i++) {
            if (steps[i][(1<<n)-1] < min) min = steps[i][(1<<n)-1];
        }
        return min;
    }

    public void bfs(int start) {
        int bitmask = 0;
        bitmask |= 1 << start;

        Queue<Pair> rounds = new LinkedList<>();
        for(int i = 0; i < graph[start].length; i++) {
            rounds.add(new Pair(graph[start][i], bitmask));
        }

        Pair pair;

        int step = 0;
        Queue<Pair> nextRounds = new LinkedList<>();
        while(!rounds.isEmpty()) {
            pair = rounds.poll();
            pair.mask |= 1<<pair.node;
            if(step+1 < steps[pair.node][pair.mask]) {
                steps[pair.node][pair.mask] = step+1;
                for(int i = 0; i < graph[pair.node].length; i++) {
                    nextRounds.add(new Pair(graph[pair.node][i], pair.mask));
                }
            }

            if(rounds.isEmpty()) {
                rounds = new LinkedList<>(nextRounds);
                nextRounds.clear();
                step += 1;
            }
        }
    }

    class Pair {
        int node;
        int mask;
        Pair(int node, int mask) {
            this.node = node;
            this.mask = mask;
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2,3,4},{0,2},{0,1},{0,5},{0,6},{3},{4}};
        int step = new ShortestPathVisitingAllNodes().shortestPathLength(graph);
        System.out.println(step);
    }
}