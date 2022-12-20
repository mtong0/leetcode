package src.dp;

import java.util.Arrays;

public class No1900 {
    int earliestRound = Integer.MAX_VALUE;
    int latestRound = Integer.MIN_VALUE;
    int firstPlayer;
    int secondPlayer;
    boolean[] visits;
    int n;
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        visits = new boolean[1<<n];
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.n = n;
        nextRound(n, (1<<n)-1, 1);
        return new int[]{earliestRound, latestRound};
    }

    // statusMask: left players
    public void nextRound(int roundPlayerNum, int statusMask, int round) {
        if (visits[statusMask]) return;

        visits[statusMask] = true;
        int matchNum = roundPlayerNum / 2;
        for (int i = 0; i < (1<<matchNum); i++) { // loop all match results
            int left = 0;
            int right = n-1;
            int matchIdx = 0;

            int tempStatusMask = statusMask;
            while (left < right) { //
                int leftStatus = getIthBit(tempStatusMask, n, left);
                int rightStatus = getIthBit(tempStatusMask, n, right);
                if (leftStatus == 1 && rightStatus == 1) {
                    if ((left == firstPlayer-1 && right == secondPlayer-1) || (left == secondPlayer-1 && right == firstPlayer-1)) {
                        earliestRound = Math.min(earliestRound, round);
                        latestRound = Math.max(latestRound, round);
                        return;
                    } else {
                        int matchResult = getIthBit(i, matchNum, matchIdx);
                        if (matchResult == 1) { //left win
                            if (right == firstPlayer-1 || right == secondPlayer-1) break;
                            tempStatusMask = setIthBit(tempStatusMask, n, right, 0);
                        } else { //right win
                            if (left == firstPlayer-1 || left == secondPlayer-1) break;
                            tempStatusMask = setIthBit(tempStatusMask, n, left, 0);
                        }
                        matchIdx ++;
                    }
                    left++;
                    right--;
                }
                if (leftStatus == 0) {
                    left ++;
                }
                if (rightStatus == 0) {
                    right --;
                }
            }
            if (left >= right)
                nextRound(roundPlayerNum-matchNum, tempStatusMask, round+1);
        }
    }

    public int getIthBit(int num, int length, int i) {
        return (num >> (length - i - 1)) & 1;
    }

    public int setIthBit(int num, int length, int i, int val) {
        int bitVal = 1 << (length-i-1);
        if (val == 1) {
            return num | bitVal;
        } else {
            return num & ((1<<length)- 1 - bitVal);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new No1900().earliestAndLatest(11, 2, 4)));
    }
}
