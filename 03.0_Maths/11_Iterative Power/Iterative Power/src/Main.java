
//                                                          Iterative Power
// Iterative Java program
// to implement power(x, y)
import java.util.Scanner;

public class Main implements IterativePower{  // Time Complexity 0(log(n))

    @Override
    public int IPower(int x, int n) {
        // Initialize result
        int res = 1;
        while(n>0){
            // if n is odd,
            // multiply
            // x with result
            if((n & 1)==1){
                res = res*x;
            }

            // n must be even now
            x=x*x; // Change x to x^2
            n=n>>1; // n = n/2
        }
        return res;
    }

// Driver Code
    static  Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
       System.out.print("Enter the value of 'X' :- ");
       int x = sc.nextInt();
       System.out.print("Enter the value of 'N' :- ");
       int n = sc.nextInt();
       Main Obj = new Main();
       System.out.printf("Power(%d,%d) :- %d",x,n,Obj.IPower(x,n));
    }
}