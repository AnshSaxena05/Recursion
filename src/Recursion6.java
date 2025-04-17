import java.util.ArrayList;
import java.util.Arrays;

public class Recursion6 {
    public static void main(String args[]){
        ArrayList<Integer> arr= new ArrayList<>(Arrays.asList(3,1,2));

        ArrayList<Integer> empty= new ArrayList<>();
        fun(0,arr,arr.size(),empty);
    }

    //Print subsequence of the array
    public static void fun(int ind, ArrayList<Integer> arr, int len, ArrayList<Integer> empty){
        if(ind>=len){
            System.out.println(empty);
            return;
        }
        //take
        empty.add(arr.get(ind));
        fun(ind+1,arr,len,empty);
        //not take
        empty.remove(empty.size()-1);
        fun(ind+1,arr,len,empty);
    }
}
