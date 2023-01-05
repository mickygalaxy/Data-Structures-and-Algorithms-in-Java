

//                                                Factorial of a Number

// Time Complexity  T(n) = T(n-1) + 0(1)

import java.util.Scanner;

public class Main implements Recursive{

    static Scanner sc = new Scanner(System.in);

    @Override
    public int Factorial(int n) {
        if(n==1){
            return n;
        }
        return n*Factorial(n-1);

    }

    public static void main(String[] args)
    {   System.out.printf("Enter the number:- ");
        int number = sc.nextInt();
        Main a = new Main();
        System.out.printf("%d Factorial is %d",number,a.Factorial(number));
    }
}