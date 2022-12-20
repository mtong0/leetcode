package src.algorithm.backtrack;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class No39 {
    int target = 0;
    List<Integer> candidates;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        res = new ArrayList<>();
        List<Integer> sortedCandidates = new ArrayList<>();
        for (int candidate : candidates) {
            sortedCandidates.add(candidate);
        }
        this.candidates = sortedCandidates.stream().sorted().collect(Collectors.toList());
        dfs(0, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int index, int sum, List<Integer> curr) {
        for (int i = index; i < candidates.size(); i++) {
            sum += candidates.get(i);
            if (sum < target) {
                curr.add(candidates.get(i));
                dfs(i, sum, curr);
                curr.remove(curr.size()-1);
                sum -= candidates.get(i);
            } else if (sum == target) {
                curr.add(candidates.get(i));
                res.add(new ArrayList<>(curr));
                curr.remove(curr.size()-1);
                sum -= candidates.get(i);
            }  else {
                sum -= candidates.get(i);
                break;
            }

        }
    }
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> sortedCandidates = new ArrayList<>();
//        for (int candidate : candidates) {
//            sortedCandidates.add(candidate);
//        }
//        sortedCandidates = sortedCandidates.stream().sorted().collect(Collectors.toList());
//
//        int p0 = 0;
//        int p1 = 1;
//        List<Integer> oneRes = new ArrayList<>();
//        int sum = sortedCandidates.get(p0);
//        oneRes.add(sortedCandidates.get(0));
//        while (p1 >= p0) {
//            if (sum == target) {
//                res.add(new ArrayList<>(oneRes));
//            }
//            if (sum <=target) {
//                if (p1 == sortedCandidates.size()) break;
//                sum += sortedCandidates.get(p1);
//                oneRes.add(sortedCandidates.get(p1));
//                p1++;
//            } else {
//                if (p0 == sortedCandidates.size()) break;
//                sum -= sortedCandidates.get(p0);
//                oneRes.remove(0);
//                p0++;
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        int[] candidates = {1,3,2,5};
        System.out.println(new No39().combinationSum(candidates, 5));
    }
}
