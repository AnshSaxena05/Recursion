import java.util.*;

class Recursion10 {

    //Subset Sums - 1 -> Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum.
    public static void main(String[] args) {

        int[] arr = {5,2,1};
        ArrayList<Integer> result = subsetSums(arr);
        System.out.println("Subset sums:");
        for (int sum : result) {
            System.out.print(sum + " ");
        }
    }

    public static ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        fun(0, 0, arr, ans);
        Collections.sort(ans);
        return ans;
    }

    public static void fun(int ind, int sum, int[] arr, ArrayList<Integer> ans) {
        if (ind == arr.length) {
            ans.add(sum);
            return;
        }

        // take
        sum = sum + arr[ind];
        fun(ind + 1, sum, arr, ans);

        // not take
        sum = sum - arr[ind];
        fun(ind + 1, sum, arr, ans);
    }
}


