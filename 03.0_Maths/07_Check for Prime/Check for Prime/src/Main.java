
//                                                            Check for Prime


import java.util.Scanner;
public class Main implements PRIME{

    @Override
    public Boolean NaiveMethod(int n) {  // TIME COMPLEXITY 0(N)
        if( n == 1){
            return false;
        }
        for(int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
            return true;
    }

    @Override
    public Boolean isPrime(int num) {  // Time Complexity 0(sqt(n))
        if( num == 1){
            return false;
        }
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;

        }

    @Override
    public Boolean Efficient_way_isPrime(int num) {
        if(num<=1){
            return false;
        }
        if(num==2 || num ==3 || num==5){
            return true;
        }
        if(num%2==0 || num%3==0){
            return false;
        }
        for(int i = 5; true; i+=2){
            if(num%i!=0){
                return true;
            }
            return false;
        }
    }

    @Override
    public Boolean MORE_Efficient_way_isPrime(int num) {
        if(num<=1){
            return false;
        }
        if(num==2 || num ==3 || num==5){
            return true;
        }
        if(num%2==0 || num%3==0){
            return false;
        }
        for(int i = 5; i*i<=num; i+=6){
            if(num%i==0 || num%(i+2)==0){
                return false;
            }
        }
            return true;
    }

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Main a = new Main();
        System.out.println("Enter the number :- ");
        int n = sc.nextInt();
        System.out.println("\n-: method first :- ");
        if(a.NaiveMethod(n))
            System.out.println("It is a prime");
        else
            System.out.println("It is not a prime");
        System.out.println("-: method second :- ");
        if(a.isPrime(n))
            System.out.println("It is a prime");
        else
            System.out.println("It is not a prime");
        System.out.println("-: method third :- ");
        if(a.Efficient_way_isPrime(n))
            System.out.println("It is a prime");
        else
            System.out.println("It is not a prime");
        System.out.println("-: method fourth :- ");
        if(a.MORE_Efficient_way_isPrime(n))
            System.out.println("It is a prime");
        else
            System.out.println("It is not a prime");
    }
}