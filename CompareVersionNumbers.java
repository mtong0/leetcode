public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int minLength = Math.min(v1.length, v2.length);

        int n1;
        int n2;
        for (int i = 0; i < minLength; i++) {
            n1 = Integer.parseInt(v1[i]);
            n2 = Integer.parseInt(v2[i]);
            if (n1 > n2) return 1;
            if (n1 < n2) return -1;
        }

        int j = minLength;
        if (v1.length >= minLength) {
            while (j != v1.length) {
                if (Integer.parseInt(v1[j]) > 0)
                    return 1;
                j++;
            }
        }
        while (j < v2.length) {
            if (Integer.parseInt(v2[j]) > 0)
                return -1;
            j++;
        }
        return 0;
    }

    public static void main(String[] args) {
        new CompareVersionNumbers().compareVersion("1.0", "1");
    }
}
