package src.algorithm.temp;
//import java.math.BigInteger;
//
//public class MinNonZeroProduct {
//    public int minNonZeroProduct(int p) {
//        public int minNonZeroProduct(int p) {
//            long MOD = 1_000_000_007;
//            long num1 = ((1L<<p)-2) % MOD;
//            long loop = ((1L<<(p-1))-1);
//            long num2 = ((1L<<p)-1);
//            BigInteger res;
//            BigInteger n1 = new BigInteger(String.valueOf(num1));
//            BigInteger n2 = new BigInteger(String.valueOf(num2));
//            BigInteger pow = new BigInteger(String.valueOf(loop));
//            BigInteger m = new BigInteger(String.valueOf(MOD));
//            res = n1.modPow(n2, m).multiply(n2).mod(m);
//            return res.intValue();
//        }
//    }
//
//    public static void main(String[] args) {
//        int res = new MinNonZeroProduct().minNonZeroProduct(1);
//        System.out.println();
//    }
//}
