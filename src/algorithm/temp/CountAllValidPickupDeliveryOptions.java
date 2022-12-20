package src.algorithm.temp;
public class CountAllValidPickupDeliveryOptions {
    int MOD = 1_000_000_007;
    public int countOrders(int n) {
        long res = helper(n, 0);

        return (int)(res % MOD);
    }

    public long helper(int leftP, int leftD) {
        long count = 0;
        if(leftP == 0) {
            return fact(leftD);
        }
        if(leftD == 0) {
            return leftP * helper(leftP-1, leftD+1);
        }
        count += leftP * helper(leftP-1, leftD+1);
        count += leftD * helper(leftP, leftD-1);
        return count;
    }

    public long fact(int n) {
        long num = 1;
        while(n!=0) {
            num *= n;
            n -= 1;
        }
        return num;
    }

    public static void main(String[] args) {
        int n = 8;
        int res = new CountAllValidPickupDeliveryOptions().countOrders(n);
        System.out.println(res);
    }
}
