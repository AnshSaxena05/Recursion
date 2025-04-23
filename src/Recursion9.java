import java.util.*;

public class Recursion9 {

    // Similar to Combination Sum 2 but, no repetition of subsequences
    public List<List<Integer>> combinationSum2(int[] candidate, int target) {
        Arrays.sort(candidate);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        fun(0, target, candidate, ans, new ArrayList<>());
        return ans;
    }

    public static void fun(int ind, int target, int[] candidate, ArrayList<List<Integer>> ans, ArrayList<Integer> curr) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = ind; i < candidate.length; i++) {
            if (i > ind && candidate[i] == candidate[i - 1]) continue;
            if (target < candidate[i]) break;

            curr.add(candidate[i]);
            fun(i + 1, target - candidate[i], candidate, ans, curr);
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        Recursion9 sol = new Recursion9();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> result = sol.combinationSum2(candidates, target);

        System.out.println("Combinations that sum to " + target + ":");
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
