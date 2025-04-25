import java.util.ArrayList;
import java.util.List;

class Recursion12And13 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        ArrayList<Integer> curr= new ArrayList<>();

        //boolean freq[]= new boolean[nums.length]; //Only needed for Method 1
        //fun(nums,ans,curr,freq);

        fun(0,nums,ans, curr);
        return ans;
    }

    //Method 2: Recursion + Loop + Swap
    public static void fun(int ind, int []nums, List<List<Integer>> ans, ArrayList<Integer> curr){
        if(ind==nums.length){
            ans.add(new ArrayList(curr));
            return;
        }

        for(int i=ind;i<nums.length;i++){
            curr.add(nums[i]);
            swap(nums, ind, i);
            fun(ind+1,nums,ans,curr);
            swap(nums,ind, i);
            curr.remove(curr.size()-1);
        }
    }
    public static void swap(int []nums,int ind,int i){
        int temp= nums[ind];
        nums[ind]= nums[i];
        nums[i]=temp;
    }

    //Method 1: Recursion + Loop + Boolean array 
    // public static void fun(int []nums, List<List<Integer>> ans, ArrayList<Integer> curr, boolean freq[]){
    //     if(curr.size()== nums.length){
    //         ans.add(new ArrayList<>(curr));
    //         return;
    //     }

    //     for(int i=0;i<nums.length;i++){
    //         if(!freq[i]){
    //             freq[i]=true;
    //             curr.add(nums[i]);
    //             fun(nums,ans,curr,freq);
    //             freq[i]=false;
    //             curr.remove(curr.size()-1);
    //         }
    //     }

    // }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        // We will get n!(nums.length) permutations
        System.out.println(permute(nums));
    }
}