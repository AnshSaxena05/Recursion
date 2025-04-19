import java.util.ArrayList;
import java.util.Collections;

public class Recursion7 {

    public static void main(String args[]){

        int num[]={1,2,1};
        int target= 2;
        System.out.println("Print the number of subsequence with sum equal to target - "+numSubseq(num,target));
    }
    //Print the number of subsequence with sum equal to target
    public static int numSubseq(int[] nums, int target) {

        ArrayList<Integer> arr = new ArrayList<>();

        for (int num : nums) {
            arr.add(num);
        }

        return fun(0,0,target,arr);
    }
    public static int fun(int ind,int sum,int target, ArrayList<Integer> arr){

        if(ind==arr.size()){
            if(sum==target){
                return 1;
            }
            return 0;
        }

        //take
        sum= sum+arr.get(ind);
        int take= fun(ind+1,sum,target,arr);

        //not take
        sum=sum-arr.get(ind);
        int notTake= fun(ind+1,sum,target,arr);

        return take+notTake;
    }

}
