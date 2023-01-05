
//                                                       LCM OF TWO NUMBERS

import java.util.Scanner;
public class Main implements LCM {
    static Scanner sc = new Scanner(System.in);
    @Override
    public int lcm_of_two_number(int num1, int num2) {  // TIME COMPLEXITY - 0(A*B - MAX(A,B))
        int res = Math.max(num1,num2);
        int a;
        boolean b = true;
        while(b){
          if(res%num1 == 0 && res%num2==0){
            a= res;
            b=false;
                      }
          else{
           res++;
        }}
        return res;
    }

    @Override
    public int gcd(int num1, int num2) {
        if(num2==0){
            return num1;
        }
        return gcd(num2,num1%num2);
    }

    @Override
    public int Efficient_Way(int num1, int num2) {   //     TIME COMPLEXITY  0(LOG(MIN(A,B)))


        return (num1*num2)/gcd(num1,num2);
    }

    public static void main(String[] args) {
        Main a = new Main();

        System.out.printf("Enter the first number :- ");
        int n1 = sc.nextInt();
        System.out.printf("Enter the second number :- ");
        int n2 = sc.nextInt();
        System.out.println("\n-: method first :-\n");
        System.out.printf("LCM of two number is ");
        System.out.println(a.lcm_of_two_number(n1,n2));
        System.out.println("\n-: method Second :-\n");
        System.out.printf("LCM of two number is ");
        System.out.println(a.Efficient_Way(n1,n2));

    }
}