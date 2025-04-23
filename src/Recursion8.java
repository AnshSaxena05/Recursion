import java.util.ArrayList;
import java.util.List;

public class Recursion8 {

    //https://leetcode.com/problems/combination-sum/submissions/1615820783/
    //Combination Sum
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] candidates = {2, 3, 6, 7};
        int target = 6;

        List<List<Integer>> result = solution.combinationSum(candidates, target);

        System.out.println("Combinations that sum up to " + target + ":");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidate, int target) {
        List<List<Integer>> sumarr = new ArrayList<>();
        fun(0, candidate, 7, new ArrayList<>(), sumarr);
        return sumarr;
    }

    private void fun(int ind, int[] candidate, int target, ArrayList<Integer> curr, List<List<Integer>> sumarr) {
        if (ind == candidate.length) {
            if (target == 0) {
                sumarr.add(new ArrayList<>(curr));  // Create a deep copy to avoid reference issues
            }
            return;
        }
        if (target == 0) {
            sumarr.add(new ArrayList<>(curr));  // Create a deep copy to avoid reference issues
            return;
        }

        // Take
        if (target >= candidate[ind]) {
            curr.add(candidate[ind]);
            fun(ind, candidate, target - candidate[ind], curr, sumarr);
            curr.removeLast(); // Backtrack
        }

        // NotTake
        fun(ind + 1, candidate, target, curr, sumarr);
    }
}
