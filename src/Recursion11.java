import java.util.*;

public class Recursion11 {
    public static ArrayList<ArrayList<Integer>> printUniqueSubsets(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        fun(0, nums, ans, new ArrayList<Integer>());
        return ans;
    }
    //method 1 using recursion + for loop
    public static void fun(int ind, int[] nums, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> arr) {
        res.add(new ArrayList<>(arr));

        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1]) continue;

            arr.add(nums[i]);
            fun(i + 1, nums, res, arr);
            arr.remove(arr.size() - 1);
        }
    }
    //Method 2 : Using Take and NotTake approach
    // public static void fun(int ind, int []nums, HashSet<ArrayList<Integer>> res, ArrayList<Integer> arr ){

    //     if(ind == nums.length){
    //         res.add(new ArrayList<>(arr));
    //         return;

    //     }

    //     //take
    //     arr.add(nums[ind]);
    //     fun(ind+1, nums, res, arr);

    //     //notTake
    //     arr.remove(arr.size() - 1);
    //     fun(ind+1 , nums, res, arr);

    // }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        ArrayList<ArrayList<Integer>> subsets = printUniqueSubsets(nums);

        System.out.println("Unique subsets:");
        for (ArrayList<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
