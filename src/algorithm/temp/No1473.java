package src.algorithm.temp;

public class No1473 {
    int[] houses;
    int[][] cost;
    int h;
    int c;
    int target;
    int[][][] mem;
    public int minCost(int[] houses, int[][] cost, int h, int c, int target) {
        this.houses = houses;
        this.cost = cost;
        this.h = h;
        this.c = c;
        this.target = target;

        mem = new int[h][c+1][target+1];

        return helper(0, 0, 0);
    }

    public int helper(int index, int prevColor, int prevNeighbour) {
        if (index == h) { //reach the end
            if (prevNeighbour == target) {
                return 0;
            } else
                return -1;
        }
        if (prevNeighbour > target) { //
            return -1;
        }

        int neighbour, color, curCost;
        int nextCost = -1;
        if (houses[index] != 0) { //the house is painted
            neighbour = prevColor == houses[index] ? prevNeighbour : prevNeighbour+1;
            if (neighbour > target) return -1;
            color = houses[index];
            if(mem[index][color][neighbour] > 0) {
                return mem[index][color][neighbour];
            } else if (mem[index][color][neighbour] == -1)  {
                return -1;
            } else {
                nextCost = helper(index+1, color, neighbour);
                if(nextCost == -1) {
                    mem[index][color][neighbour] = -1;
                    return -1;
                } else {
                    mem[index][color][neighbour] = nextCost;
                    return nextCost;
                }
            }
        } else {
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i < c; i++) { // loop all the color
                color = i+1;
                curCost = cost[index][i];
                if(color == prevColor) {
                    neighbour = prevNeighbour;
                } else {
                    neighbour = prevNeighbour + 1;
                }
                if (neighbour > target) continue;
                if(mem[index][i][neighbour] > 0) {
                   minCost = Math.min(mem[index][i][neighbour], minCost);
                } else if (mem[index][i][neighbour] == 0)
                    nextCost = helper(index+1, color, neighbour);
                    if (nextCost != -1) {
                        mem[index][i][neighbour] = nextCost + curCost;
                        minCost = Math.min(mem[index][i][neighbour], minCost);
                    }
                }
                if (minCost == Integer.MAX_VALUE) {
                    return -1;
                }
            return minCost;
        }

    }

    public static void main(String[] args) {
        No1473 no1473 = new No1473();
        int[] houses = {3,1,2,3};
        int[][] costs = {{1,1,1},{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(no1473.minCost(houses, costs, 4, 3, 3));
    }
}