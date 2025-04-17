import java.util.Scanner;

public class Recursion5 {

    // Print the nth fibonaci number
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter value for n :");
        int n= sc.nextInt();
        System.out.println("Nth fibo number - "+fib(n));
    }
    public static int fib(int n){
        if(n<=1){
            return n;
        }
        int last= fib(n-1);
        int slast= fib(n-2);
        return last+slast;
    }
}