import java.util.ArrayList;
import java.util.List;

public class DeleteColumnstoMakeSorted2 {
    int l;
    int n;
    String[] strs;
    int[] marks;
    public int minDeletionSize(String[] strs) {
        this.strs = strs;
        l = strs[0].length();
        n = strs.length;

        int count = 0;
        marks = new int[n];
        for (int i = 0; i < l ; i++) {
            if(!test(i))
                count += 1;
        }
        System.out.println(count);
        return count;
    }

    public boolean test(int i) {
        List<Integer> pass = new ArrayList<>();
        for (int j = 0; j < n-1; j++) {
            if (marks[j] == 1) continue;
            if (strs[j].charAt(i) < strs[j+1].charAt(i)) {
                pass.add(j);
            } else if (strs[j].charAt(i) == strs[j+1].charAt(i)) {
            } else {
                pass.clear();
                return false;
            }
        }

        for (Integer integer : pass) {
            marks[integer] = 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"vdy","vei","zvc","zld"};
        new DeleteColumnstoMakeSorted2().minDeletionSize(strs);
    }
}
