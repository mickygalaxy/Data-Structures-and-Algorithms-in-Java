
//                                                   Sieve of Eratosthenes


import java.util.Arrays;
import java.util.Scanner;

public class Main implements sieve_of_eratosthenes{
    static Scanner sc = new Scanner(System.in);

    static public Boolean Check_isPrime(int a){
        for(int i=2;i*i<=a;i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }
    @Override
    public void NaiveMethod(int n) {  // Time Complexity 0(n*n^1/2)

        for(int i=2;i<=n;i++){
            if(Check_isPrime(i)){
                System.out.printf("%d ", i);
            }
        }
    }

    @Override
    public void Sieve_Of__Eratosthenes(int n) {  //Time Complexity 0(n*loglog(n))
      Boolean []Temp = new Boolean[n+1];
        Arrays.fill(Temp,true);
        for(int i=2;i<=n;i++){
            if(Check_isPrime(i)){
                continue;
            }
            else {
                Temp[i]=false;
            }
        }
        for(int i=2;i<=n;i++){
            if(Temp[i]){
            System.out.printf("%d ",i);
        }

    }}

        public static void main(String[] args) {
            System.out.printf("Enter the number :- ");
            int N = sc.nextInt();
            Main Obj = new Main();
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println("-: First Method :-");
            Obj.NaiveMethod(N);
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("-: Second Method by Sieve Of Eratosthenes :-");
            Obj.Sieve_Of__Eratosthenes(N);

        }
}