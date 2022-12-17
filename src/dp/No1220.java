package src.dp;

public class No1220 {
    public int countVowelPermutation(int n) {
        int MOD = 1000000007;
        long[] line1 = {1, 1, 1, 1, 1};
        long[] line2 = new long[5];

        for (int i = 0; i < n; i++) {
            line2[0] = line1[1] % MOD;
            line2[1] = (line1[0] + line1[2]) % MOD;
            line2[2] = (line1[0] + line1[1] + line1[3] + line1[4]) % MOD;
            line2[3] = (line1[2] + line1[4]) % MOD;
            line2[4] = line1[0] % MOD;
            line1 = line2;
            line2 = new long[5];
        }

        long count = 0;
        for (int i = 0; i < 5; i++) {
            count = (count + line1[i]) % MOD;
        }
        return (int)count;
    }
}
