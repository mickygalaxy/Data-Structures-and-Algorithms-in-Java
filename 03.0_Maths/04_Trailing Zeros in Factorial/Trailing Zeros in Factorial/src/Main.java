
//                                          Trailing Zeros in Factorial



import java.util.Scanner;

public class Main implements Trailing_Zeros_in_Factorial {

    static Scanner sc = new Scanner(System.in); 
    @Override
    public int trailingZeroIn_Factorial(int n) {        // Time Complexity 0(n)

        int ans=1;
        for(int i=1;i<=n;i++){
            ans*=i;
        }
        int TrailingZero=0;
        while(ans%10==0){
            TrailingZero++;
            ans/=10;
        }
        return TrailingZero;
    }

    @Override
    public int efficient_trailingZero_Factorial(int n) {      // Time Complexity 0(log n)
        int ans=0;
        for(int i=5;i<=n;i*=5){
            ans+=n/i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.printf("Enter the number :-");
        int number = sc.nextInt();
        Main a = new Main();
        System.out.println("Number of Trailing Zero is "+a.trailingZeroIn_Factorial(number));
        System.out.printf("\n   -: Efficient Way Trailing Zero :-\n");
        System.out.println("Number of Trailing Zero is "+a.efficient_trailingZero_Factorial(number));

    }
}
