import java.util.Scanner;

public class Main implements All_Divisor_Of_a_Number{

    static Scanner sc = new Scanner(System.in);

    @Override
    public void Naive_Approach(int n) {   // Time Complexity 0(n)     and   Auxiliary Space 0(1)
        for(int i=1;i<=n;i++){
            if(n%i==0){
                System.out.println(i);
            }
        }

    }

    @Override
    public void Optimize_Approach(int n) {
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                System.out.println(i);
                if(i!=n/i){
                    System.out.println(n/i);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter the Number :- ");
        int n = sc.nextInt();
        Main Obj = new Main();
        System.out.print("\n-------------------------------------------------------------------------------------------\n");
        System.out.println("-: First Method :-");
        Obj.Naive_Approach(n);
        System.out.print("\n-------------------------------------------------------------------------------------------\n");
        System.out.println("-: Second Method :-");
        Obj.Optimize_Approach(n);
    }
}